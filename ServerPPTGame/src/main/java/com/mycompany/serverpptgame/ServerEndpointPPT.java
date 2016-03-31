/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serverpptgame;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mycompany.datapptgame.OpcionJuego;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.datapptgame.MetaMessage;
import com.mycompany.datapptgame.TypeMessage;
import com.mycompany.datapptgame.GameType;
import com.mycompany.modelpptgame.Partida;
import com.mycompany.datapptgame.Player;
import com.mycompany.datapptgame.RoundsNumber;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author ivanp
 */
@ServerEndpoint(value = "/ppt")
public class ServerEndpointPPT {
    
    // <editor-fold defaultstate="collapsed" desc="METODOS WEBSOCKET">
    @OnOpen
    public void onOpen(Session s, EndpointConfig config) {
        Player p = new Player();
        p.setNumberOfRounds(RoundsNumber.NONE);
        p.setTipoJuego(GameType.NONE);
        p.setPlaying(false);
        p.setNamePlayer(s.getRequestParameterMap().get("user").get(0));
        s.getUserProperties().put("player", p);
    }

    @OnClose
    public void onClose(Session s) {

    }

    
    @OnMessage
    public void echoText(String msg, Session s) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            MetaMessage meta = mapper.readValue(msg, new TypeReference<MetaMessage>() {
            });
            Player p = (Player) s.getUserProperties().get("player");
            switch (meta.getType()) {
                case CONEXION:
                    Player recogida = mapper.readValue(mapper.writeValueAsString(meta.getContent()), new TypeReference<Player>() {});
                    p.setNumberOfRounds(recogida.getNumberOfRounds());
                    p.setTipoJuego(recogida.getTipoJuego());
                    search(s, p, mapper);
                    break;
                case PARTIDA:
                    OpcionJuego opcion=mapper.readValue(mapper.writeValueAsString(meta.getContent()), new TypeReference<OpcionJuego>() {});
                    enviarEleccion(p.getNamePlayer(),opcion,s, mapper, encuentraPartida(p.getNamePlayer(), s));
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerEndpointPPT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="METODOS FUNCIONALIDADES">
    public Partida encuentraPartida(String nombre,Session s){
        ArrayList <Session> sesiones=new ArrayList(s.getOpenSessions());
        boolean sal=false;
        Partida partida=null;
        for(int i=0;i<sesiones.size()&&!sal;i++){
            if(((Player)sesiones.get(i).getUserProperties().get("player")).getNamePlayer().equals(nombre)){
                partida=(Partida)sesiones.get(i).getUserProperties().get("partida");
                sal=true;
            }
        }
        return partida;
    }
    
    public void enviarEleccion(String nombre,OpcionJuego opcion,Session s,ObjectMapper mapper,Partida partida){
        String nombreObjetivo;
        if(partida.getJugadores().get(0).getNamePlayer().equals(nombre)){
            nombreObjetivo=partida.getJugadores().get(1).getNamePlayer();
        }else{
            nombreObjetivo=partida.getJugadores().get(0).getNamePlayer();
        }
        boolean sal=false;
        ArrayList <Session> sesiones=new ArrayList(s.getOpenSessions());
        for(int i=0;i<sesiones.size()&&!sal;i++){
            if(((Player)sesiones.get(i).getUserProperties().get("player")).getNamePlayer().equals(nombreObjetivo)){
                MetaMessage mm=new MetaMessage();
                mm.setType(TypeMessage.RESPUESTA);
                mm.setContent(opcion);
                String mmString;
                try {
                    mmString = mapper.writeValueAsString(mm);
                    sesiones.get(i).getBasicRemote().sendText(mmString);
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(ServerEndpointPPT.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ServerEndpointPPT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void search(Session ses, Player n,ObjectMapper mapper) {
        Partida p=null;
        boolean sal=false;
        ArrayList<Session> sessions=new ArrayList(ses.getOpenSessions());
        for(int i=0;i<ses.getOpenSessions().size()&&!sal;i++){
            try {
                Player player=(Player)sessions.get(i).getUserProperties().get("player");
                if(encuentraPartida(player, n)){
                    sal=true;
                    p=new Partida();
                    p.addPlayer(player);
                    p.addPlayer(n);
                }
                MetaMessage mm=new MetaMessage();
                mm.setType(TypeMessage.RESPUESTA);
                mm.setContent(player.getNamePlayer());
                String mmString=mapper.writeValueAsString(mm);
                sessions.get(i).getBasicRemote().sendText(mmString);
            } catch (IOException ex) {
                Logger.getLogger(ServerEndpointPPT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ses.getUserProperties().put("partida", p);
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CONDICIONES BÚSQUEDA PARTIDA">
    public boolean comparaNombres(String n1,String n2){
        return n1.equals(n2);
    }
    
    public boolean comparaRondas(RoundsNumber rn1,RoundsNumber rn2){
        return rn1==rn2||rn1==RoundsNumber.ANY||rn2==RoundsNumber.ANY;
    }
    
    public boolean comparaDosAnyRounds(RoundsNumber rn1,RoundsNumber rn2){
        return rn1==RoundsNumber.ANY&&rn2==RoundsNumber.ANY;
    }
    
    public boolean comprobacionComunRounds(RoundsNumber rn1,RoundsNumber rn2){
        return (comparaRondas(rn1,rn2)&&!comparaDosAnyRounds(rn1,rn2));
    }
    
    public boolean comparaGameTypes(GameType gt1,GameType gt2){
         return gt1==gt2||gt1==GameType.ANY||gt2==GameType.ANY;
    }
    
    public boolean comparaDosAnyGameTypes(GameType gt1,GameType gt2){
        return gt1==GameType.ANY&&gt2==GameType.ANY;
    }
    
    public boolean comprobacionComunGameTypes(GameType gt1,GameType gt2){
        return (comparaGameTypes(gt1,gt2)&&!comparaDosAnyGameTypes(gt1,gt2));
    }
    
    public boolean encuentraPartida(Player player,Player n){
        return !comparaNombres(player.getNamePlayer(), n.getNamePlayer())&&comprobacionComunRounds(player.getNumberOfRounds(), n.getNumberOfRounds())
                    &&comprobacionComunGameTypes(player.getTipoJuego(), n.getTipoJuego());
    }
    // </editor-fold>
}

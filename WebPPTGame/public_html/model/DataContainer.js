/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
var imported = document.createElement('script');
imported.src = '/model/EnumFichas3';
document.head.appendChild(imported);

var imported2 = document.createElement('script');
imported2.src = '/model/EnumFichas5';
document.head.appendChild(imported2);

var imported3 = document.createElement('script');
imported3.src = '/model/EnumFichas9';
document.head.appendChild(imported3);
*/
DataContainer = function(){
    var roundsCounter;
    var roundsLimit;
    var victoriesP1;
    var victoriesP2;
    var turno;
    var modalidadJuego;
    var enumChosen1=new EnumChosen();
    var enumChosen2=new EnumChosen();;
    var factorAlgoritmo;
    var idImgPulsada1;
    var idImgPulsada2;
    var nombreJ1;
    var nombreJ2;
    var jugando;
    var mapFichas;
    var mapFichasMaquina;
    
    this.initialize=function(){
        inicializaMapFichas();
        inicializaMapFichasMaquina();
        inicializaMapImagesAzul();
        inicializaMapImagesRojo();
    };
    
    this.dataContainer=function(contRondas,limRondas,vP1,vP2,turn,modoJuego,chosen1,chosen2,factorAlg,idImg1,idImg2,nJ1,nJ2,playing,mapF,mapFMaq){
        roundsCounter=contRondas;
        roundsLimit=limRondas;
        victoriesP1=vP1;
        victoriesP2=vP2;
        turno=turn;
        modalidadJuego=modoJuego;
        enumChosen1=chosen1;
        enumChosen2=chosen2;
        factorAlgoritmo=factorAlg;
        idImgPulsada1=idImg1;
        idImgPulsada2=idImg2;
        nombreJ1=nJ1;
        nombreJ2=nJ2;
        jugando=playing;
        mapFichas=mapF;
        mapFichasMaquina=mapFMaq;
    };
    
    this.getRoundsCounter=function(){
        return roundsCounter;
    };
    this.getRoundsLimit=function(){
        return roundsLimit;
    };
    this.getVictoriesP1=function(){
        return victoriesP1;
    };
    this.getVictoriesP2=function(){
        return victoriesP2;
    };
    this.isTurno=function(){
        return turno;
    };
    this.getModalidadJuego=function(){
        return modalidadJuego;
    };
    this.getEnumChosen1=function(){
        return enumChosen1;
    };
    this.getEnumChosen2=function(){
        return enumChosen2;
    };
    this.getFactorAlgoritmo=function(){
        return factorAlgoritmo;
    };
    this.getIdImgPulsada1=function(){
        return idImgPulsada1;
    };
    this.getIdImgPulsada2=function(){
        return idImgPulsada2;
    };
    this.getNombreJ1=function(){
        return nombreJ1;
    };
    this.getNombreJ2=function(){
        return nombreJ2;
    };
    this.isJugando=function(){
        return roundsCounter;
    };
    this.getMapFichas=function(){
        return mapFichas;
    };
    this.getMapFichasMaquina=function(){
        return mapFichasMaquina;
    };
    
    this.setRoundsCounter=function(contRondas){
        roundsCounter=contRondas;
    };
    this.setRoundsLimit=function(limRondas){
        roundsLimit=limRondas;
    };
    this.setVictoriesP1=function(vP1){
        victoriesP1=vP1;
    };
    this.setVictoriesP2=function(vP2){
        victoriesP2=vP2;
    };
    this.setTurno=function(turn){
        turno=turn;
    };
    this.setModalidadJuego=function(modoJuego){
        modalidadJuego=modoJuego;
    };
    this.setEnumChosen1=function(chosen1){
        enumChosen1=chosen1; 
    };
    this.setEnumChosen2=function(chosen2){
        enumChosen2=chosen2;
    };
    this.setFactorAlgoritmo=function(factorAlg){
        factorAlgoritmo=factorAlg;
    };
    this.setIdImgPulsada1=function(idImg1){
        idImgPulsada1=idImg1;
    };
    this.setIdImgPulsada2=function(idImg2){
        idImgPulsada2=idImg2;
    };
    this.setNombreJ1=function(nJ1){
        nombreJ1=nJ1;
    };
    this.setNombreJ2=function(nJ2){
        nombreJ2=nJ2;
    };
    this.setJugando=function(playing){
        jugando=playing;
    };
    this.setMapFichas=function(mapF){
        mapFichas=mapF;
    };
    this.setMapFichasMaquina=function(mapFMaq){
        mapFichasMaquina=mapFMaq;
    };
    
    this.inicializaMapFichas=function(){
        var fichas3=new EnumFichas3().getFichas3();
        var fichas5=new EnumFichas5().getFichas5();
        var fichas9=new EnumFichas9().getFichas9();
        mapFichas={
            "PAPEL5": fichas5[1],
            "SPOCK5": fichas5[2],
            "PIEDRA5": fichas5[3],
            "TIJERA5": fichas5[4],
            "LAGARTO5": fichas5[5],
            "PAPEL9": fichas9[1],
            "AIRE": fichas9[2],
            "AGUA": fichas9[3],
            "PISTOLA": fichas9[4],
            "PIEDRA9": fichas9[5],
            "FUEGO": fichas9[6],
            "TIJERA9": fichas9[7],
            "HUMANO": fichas9[8],
            "ESPONJA": fichas9[9],
            "PIEDRA3": fichas3[1],
            "PAPEL3": fichas3[2],
            "TIJERA3": fichas3[3]
        };
        return mapFichas;
    };
    
    this.inicializaMapFichasMaquina=function(){
        mapFichasMaquina={
            "PAPEL":"papelAzul",
            "SPOCK":"spockazul",
            "PIEDRA":"piedraazul",
            "TIJERA":"tijerasazul",
            "LAGARTO":"lizardazul",
            "AIRE":"windazul",
            "AGUA":"waterazul",
            "PISTOLA":"gunazul",
            "FUEGO":"fireazul",
            "HUMANO":"humanazul",
            "ESPONJA":"spongeazul"
        };
        return mapFichasMaquina;
    };
    
    this.inicializaMapImagesAzul=function(){
        var mapImagesAzul={
            "PAPEL5":"papelazul",
            "SPOCK5":"spockazul",
            "PIEDRA5":"piedraazul",
            "TIJERA5":"tijerasazul",
            "LAGARTO5":"lizardazul",
            "PAPEL9":"windazul",
            "AIRE9":"windazul",
            "AGUA":"waterazul",
            "PISTOLA":"gunazul",
            "PIEDRA9":"piedraazul",
            "FUEGO":"fireazul",
            "TIJERA9":"tijerasazul",
            "HUMANO":"humanazul",
            "ESPONJA":"spongeazul",
            "PAPEL3":"papelazul",
            "PIEDRA":"piedraazul",
            "TIJERA3":"tijerasazul"
        };
        return mapImagesAzul;
    };
    
    this.inicializaMapImagesRojo=function(){
        var mapImagesAzul={
            "PAPEL5":"papelrojo",
            "SPOCK5":"spockrojo",
            "PIEDRA5":"piedraroja",
            "TIJERA5":"tijerasrojo",
            "LAGARTO5":"lizardrojo",
            "PAPEL9":"windrojo",
            "AIRE9":"windrojo",
            "AGUA":"waterrojo",
            "PISTOLA":"gunrojo",
            "PIEDRA9":"piedraroja",
            "FUEGO":"firerojo",
            "TIJERA9":"tijerasrojo",
            "HUMANO":"humanrojo",
            "ESPONJA":"spongerojo",
            "PAPEL3":"papelrojo",
            "PIEDRA":"piedraroja",
            "TIJERA3":"tijerasrojo"
        };
        return mapImagesAzul;
    };
    
    this.cambiaTurno=function(){
        turno=!turno;
    };
    
    this.avanzaRonda=function(){
        return roundsCounter++;
    };
    
    this.rondasFinalizadas=function(){
        return roundsCounter==roundsLimit;
    };
    
    this.getOrdinalChosen1=function(){
        return enumChosen1.getOrdinal();
    };
    
    this.getOrdinalChosen2=function(){
        return enumChosen2.getOrdinal();
    };
    
    this.setOrdinalChosen1=function(ord){
        enumChosen1.setOrdinal(ord);
    };
    
    this.setOrdinalChosen2=function(ord){
        enumChosen2.setOrdinal(ord);
    };
    
    this.getNameChosen1=function(){
        return enumChosen1.getName();
    };
    
    this.getNameChosen2=function(){
        return enumChosen2.getName();
    };
    
    this.setNameChosen1=function(name){
        enumChosen1.setName(name);
    };
    
    this.setNameChosen2=function(name){
        enumChosen2.setName(name);
    };
    
    this.sumaVictoriesP1=function(){
        victoriesP1++;
    };
    
    this.sumaVictoriesP2=function(){
        victoriesP2++;
    };
};


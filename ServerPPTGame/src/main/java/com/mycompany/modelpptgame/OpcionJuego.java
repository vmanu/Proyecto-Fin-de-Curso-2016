/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelpptgame;

/**
 *
 * @author ivanp
 */
public class OpcionJuego {
    private int opcion;
    private String gana;

    public OpcionJuego() {
    }

    public OpcionJuego(int opcion, String gana) {
        this.opcion = opcion;
        this.gana = gana;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public String getGana() {
        return gana;
    }

    public void setGana(String gana) {
        this.gana = gana;
    }

    @Override
    public String toString() {
        return "OpcionJuego{" + "opcion=" + opcion + ", gana=" + gana + '}';
    }
    
    
}

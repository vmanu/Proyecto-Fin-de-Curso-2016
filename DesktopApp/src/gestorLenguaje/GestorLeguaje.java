/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorLenguaje;

import constantes.*;

/**
 *
 * @author Victor
 */
public class GestorLeguaje {
    public static Class getLibrary(){
        String lang=System.getProperty("user.language"); 
        System.out.println("lang is: "+lang);
        Class clase;
        switch(lang){
            case "en":
                clase=English.class;
                break;
            case "es":
                clase=Castellano.class;
                break;
            default: 
                clase=English.class;
        }
        return clase;
    }
}

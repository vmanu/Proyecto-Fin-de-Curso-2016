/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Dao;

/**
 *
 * @author ivanp
 */
public class ServicesPlayers {
    
    public boolean addVictories(String player){
        Dao dao=new Dao();
        return dao.addVictories(player);
    }
}

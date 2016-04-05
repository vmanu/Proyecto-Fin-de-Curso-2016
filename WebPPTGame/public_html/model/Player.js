/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

Player = function(){
    var login;
    var GameType;
    var RoundsNumber;
    var playing;
    var numPartidas;
    
    this.player=function(nombre, gt, rn, jugando, num){
        login=nombre;
        GameType=gt;
        RoundsNumber=rn;
        playing=jugando;
        numPartidas=num;
    };
    
    this.getLogin=function(){
        return login;
    };
    
    this.getGameType=function(){
        return GameType;
    };
    
    this.getRoundsNumber=function(){
        return RoundsNumber;
    };
    
    this.isPlaying=function(){
        return playing;
    };
    
    this.getNumPartidas=function(){
        return numPartidas;
    };
    
    this.setLogin=function(nombre){
        login=nombre;
    };
    
    this.setGameType=function(gt){
        GameType=gt;
    };
    
    this.setRoundsNumber=function(rn){
        RoundsNumber=rn;
    };
    
    this.setPlaying=function(jugando){
        playing=jugando;
    };
    
    this.setNumPartidas=function(num){
        numPartidas=num;
    };
    
};


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

Player = function () {
    /*
     var login;
     var GameType;
     var RoundsNumber;
     var playing;
     var numPartidas;
     */
    var player = {
        namePlayer: "",
        tipoJuego: new GameType(),
        numberOfRounds: new RoundsNumber(),
        playing: "",
        numPartidas: ""
    };

    this.playerConstructor = function (nombre, gt, rn, jugando, num) {
        player = {
            namePlayer: nombre,
            tipoJuego: gt,
            numberOfRounds: rn,
            playing: jugando,
            numPartidas: num
        };
    };
    
    this.getPlayer=function(){
        return player;
    };
    /*
    
    this.getGameType = function () {
        return player.GameType;
    };

    this.getRoundsNumber = function () {
        return player.RoundsNumber;
    };

    this.isPlaying = function () {
        return player.playing;
    };

    this.getNumPartidas = function () {
        return player.numPartidas;
    };

    this.setLogin = function (nombre) {
        player.login = nombre;
    };

    this.setGameType = function (gt) {
        player.GameType = gt;
    };

    this.setRoundsNumber = function (rn) {
        player.RoundsNumber = rn;
    };

    this.setPlaying = function (jugando) {
        player.playing = jugando;
    };

    this.setNumPartidas = function (num) {
        player.numPartidas = num;
    };
    */
};


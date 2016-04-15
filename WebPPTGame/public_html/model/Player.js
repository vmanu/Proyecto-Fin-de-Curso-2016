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
};


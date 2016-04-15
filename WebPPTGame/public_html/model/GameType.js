/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
GameType = function () {
    var gameType = {
        JUEGO3: {name: "JUEGO3", ordinal: 0},
        JUEGO5: {name: "JUEGO5", ordinal: 1},
        JUEGO9: {name: "JUEGO9", ordinal: 2},
        ANY: {name: "ANY", ordinal: 3},
        NONE: {name: "NONE", ordinal: 4}
    };

    this.getGameType = function () {
        return gameType;
    };
};


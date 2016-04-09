/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
GameType = function () {
    var gameType = {
        1: {name: "JUEGO3", ordinal: 1},
        2: {name: "JUEGO5", ordinal: 2},
        3: {name: "JUEGO9", ordinal: 3},
        4: {name: "ANY", ordinal: 4},
        5: {name: "NONE", ordinal: 5}
    };

    this.getGameType = function () {
        return gameType;
    };
};


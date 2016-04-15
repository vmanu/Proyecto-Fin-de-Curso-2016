/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
RoundsNumber = function () {
    var roundsNumber = {
        UNA: {name: "UNA", ordinal: 0},
        TRES: {name: "TRES", ordinal: 1},
        CINCO: {name: "CINCO", ordinal: 2},
        ANY: {name: "ANY", ordinal: 3},
        NONE: {name: "NONE", ordinal: 4}
    };

    this.getRoundsNumber = function () {
        return roundsNumber;
    };
};


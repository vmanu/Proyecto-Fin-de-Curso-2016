/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
RoundsNumber = function () {
    var roundsNumber = {
        UNA: {name: "UNA", ordinal: 1},
        TRES: {name: "TRES", ordinal: 2},
        CINCO: {name: "CINCO", ordinal: 3},
        ANY: {name: "ANY", ordinal: 4},
        NONE: {name: "NONE", ordinal: 5}
    };

    this.getRoundsNumber = function () {
        return roundsNumber;
    };
};


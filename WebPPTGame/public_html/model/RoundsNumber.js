/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
RoundsNumber = function () {
    var roundsNumber = {
        1: {name: "UNA", ordinal: 1},
        2: {name: "TRES", ordinal: 2},
        3: {name: "CINCO", ordinal: 3},
        4: {name: "ANY", ordinal: 4},
        5: {name: "NONE", ordinal: 5}
    };

    this.getRoundsNumber = function () {
        return roundsNumber;
    };
};


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
EnumChosen = function () {
    var ordinal;
    var name;

    this.getOrdinal = function () {
        return ordinal;
    };
    this.setOrdinal = function (ord) {
        ordinal=ord;
    };

    this.getName = function () {
        return name;
    };
    this.setName = function (nm) {
        name=nm;
    };

};


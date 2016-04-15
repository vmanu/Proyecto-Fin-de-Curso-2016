/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ModalidadJuego = function () {
    var modalidad = {
        UNO: {name: "UNO", ordinal: 0},
        DOS: {name: "DOS", ordinal: 1},
        ONLINE: {name: "ONLINE", ordinal: 2}
    };

    this.getModalidad = function () {
        return modalidad;
    };
};


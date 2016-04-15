/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
TypeMessage=function(){
    var TypeMessage={
        CONEXION: {name: "CONEXION", ordinal: 0},
        PARTIDA: {name: "PARTIDA", ordinal: 1},
        RESPUESTA: {name: "RESPUESTA", ordinal: 2},
        DESCONEXION: {name: "DESCONEXION", ordinal: 3},
        NOMBRE: {name: "NOMBRE", ordinal: 4}
    };
    
    this.getTypeMessage=function(){
        return TypeMessage;
    };
};


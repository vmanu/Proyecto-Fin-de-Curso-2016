/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
TypeMessage=function(){
    var TypeMessage={
        CONEXION: {name: "CONEXION", ordinal: 1},
        PARTIDA: {name: "PARTIDA", ordinal: 2},
        RESPUESTA: {name: "RESPUESTA", ordinal: 3},
        DESCONEXION: {name: "DESCONEXION", ordinal: 4},
        NOMBRE: {name: "NOMBRE", ordinal: 5}
    };
    
    this.getTypeMessage=function(){
        return TypeMessage;
    };
};


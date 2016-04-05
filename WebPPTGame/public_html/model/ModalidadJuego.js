/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ModalidadJuego=function(){
    var modalidad={
        UNO:1, DOS:2, ONLINE:3,
        properties:{
            1:{name:"uno",ordinal:1},
            1:{name:"dos",ordinal:2},
            1:{name:"online",ordinal:3}
        }
    };
    
    this.getModalidad=function(){
        return modalidad;
    };
};


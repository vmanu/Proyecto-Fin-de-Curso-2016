/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
OpcionJuego=function(){
    var result = new Result().getResult();
    var opcion;
    
    this.getResult=function(){
        return result;
    };
    
    this.getOpcion=function(){
        return opcion;
    };
    
    this.setResult=function(res){
        result=res;
    };
    
    this.setOpcion=function(opc){
        opcion=opc;
    };
};


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
MetaMessage=function(){
    var typeMessage=new TypeMessage().getTypeMessage();
    var content;
    
    this.getTypeMessage=function(){
        return typeMessage;
    };
    
    this.getContent=function(){
        return content;
    };
    
    this.setTypeMessage=function(tm){
        typeMessage=tm;
    };
    
    this.setContent=function(c){
        content=c;
    };
};


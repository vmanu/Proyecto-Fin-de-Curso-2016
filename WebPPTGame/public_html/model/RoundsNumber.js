/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
RoundsNumber=function(){
    var roundsNumber={
        UNA:1, TRES:2, CINCO:3, ANY:4, NONE:5,
        properties:{
            1:{name:"una",ordinal:1},
            2:{name:"tres",ordinal:2},
            3:{name:"cinco",ordinal:3},
            4:{name:"any",ordinal:4},
            5:{name:"none",ordinal:5}
        }
    };
    
    this.getRoundsNumber=function(){
        return roundsNumber;
    };
};


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
GameType=function(){
    var gameType={
        JUEGO3:1, JUEGO5:2, JUEGO9:3, ANY:4, NONE:5,
        properties:{
            1:{name:"juego3",ordinal:1},
            2:{name:"juego5",ordinal:2},
            3:{name:"juego9",ordinal:3},
            4:{name:"any",ordinal:4},
            5:{name:"none",ordinal:5}
        }
    };
    
    this.getGameType=function(){
        return gameType;
    };
};


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var datos, mapFichas, mapFichasMaquina, opc, modo, online, player;

$(document).ready(function () {
    datos = new DataContainer();
    datos.setRoundsCounter(0);
    datos.setVictoriesP1(0);
    datos.setVictoriesP2(0);
    mapFichas = datos.inicializaMapFichas();
    mapFichasMaquina = datos.inicializaMapFichasMaquina();
    localStorage.setItem("datos", datos);
});

function cambiaVista(divId) {
    if (divId == "playLocal") {
        online = false;
    }
    document.getElementById('initialButtons').style.display = 'none';
    document.getElementById('playLocal').style.display = 'none';
    document.getElementById('playOnline').style.display = 'none';
    document.getElementById('rules').style.display = 'none';
    document.getElementById('graphicRules').style.display = 'none';
    document.getElementById('infoDev').style.display = 'none';
    document.getElementById('localGameMenu').style.display = 'none';
    document.getElementById('onlineGameMenu').style.display = 'none';
    document.getElementById('customedOnline').style.display = 'none';
    document.getElementById('headerGame').style.display = 'none';
    document.getElementById('gameOf3red').style.display = 'none';
    document.getElementById('gameOf3blue').style.display = 'none';
    document.getElementById('gameOf5red').style.display = 'none';
    document.getElementById('gameOf5blue').style.display = 'none';
    document.getElementById('gameOf9red').style.display = 'none';
    document.getElementById('gameOf9blue').style.display = 'none';
    document.getElementById('vistaResult').style.display = 'none';
    document.getElementById(divId).style.display = 'block';

}

function visibleElement(element) {
    document.getElementById(element).style.display = 'inline';
}

function invisibleElement(element) {
    document.getElementById(element).style.display = 'none';
}

function cambiaVistaJuego() {
    datos.setNombreJ1($("#nameOfPlayer1").val());
    //localStorage.setItem("nombreJ1", datos.getNombreJ1());
    document.getElementById('title').style.display = 'none';
    cambiaVista('headerGame');
    if (document.getElementById('game3').checked == true) {
        document.getElementById('gameOf3red').style.display = 'block';
        datos.setFactorAlgoritmo(1);
        modo = 3;
    } else {
        if (document.getElementById('game5').checked == true) {
            document.getElementById('gameOf5red').style.display = 'block';
            datos.setFactorAlgoritmo(2);
            modo = 5;
        } else {
            document.getElementById('gameOf9red').style.display = 'block';
            datos.setFactorAlgoritmo(4);
            modo = 9;
        }
    }
    
    if (document.getElementById('onePlayer').checked) {
        datos.setModalidadJuego(new ModalidadJuego().getModalidad().UNO);
    } else {
        datos.setModalidadJuego(new ModalidadJuego().getModalidad().DOS);
    }
    setLimiteRondas();
    datos.setTurno(true);
    $("#p1").attr("src", "imagesPPTGame/helpsymbolrojo.png");
    $("#p2").attr("src", "imagesPPTGame/blank.png");
    showToastRed();
}

function setLimiteRondas() {
    if (document.getElementById('oneRound').checked) {
        datos.setRoundsLimit(1);
    } else {
        if (document.getElementById('threeRounds').checked) {
            datos.setRoundsLimit(3);
        } else {
            if (document.getElementById('fiveRounds').checked) {
                datos.setRoundsLimit(5);
            } else {
                datos.setRoundsLimit($("#customedRounds").val());
            }
        }
    }
}

function gestionaJuego(window, opClicked, imgId) {
    //alert(datos.getModalidadJuego().name);
    //alert(datos.getModalidadJuego().ordinal);
    var mmsg = null;
    var modalidad = new ModalidadJuego().getModalidad();
    if (document.getElementById(window).style.display == "block") {
        //alert("WINDOW VISIBLE");
        opc = mapFichas[opClicked];
        //alert(datos.isTurno()+" - - - "+opc);
        if (datos.isTurno() == true && opc != null) {
            //alert("IS TURNO"+datos.isTurno());
            datos.setEnumChosen1(opc);
            datos.setIdImgPulsada1(imgId);
            if (datos.getModalidadJuego().ordinal == modalidad.DOS.ordinal) {
                //DOS JUGADORES
                //alert("DOS JUGADORES");
                datos.setNombreJ2($("#nameOfPlayer2").val());
                turnoAzul();
                datos.setTurno(false);
                showToastBlue();
            } else {
                if (datos.getModalidadJuego().ordinal == modalidad.UNO.ordinal) {
                    //UN JUGADOR
                    //alert("UN JUGADOR");
                    datos.setEnumChosen2(getEnumFromOrdinal(Math.floor((Math.random() * ((datos.getFactorAlgoritmo() * 2) + 1)))));
                    //console.log(datos.getEnumChosen2());
                    datos.setNombreJ2("CPU");
                    datos.setIdImgPulsada2(gestionaPulsadoMaquina() + modo);
                    comunEvaluacionGanador(false);
                } else {
                    //ONLINE
                    //datos.setNombreJ1($("#nameOfPlayerOnline").val());
                    //alert("ONLINE");
                    mmsg = new MetaMessage();
                    mmsg.type = (new TypeMessage().getTypeMessage().PARTIDA.name);
                    var opcionJuego = new OpcionJuego();
                    opcionJuego.opcion = (datos.getEnumChosen1().ordinal);
                    //alert(datos.getEnumChosen2());
                    if (datos.getEnumChosen2() != null) {
                        //$("#imgResultP2").attr("src", document.getElementById(datos.getIdImgPulsada2()).src);
                        $("#imgResultP2").attr("src", $("#"+datos.getIdImgPulsada2()).attr("src"));
                        comunEvaluacionGanador(false);
                    }
                    mmsg.content = (opcionJuego);
                    var msgToSend = JSON.stringify(mmsg);
                    websocket.send(msgToSend);
                }
            }
        } else {
            if (datos.isTurno() == false && opc != null) {
                datos.setEnumChosen2(opc);
                datos.setIdImgPulsada2(imgId);
                cambiaVistaJuego();
                comunEvaluacionGanador(false);
                datos.setTurno(true);
            }
        }
    }
    return mmsg;
}

function comunEvaluacionGanador(recuperando) {
    //alert("EVALUACION GANADOR");
//    $("#imgResultP1").attr("src", document.getElementById(datos.getIdImgPulsada1()).src);
//    $("#imgResultP2").attr("src", document.getElementById(datos.getIdImgPulsada2()).src);
    alert("id 1: "+datos.getIdImgPulsada1()+" --- id 2: "+datos.getIdImgPulsada2());
    //alert("ruta 1: "+$("#"+datos.getIdImgPulsada1()).attr("src")+" --- ruta 2: "+$("#"+datos.getIdImgPulsada2()).attr("src"));
    $("#imgResultP1").attr("src", $("#"+datos.getIdImgPulsada1()).attr("src"));
    $("#imgResultP2").attr("src", $("#"+datos.getIdImgPulsada2()+modo).attr("src"));
    switch (logicaJuego()) {
        case 0:
            //empata
            $("#resultGame").text("DRAW!");
            break;
        case 1:
            //gana jugador 1
            $("#resultGame").text(datos.getNombreJ1() + " WINS!");
            if (!recuperando) {
                datos.sumaVictoriesP1();
            }
            break;
        case 2:
            //gana jugador 2
            $("#resultGame").text(datos.getNombreJ2() + " WINS!");
            if (!recuperando) {
                datos.sumaVictoriesP2();
            }
            break;
    }
    cambiarVistaAResult(datos);
}

function logicaJuego() {
    var resultado = 0;
    if (datos.getEnumChosen2().ordinal == (datos.getEnumChosen1().ordinal)) {
        resultado = 0;
    } else {
        var ganaChosen = false;
        datos.avanzaRonda();
        //alert(datos.getRoundsCounter());
        if (datos.rondasFinalizadas() == true) {
            datos.setRoundsCounter(0);
            $("#next").prop("disabled", true);
        }
        for (var j = ((datos.getEnumChosen2().ordinal + 1) % ((datos.getFactorAlgoritmo() * 2) + 1)), i = 0; i < (datos.getFactorAlgoritmo()) && !ganaChosen; i++, j = ((j + 1) % ((datos.getFactorAlgoritmo() * 2) + 1))) {
            if (datos.getEnumChosen1().ordinal == j) {
                ganaChosen = true;
                resultado = 2;
            }
        }
        if (!ganaChosen) {
            resultado = 1;
        }
    }
    return resultado;
}

function getEnumFromOrdinal(ordinal) {
    var res = null;
    var sal = false;
    var factor = datos.getFactorAlgoritmo();
    //var ordinal = Math.floor((Math.random() * ((factor * 2) + 1)));
    switch (factor) {
        case 1:
            for (var i = 0; i < 3 && !sal; i++) {
                if (i == ordinal) {
                    res = new EnumFichas3().getFichas3()[i];
                    sal = true;
                }
            }
            break;
        case 2:
            for (var i = 0; i < 5 && !sal; i++) {
                if (i == ordinal) {
                    res = new EnumFichas5().getFichas5()[i];
                    sal = true;
                }
            }
            break;
        case 4:
            for (var i = 0; i < 9 && !sal; i++) {
                if (i == ordinal) {
                    res = new EnumFichas9().getFichas9()[i];
                    sal = true;
                }
            }
            break;
    }
    return res;
}

function cambiarVistaAResult() {
    cambiaVista('vistaResult');
    $("#wonCountP1").html(datos.getNombreJ1() + " WON:<br> " + datos.getVictoriesP1());
    $("#wonCountP2").html(datos.getNombreJ2() + " WON:<br> " + datos.getVictoriesP2());
    datos.setEnumChosen1(null);
    datos.setEnumChosen2(null);
    datos.setJugando(false);
    datos.setVictoriesP1(0);
    datos.setVictoriesP2(0);
    //document.getElementById('back').onclick = function () {
    if (datos.getModalidadJuego().ordinal == new ModalidadJuego().getModalidad().ONLINE.ordinal && websocket != null) {
        websocket.close();
    }
    //};

}

function gestionaPulsadoMaquina() {
    return mapFichasMaquina[datos.getEnumChosen2().name];
}

function turnoAzul() {
    $("#p1").attr("src", "imagesPPTGame/blank.png");
    $("#p2").attr("src", "imagesPPTGame/helpsymbolazul.png");
    if (document.getElementById('game3').checked == true) {
        document.getElementById('gameOf3blue').style.display = 'block';
    } else {
        if (document.getElementById('game5').checked == true) {
            document.getElementById('gameOf5blue').style.display = 'block';
        } else {
            document.getElementById('gameOf9blue').style.display = 'block';
        }
    }
}

function opcionJuegoEscogida() {
    var opc;
    if (online) {
        if ($("[name='gameOnl']") != null) {
            opc = $("input[name='gameOnl']:checked").val();
        }
    } else {
        opc = $("input[name='game']:checked").val();
    }
    return opc;
}

function backFromPlayScreen() {
    //alert();
    $("#next").prop("disabled", false);

    if (online) {
        cambiaVista('playOnline');
    } else {
        cambiaVista('playLocal');
    }
    document.getElementById('title').style.display = 'block';
}

function showToastRed() {
    $('.toast').text(datos.getNombreJ1() + "'s turn").css("background-color", "red").fadeIn(500).delay(1200).fadeOut(550);
}

function showToastBlue() {
    $('.toast').text(datos.getNombreJ2() + "'s turn").css("background-color", "blue").fadeIn(400).delay(1200).fadeOut(400);
}

function cambiaVistaJuegoOnline() {
    datos.setTurno(true);
    online = true;
    localStorage.setItem("onlne", online);
    
    datos.setModalidadJuego(new ModalidadJuego().getModalidad().ONLINE);
    document.getElementById('title').style.display = 'none';
    cambiaVista('headerGame');
    if ($("nameOfPlayerOnline").val() == "") {
        alert("Rellena todos los campos!");
    } else {
        //if (id == "gameOnlineScreen") {
        datos.setNombreJ1($("#nameOfPlayerOnline").val());
        connect();
        var metamsg = new MetaMessage().getMetaMessage();
        metamsg.type = (new TypeMessage().getTypeMessage().CONEXION.name);
        player = new Player().getPlayer();
        player.namePlayer = (datos.getNombreJ1());
        player.playing = (false);
        //alert("PLAYER JSON "+playerJson);
        datos.setJugando(true);
        if (document.getElementById('game3Onl').checked == true) {
            document.getElementById('gameOf3red').style.display = 'block';
            datos.setFactorAlgoritmo(1);
            player.tipoJuego = (new GameType().getGameType().JUEGO3.name);
            modo = 3;
        } else {
            if (document.getElementById('game5Onl').checked == true) {
                document.getElementById('gameOf5red').style.display = 'block';
                datos.setFactorAlgoritmo(2);
                player.tipoJuego = (new GameType().getGameType().JUEGO5.name);
                modo = 5;
            } else {
                document.getElementById('gameOf9red').style.display = 'block';
                datos.setFactorAlgoritmo(4);
                player.tipoJuego = (new GameType().getGameType().JUEGO9.name);
                modo = 9;
            }
        }
        localStorage.setItem("modo",modo);
        setLimiteRondasOnline();
        metamsg.content = (player);
        console.log(metamsg);
        var msgToSend = JSON.stringify(metamsg);
        //alert(msgToSend);
        waitForSocketConnection(websocket, function () {
            websocket.send(msgToSend);
        });

    }


    //}
}

function setLimiteRondasOnline() {
    if (document.getElementById('oneRoundOnl').checked) {
        datos.setRoundsLimit(1);
        player.numberOfRounds = (new RoundsNumber().getRoundsNumber().UNA.name);
    } else {
        if (document.getElementById('threeRoundsOnl').checked) {
            datos.setRoundsLimit(3);
            player.numberOfRounds = (new RoundsNumber().getRoundsNumber().TRES.name);
        } else {
            datos.setRoundsLimit(5);
            player.numberOfRounds = (new RoundsNumber().getRoundsNumber().CINCO.name);
        }
    }
    //alert(player.numberOfRounds.name);
}

function randomGame() {
    var metamsg = new MetaMessage();
    var p = new Player();
    p.setPlaying(false);
    p.setRoundsNumber(new RoundsNumber().getRoundsNumber().ANY);
    p.setGameType(new GameType().getGameType().ANY);
    p.setNumPartidas(datos.getNombreJ1());
    metamsg.setContent(p);
    metamsg.setTypeMessage(new TypeMessage().getTypeMessage().CONEXION);
    websocket.send(metamsg);
}


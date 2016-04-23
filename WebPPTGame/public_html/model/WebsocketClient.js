
var websocket;
var datos = localStorage.getItem("datos");
function connect() {
    //var wsUri = "ws://192.168.1.104:8080/ServerPPTGame/ppt?user=" + datos.getNombreJ1();
    var wsUri = "ws://localhost:8080/ServerPPTGame/ppt?user=" + datos.getNombreJ1();
    console.log("Connecting to " + wsUri);
    websocket = new WebSocket(wsUri);
    websocket.onopen = function (evt) {
        onOpen(evt);
    };
    websocket.onmessage = function (evt) {
        onMessage(evt);
    };
    websocket.onerror = function (evt) {
        onError(evt);
    };
    websocket.onclose = function (evt) {
        onClose(evt);
    };
}

//if (localStorage.getItem("online") == true) {
//    console.log("online es " + localStorage.getItem("online"))
//    websocket.onmessage = function (evt) {
//        onMessage(evt);
//    };
//    websocket.onerror = function (evt) {
//        onError(evt);
//    };
//    websocket.onclose = function (evt) {
//        onClose(evt);
//    };
//}else{
//    console.log("online es " + localStorage.getItem("online"))
//}


//var output = document.getElementById("output");

function sayHello() {
    console.log("sayHello: " + $('nameOfPlayerOnline').val());
    //websocket.send(myField.value);
}
/*
 function echoBinary() {
 //                alert("Sending " + myField2.value.length + " bytes")
 var buffer = new ArrayBuffer(myField2.value.length);
 var bytes = new Uint8Array(buffer);
 for (var i = 0; i < bytes.length; i++) {
 bytes[i] = i;
 }
 //                alert(buffer);
 websocket.send(buffer);
 //writeToScreen("SENT (binary): " + buffer.byteLength + " bytes");
 }
 */
function onOpen() {
    console.log("onOpen");
    //writeToScreen("CONNECTED");
}
function onClose() {
    console.log("onClose");
    //writeToScreen("DISCONNECTED");
}

function onMessage(evt) {
    var metamsg = new MetaMessage().getMetaMessage();
    console.log("evt: "+evt.data);
//    if (typeof evt.data == "string") {
        metamsg = JSON.parse(evt.data);
        console.debug("metamsg",metamsg.type);
        ////alert("COMPROBACION SOSPECHOSA: "+(metamsg.type == new TypeMessage().getTypeMessage().RESPUESTA.name));
        if (metamsg != null && metamsg.type == new TypeMessage().getTypeMessage().RESPUESTA.name) {
            var opcJuego = new OpcionJuego().getOpcionJuego();
            opcJuego = JSON.parse(JSON.stringify(metamsg.content));
            console.debug("opc jueego: ",opcJuego);
            if (opcJuego != null) {
                datos.setEnumChosen2(getEnumFromOrdinal(opcJuego.opcion));
                datos.setIdImgPulsada2(gestionaPulsadoMaquina()+localStorage.getItem("modo"));
                console.log("chosen1; "+datos.getEnumChosen1());
                if (datos.getEnumChosen1() != null) {
                    $("#imgResultP2").attr("src", $("#"+datos.getIdImgPulsada2()).attr("src"));
                    comunEvaluacionGanador(false);
                }
                
            }
        } else {
            if (metamsg != null && metamsg.type == new TypeMessage().getTypeMessage().DESCONEXION.name) {
                alert("Ups! Something was wrong with connection!");
                //websocket.onclose(evt);
                websocket.close();
            } else {
                datos.setNombreJ2(JSON.parse(JSON.stringify(metamsg.content)));
            }

        }
//    }
}

function onError(evt) {
    console.log("ERROR");
    //writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

function waitForSocketConnection(socket, callback) {
    setTimeout(function () {
        if (socket.readyState === 1) {
            console.log("Connection is made");
            if (callback != null) {
                callback();
            }
            return;
        } else {
            console.log("wait for connection...");
            waitForSocketConnection(socket, callback);
        }
    }, 5); // wait 5 milisecond for the connection...
}
/*
 function writeToScreen(message) {
 var pre = document.createElement("p");
 pre.style.wordWrap = "break-word";
 pre.innerHTML = message;
 output.appendChild(pre);
 }
 */
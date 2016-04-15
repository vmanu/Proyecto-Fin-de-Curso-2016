/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */


var websocket;
var datos = localStorage.getItem("datos");
function connect() {
    var wsUri = "ws://192.168.1.104:8080/ServerPPTGame/ppt?user=" + datos.getNombreJ1();
    console.log("Connecting to " + wsUri);
    websocket = new WebSocket(wsUri);
    websocket.onopen = function (evt) {
        onOpen(evt);
    };
}

if (localStorage.getItem("online") == true) {
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
    if (typeof evt.data == "string") {
        metamsg = JSON.parse(evt.data);
        alert("DATA: "+evt.data);
        if (metamsg != null && metamsg.type == new TypeMessage().getTypeMessage().RESPUESTA) {
            var opcJuego = new OpcionJuego().getOpcionJuego();
            opcJuego = JSON.parse(JSON.stringify(metamsg.content));
            if (opcJuego != null) {
                datos.setEnumChosen2(getEnumFromOrdinal(opcJuego.getOpcion()));
                datos.setIdImgPulsada2(gestionaPulsadoMaquina());
                if (datos.getEnumChosen1() != null) {
                    $("#imgResultP2").attr("src", document.getElementById(datos.getIdImgPulsada2()).src);
                }
            }
        } else {
            if (metamsg != null && metamsg.type == new TypeMessage().getTypeMessage().DESCONEXION) {
                alert("Ups! Something was wrong with connection!");
                //websocket.onclose(evt);
                websocket.close();
            } else {
                datos.setNombreJ2(JSON.parse(JSON.stringify(metamsg.content)));
            }

        }
    }
}

function onError(evt) {
    console.log("ERROR");
    //writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}
/*
 function writeToScreen(message) {
 var pre = document.createElement("p");
 pre.style.wordWrap = "break-word";
 pre.innerHTML = message;
 output.appendChild(pre);
 }
 */
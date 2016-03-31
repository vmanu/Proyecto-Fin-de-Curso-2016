/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datapptgame;

/**
 *
 * @author ivanp
 */
public class Player {
    private String namePlayer;
    private GameType tipoJuego;
    private RoundsNumber numberOfRounds;
    private boolean playing;

    public Player() {
    }

    public Player(String namePlayer, GameType tipoJuego, RoundsNumber numberOfRounds, boolean playing) {
        this.namePlayer = namePlayer;
        this.tipoJuego = tipoJuego;
        this.numberOfRounds = numberOfRounds;
        this.playing = playing;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public GameType getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(GameType tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    public RoundsNumber getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(RoundsNumber numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    @Override
    public String toString() {
        return "Player{" + "namePlayer=" + namePlayer + ", tipoJuego=" + tipoJuego + ", numberOfRounds=" + numberOfRounds + ", playing=" + playing + '}';
    }
}

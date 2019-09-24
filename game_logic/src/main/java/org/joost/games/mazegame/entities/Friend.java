package org.joost.games.mazegame.entities;

public class Friend extends Npc {

    public static final String NAME = "v";

    public Friend() {
        this.health=20;
    }

    // het symbool voor een friend op de kaart
    @Override
    String getChar() {
        return NAME;
    }
}

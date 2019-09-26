package org.joost.games.mazegame.entities.participants;

public class Friend extends Npc {

    static final String NAME = "v";

    public Friend() {
        this.health = (int) (Math.random() * 25) + 1;
    }

    // het symbool voor een friend op de kaart
    @Override
    public String getChar() {

        if (alive) {return NAME;}
        else {
        return ".";}
    }
}

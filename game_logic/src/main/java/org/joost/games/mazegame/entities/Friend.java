package org.joost.games.mazegame.entities;

class Friend extends Npc {

    static final String NAME = "v";

    Friend() {
        this.health = (int) (Math.random() * 25) + 1;
    }

    // het symbool voor een friend op de kaart
    @Override
    String getChar() {

        if (alive) {return NAME;}
        else {
        return ".";}
    }
}

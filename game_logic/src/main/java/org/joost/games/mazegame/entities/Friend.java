package org.joost.games.mazegame.entities;

class Friend extends Npc {

    static final String NAME = "v";


    Friend() {
        this.health = 20;
        this.damage = 0;
    }

    // het symbool voor een friend op de kaart
    @Override
    String getChar() {

        if (alive) {return NAME;}
        else {//tile.removeNpc();

        return ".";}
    }
}

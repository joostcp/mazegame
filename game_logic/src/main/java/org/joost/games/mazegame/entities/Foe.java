package org.joost.games.mazegame.entities;

class Foe extends Npc {

    static final String NAME = "b";


    Foe() {
        this.health = 25;
        this.damage = 15;
    }

    // het symbool voor een foe op de kaart
    @Override
    String getChar() {
        return NAME;
    }
}

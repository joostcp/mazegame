package org.joost.games.mazegame.entities;

public class Foe extends Npc {

    public static final String NAME = "b";


    public Foe() {
        this.health = 25;
        this.damage = 15;
    }

    // het symbool voor een foe op de kaart
    @Override
    String getChar() {
        return NAME;
    }
}

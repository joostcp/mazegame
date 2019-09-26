package org.joost.games.mazegame.entities.participants;

public class Foe extends Npc {

    static final String NAME = "b";

        public Foe() {
        this.health = (int) (Math.random() * 30) + 1;
        this.damage = (int) (Math.random() * 20) + 1;;
        this.strength = (int) (Math.random() * 10) + 1;
    }

    // het symbool voor een foe op de kaart
    @Override
    public String getChar() {
        return NAME;
    }

}

package org.joost.games.mazegame.entities.objects;

public class PowerUp extends Stuff {

    static final String NAME = "+";

    public PowerUp() {
        this.strengthBonus=0;
        this.damageBonus=0;
        this.healthBonus=0;
    }

    @Override
    public String getChar() {
        return NAME;
    }

}

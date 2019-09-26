package org.joost.games.mazegame.entities.objects;

public abstract class Stuff {

    int healthBonus;
    int strengthBonus;
    int damageBonus;
    boolean eaten=false;

    public abstract String getChar();

    public void eaten() {
        this.eaten=true;
        // weghalen van field
    }

}

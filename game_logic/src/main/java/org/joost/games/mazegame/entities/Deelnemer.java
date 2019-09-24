package org.joost.games.mazegame.entities;

public abstract class Deelnemer implements Moveable {

    Tile tile;
    int damage;
    int health;

    abstract String getChar();

    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }

    @Override
    public boolean move( Direction direction ) {
        return false;
    }
}

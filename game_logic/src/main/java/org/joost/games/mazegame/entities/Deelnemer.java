package org.joost.games.mazegame.entities;

public abstract class Deelnemer implements Moveable {

    Tile tile;
    int damage;
    int health;
    int strength;
    boolean alive=true;

    void die() {
        this.alive = false;
        this.health = 0;
        this.damage = 0;
        this.strength=0;
    }

    abstract String getChar();

    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }
    public int getStrength() {return strength;}

    @Override
    public boolean move( Direction direction ) {
        return false;
    }
}

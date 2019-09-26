package org.joost.games.mazegame.entities.participants;

import org.joost.games.mazegame.entities.elements.Tile;

public abstract class Deelnemer implements Moveable {

    public Tile tile;
    int damage;
    int health;
    int strength;
    public boolean alive=true;

    void die() {
        this.alive = false;
        this.health = 0;
        this.damage = 0;
        this.strength=0;
    }

    public abstract String getChar();

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

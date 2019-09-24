package org.joost.games.mazegame.entities;

public class Player {

    Tile tile;
    private int health = 50;
    private int maxHealth = 100;

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    // elke case: test of het doelveld bestaat en niet blocking is
    // als dat zo is: leegmaken van het spelerattribuut van de huidige tile
    // het tile-attribuut van de speler vullen met de doeltile
    // het spelerattribuut van de doeltile vullen met de speler
    public boolean move( Direction direction ) {
        switch (direction) {
            case NORTH:
                if (tile.north != null && !tile.north.isBlocking()) {
                    this.tile.removePlayer();
                    this.tile = tile.north;
                    this.tile.putPlayer( this );
                    return true;
                }
                break;

            case EAST:
                if (tile.east != null && !tile.east.isBlocking()) {
                    this.tile.removePlayer();
                    this.tile = tile.east;
                    this.tile.putPlayer( this );
                    return true;
                }
                break;

            case SOUTH:
                if (tile.south != null && !tile.south.isBlocking()) {
                    this.tile.removePlayer();
                    this.tile = tile.south;
                    this.tile.putPlayer( this );
                    return true;
                }
                break;

            case WEST:
                if (tile.west != null && !tile.west.isBlocking()) {
                    this.tile.removePlayer();
                    this.tile = tile.west;
                    this.tile.putPlayer( this );
                    return true;
                }
                break;
        }
        return false;
    }

    // het spelersymbool in de maze
    String getChar() {
        return "p";
    }

    // als we een vriend ontmnoeten, gaat de energie omhoog, tot de maximale energie.
    // als we een vijand ontmoeten gaat er energie af, tot de dood erop volgt
    // geeft true terug als er, na aftrek van de damage van de meegegeven npc, nog health boven nul overblijft
    // geeft false terug als de health kleiner of gelijk is aan nul
    // todo als de health onder 0 komt krijgen we een nullpoiner-exception!

    public boolean meetSomeone( Npc npc ) {

        if (npc.getChar().equals( Friend.NAME )) {
            if (maxHealth-health<=npc.health) {
                this.health=maxHealth;
                System.out.println( "can't get any healthier..." );
            }
            else {this.health += npc.health;}
            this.tile.removeNpc();
        }
        if (npc.getChar().equals( Foe.NAME )) {
            this.health -= npc.damage;
            if (health < 0) {
                System.out.println( "im dying...." );
            }
        }
        return this.health > 0;
    }
}

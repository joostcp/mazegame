package org.joost.games.mazegame.entities.participants;

public class Player extends Deelnemer {

    private static final String NAME = "p";
    private int maxHealth;

    public Player() {
        this.health = 75;
        this.maxHealth = 100;
        this.damage = 10;
        this.strength=20;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    // elke case: test of het doelveld bestaat en niet blocking is
    // als dat zo is: leegmaken van het spelerattribuut van de huidige tile
    // het tile-attribuut van de speler vullen met de doeltile
    // het spelerattribuut van de doeltile vullen met de speler
    @Override
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
    @Override
    public String getChar() {
        return NAME;
    }


}

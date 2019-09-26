package org.joost.games.mazegame.entities.participants;

import static org.joost.games.mazegame.entities.participants.Direction.*;

public abstract class Npc extends Deelnemer {

    public int id;

    @Override
    public String toString() {
        return "{id=" + id +
                ", damage=" + damage +
                ", health=" + health +
                ", alive=" + alive +
                ", strength=" + strength +
                '}';
    }

    @Override
    public boolean move( Direction direction ) {
            switch (direction) {
                case NORTH:
                    if (tile.north != null && !tile.north.isBlocking()) {
                        this.tile.removeNpc();
                        this.tile = tile.north;
                        this.tile.putNpc( this );
                        return true;
                    }
                    break;

                case EAST:
                    if (tile.east != null && !tile.east.isBlocking()) {
                        this.tile.removeNpc();
                        this.tile = tile.east;
                        this.tile.putNpc( this );
                        return true;
                    }
                    break;

                case SOUTH:
                    if (tile.south != null && !tile.south.isBlocking()) {
                        this.tile.removeNpc();
                        this.tile = tile.south;
                        this.tile.putNpc( this );
                        return true;
                    }
                    break;

                case WEST:
                    if (tile.west != null && !tile.west.isBlocking()) {
                        this.tile.removeNpc();
                        this.tile = tile.west;
                        this.tile.putNpc( this );
                        return true;
                    }
                    break;
            }
        return false;
    }

    public boolean moveNPC(
    ) {
        int rand = (int) (Math.random() * 4) + 1;
        Direction dir = null;
        switch (rand) {
            case 1:
                dir = NORTH;
                break;
            case 2:
                dir = EAST;
                break;
            case 3:
                dir = SOUTH;
                break;
            case 4:
                dir = WEST;
                break;
        }
        try {
            if (move( dir )) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    // als we een vriend ontmoeten, gaat de energie omhoog, tot de maximale energie.
    // als we een vijand ontmoeten gaat er energie af, tot de dood erop volgt
    // geeft true terug als er, na aftrek van de damage van de meegegeven npc, nog health boven nul overblijft
    // geeft false terug als de health kleiner of gelijk is aan nul
    // todo als de health onder 0 komt krijgen we een nullpoiner-exception!
    // todo een overlopen vriend moet verdwijen (ook uit de array?)

    public boolean meetSomeone( Player player ) {

        if (getChar().equals( Friend.NAME )) {
            if (player.getMaxHealth()- player.health <= this.health) {
                player.health = player.getMaxHealth();
                System.out.println( "can't get any healthier..." );
            } else {
                player.health += this.health;
            }
            die();
        }

        if (getChar().equals( Foe.NAME )) {
            player.health -= this.damage;
            if (player.health <= 0) {
                System.out.println( "im dying...." );
                player.die();
            }
        }
        return player.health > 0;
    }
}

package org.joost.games.mazegame.entities;

import static org.joost.games.mazegame.entities.Direction.*;

public abstract class Npc extends Deelnemer {
    @Override
    public String toString() {
        return "{damage=" + damage +
                ", health=" + health +
                '}';
    }

    @Override
    public boolean move( Direction direction ) {
        switch (direction) {
            case NORTH:
                if (tile.north != null && !tile.north.isBlocking()) {
                    this.tile.removeNpc();
                    this.tile = tile.north;
                    this.tile.putNpc(  this );
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
}

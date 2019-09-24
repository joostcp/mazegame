package org.joost.games.mazegame.entities;

public abstract class Npc extends Deelnemer {


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
}

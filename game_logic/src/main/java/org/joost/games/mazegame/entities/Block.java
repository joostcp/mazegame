package org.joost.games.mazegame.entities;

public class Block extends Tile {

    // het symbool voor een blokkade op de map
    private static final String NAME = "#";

    // een block-tile is wel blocking
    @Override
    boolean isBlocking() {
        return true;
    }

    // op de blokkadetile geen npc toegestaan
    @Override
    boolean isNpcAllowed() {
        return false;
    }

    @Override
    String getChar() {
        return NAME;
    }
}

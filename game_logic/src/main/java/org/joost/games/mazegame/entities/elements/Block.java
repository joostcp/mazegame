package org.joost.games.mazegame.entities.elements;

public class Block extends Tile {

    // het symbool voor een blokkade op de map
    private static final String NAME = "#";

    // een block-tile is wel blocking
    @Override
    public boolean isBlocking() {
        return true;
    }

    // op de blokkadetile geen npc toegestaan
    @Override
    public boolean isNpcAllowed() {
        return false;
    }

    @Override
    public String getChar() {
        return NAME;
    }
}

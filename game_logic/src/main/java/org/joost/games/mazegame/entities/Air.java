package org.joost.games.mazegame.entities;

public class Air extends Tile {

    // een air-tile is niet blocking
    @Override
    boolean isBlocking() {
        return false;
    }

    // als er op een lucht-tile geen npc staat is een npc toegestaan (en geeft deze method dus true terug)
    @Override
    public boolean isNpcAllowed() {
        return npc==null;
    }

    @Override
    String getChar() {
        return " ";
    }
}

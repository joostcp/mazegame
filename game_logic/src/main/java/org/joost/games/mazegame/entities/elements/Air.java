package org.joost.games.mazegame.entities.elements;

public class Air extends Tile {

    // een air-tile is niet blocking
    @Override
    public boolean isBlocking() {
        return false;
    }

    // als er op een lucht-tile geen npc staat is een npc toegestaan (en geeft deze method dus true terug)
    @Override
    public boolean isNpcAllowed() {
        return npc==null;
    }

    @Override
    public String getChar() {
        return " ";
    }
}

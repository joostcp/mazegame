package org.joost.games.mazegame.entities.elements;

public class Finish extends Air {

    // het symbool voor de finish op de map
    static final String NAME = "F";

    @Override
    public String getChar() {
        return NAME;
    }

    // op de finishtile geen npc toegestaan
    @Override
    public boolean isNpcAllowed() {
        return false;
    }
}

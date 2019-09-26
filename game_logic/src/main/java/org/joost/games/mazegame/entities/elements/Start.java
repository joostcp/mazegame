package org.joost.games.mazegame.entities.elements;

public class Start extends Air {

    // het symbool voor de start op de kaart
    private static final String NAME = "S";

    @Override
    public String getChar() {
        return NAME;
    }

    // op de starttile geen npc toegestaan
    @Override
    public boolean isNpcAllowed() {
        return false;
    }
}

package org.joost.games.mazegame.entities;

public class Start extends Air {

    // het symbool voor de start op de kaart
    private static final String NAME = "S";

    @Override
    String getChar() {
        return NAME;
    }

    // op de starttile geen npc toegestaan
    @Override
    public boolean isNpcAllowed() {
        return false;
    }
}

package org.joost.games.mazegame.simple_gui;

import init.FieldReader;

public class Game {

    public Game() {
        new GameInput( new FieldReader().readFile( this.getClass().getResourceAsStream( "/game.txt" ) ) ).start();
        // gameinput krijgt een nieuw veld adhv game.txt mee
    }

    public static void main( String[] args ) {
        new Game();
    }
}

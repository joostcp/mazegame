package org.joost.games.mazegame.entities;

import static org.joost.games.mazegame.entities.participants.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

import org.joost.games.mazegame.entities.elements.Field;
import org.junit.jupiter.api.Test;

import init.FieldReader;

class FieldTest {

    @Test
    void doTest() {
        FieldReader reader = new FieldReader();
        Field field = reader.readFile( FieldReader.class.getResourceAsStream( "/game.txt" ) );
        System.out.println( field.toString() );
        System.out.println("f: " + field.finish + ", s: " + field.start );
        boolean moved = field.player.move( NORTH );
        assertFalse( moved );
        moved = field.player.move( SOUTH );
        assertTrue( moved );

        System.out.println( field.toString() );
    }
}
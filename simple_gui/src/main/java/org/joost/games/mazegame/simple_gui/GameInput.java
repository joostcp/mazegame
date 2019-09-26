package org.joost.games.mazegame.simple_gui;

import static org.joost.games.mazegame.entities.Direction.*;

import java.util.Scanner;

import org.joost.games.mazegame.entities.DeelnemerKilledListener;
import org.joost.games.mazegame.entities.Field;
import org.joost.games.mazegame.entities.FinishedListener;
import org.joost.games.mazegame.entities.Npc;

public class GameInput implements FinishedListener, DeelnemerKilledListener {

    private Field field;
    private Scanner scanner;
    private boolean finished;

    // de starter-method. maakt een field aan voor de meegekregen parameter
    // en een scanner om de input van de gebruiker te lezen
    public GameInput( Field field ) {
        this.field = field;
        this.scanner = new Scanner( System.in );
    }

    void start() {
        // hier wordt de finished listener van het Field geset om de luisteren naar de finish-staat van deze class.
        // zolang de staat is 'niet gefinished' (en dat kan op twee manieren: dood of victorie) wordt er gekeken naar input (in de while-loop)
        field.setDeelnemerKilledListener( this );
        field.setFinishedListener( this );
        while (!finished) {

            // dit rijtje printlines is het printen van het doolhof
            // de gegevens van de deelnemers
            // de gezondheidsgegevens van de speler en het verzoek te bewegen
            System.out.println( field.toString() );
            System.out.println( "---" );
            for (Npc npc : field.deelnemers) {
                System.out.println( (field.deelnemers.indexOf( npc ) + 1) + ": " + npc.toString() );
            }
            System.out.println( "---" );
            System.out.println( "health: " + field.player.getHealth() + "/" + field.player.getMaxHealth() );
            System.out.println( "strength: " + field.player.getStrength() );
            System.out.println( "damage: " + field.player.getDamage() );
            System.out.println( "geef uw input: " );

            // de scanner herkent vier karakters als input: WSAD voor noord/zuid/west/oost
            // bij een andere input, of als de gevraagde rchting niet kan (ivm block) wordt de speler daarop gewezen
            if (scanner.hasNext()) {
                boolean moved = false;
                switch (scanner.next()) {
                    case "w":
                        moved = field.player.move( NORTH );
                        break;
                    case "d":
                        moved = field.player.move( EAST );
                        break;
                    case "s":
                        moved = field.player.move( SOUTH );
                        break;
                    case "a":
                        moved = field.player.move( WEST );
                        break;
                }

                if (!moved) {
                    System.out.println( "dat gaat niet" );
                }
            }

            // als de speler succesvol bewogen heeft, moeten alle deelnemers een random beweging maken
            for (int i = 0; i < field.deelnemers.size(); i++) {
                while (!field.deelnemers.get( i ).moveNPC()) {
                }
            }
        }
        System.out.println( "FINISHED!" );
    }

    // todo nog beschrijven
    @Override
    public void finished( boolean hasWon ) {
        finished = hasWon;
    }

    // todo doet dit al iets?
    @Override
    public void deelnemerKilled( boolean hasDied ) {
        System.out.println( "someone died... :( " );
    }
}
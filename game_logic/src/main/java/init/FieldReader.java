package init;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.joost.games.mazegame.entities.elements.Air;
import org.joost.games.mazegame.entities.elements.Block;
import org.joost.games.mazegame.entities.elements.Field;
import org.joost.games.mazegame.entities.elements.Finish;
import org.joost.games.mazegame.entities.elements.Start;
import org.joost.games.mazegame.entities.elements.Tile;

public class FieldReader {

    // todo nog beschrijven
    public Field readFile( InputStream input ) {
        Field field = new Field();
        try (BufferedReader reader = new BufferedReader( new InputStreamReader( input ) )) {
            reader.lines().forEach( line -> enterLine( line, field ) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        field.initialize();
        return field;
    }

    // todo nog beschrijven
    private static void enterLine(
            String line,
            Field field ) {
        List<Tile> tiles = line.chars().mapToObj( FieldReader::createTile ).collect( Collectors.toList() );
        field.add( tiles );

    }

    // hier wordt op basis van de tekens in game.txt (in resources)
    // een vertaling gemaatk naar het type tile wat die tekens representeren
    // de mobiele elementen (player en npc's) komen later
    private static Tile createTile( int c ) {
        switch (c) {
            case '#':
                return new Block();
            case ' ':
                return new Air();
            case 'S':
                return new Start();
            case 'F':
                return new Finish();
        }
        return null;
    }
}
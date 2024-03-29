package org.joost.games.mazegame.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Field implements FinishedListener {

    private Tile[][] matrix;
    private final List<List<Tile>> tempTiles = new ArrayList<>();
    Tile start;
    Tile finish;
    public Player player = new Player();
    private int maxX;
    private int maxY;

    // todo nog beschrijven
    public void add( List<Tile> tiles ) {
        tempTiles.add( tiles );
    }

    // todo nog beschrijven
    public void initialize() {
        matrix = new Tile[tempTiles.size()][];
        List<Tile[]> lines = tempTiles.stream().map( Field::createArray ).collect( Collectors.toList() );
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = lines.get( i );
            findStartFinish( matrix[i] );
        }
        tempTiles.clear();
        connect();
        plotNpc( 3 ,2);
        start.putPlayer( player );
        player.tile = start;
    }

    // todo nog beschrijven
    private static Tile[] createArray( List<Tile> line ) {
        Tile[] array = new Tile[line.size()];
        return line.toArray( array );
    }

    // connect vult voor elke tile de vier attribuut-tiles north, south, east en west
    // eigenlijk: loopt door de map en doet bij elke tile een van de vier omliggende tile-attibutren vullen
    private void connect() {
        maxY = matrix.length;
        for (int y = 0; y < matrix.length; y++) {
            int length = matrix[y].length;
            if (length > maxX) {
                maxX = length;
            }
            for (int x = 0; x < length; x++) {
                connect( matrix[y][x], y - 1, x, Direction.NORTH );
                connect( matrix[y][x], y, x + 1, Direction.EAST );
                connect( matrix[y][x], y + 1, x, Direction.SOUTH );
                connect( matrix[y][x], y, x - 1, Direction.WEST );
            }
        }
    }

    private void connect(
            Tile tile,
            int y,
            int x,
            Direction direction ) {
        try {
            Tile connect = matrix[y][x];
            switch ((direction)) {
                case NORTH:
                    tile.north = connect;
                    break;
                case EAST:
                    tile.east = connect;
                    break;
                case SOUTH:
                    tile.south = connect;
                    break;
                case WEST:
                    tile.west = connect;
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    // mbv de select-method hieronder wordt de matrix doorlopen op zoek naar de tiles
    // waarbij de getChar-method 'S' of 'F' returnen. die tiles worden gebruikt
    // om de start- en finisch-attributen te vullen
    private void findStartFinish( Tile[] line ) {
        Arrays.stream( line ).forEach( this::select );
    }

    private void select( Tile t ) {
        switch (t.getChar()) {
            case "S":
                this.start = t;
                break;
            case "F":
                this.finish = t;
                t.listener = this;
        }
    }

    // todo nog beschrijven
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                sb.append( matrix[y][x] );

            }
            sb.append( '\n' );
        }
        return sb.toString();
    }

    // hier wordt een aantal (number) npc gemaakt en op de map geplaatst.
    // zolang dat niet gelukt is, blijft ie proberen
    private void plotNpc( int numberFoe, int numberFriend ) {
        Random rnd = new Random();
        for (int i = 0; i < numberFoe; i++) {
            Npc npc = new Foe();
            while (!putNpc( npc, rnd )) {
            }
        }
        for (int i = 0; i < numberFriend; i++) {
            Npc npc = new Friend();
            while (!putNpc( npc, rnd )) {
            }
        }
    }

    // hier wordt een als parameter meegegeven npc random op de map geplaatst
    // dat kan alleen als de methode isNpcAllowed een true teruggeeft voor de doel-tile
    private boolean putNpc(
            Npc npc,
            Random rnd ) {
        int y = rnd.nextInt( maxY );
        int x = rnd.nextInt( maxX );
        try {
            Tile tile = matrix[y][x];
            if (tile.isNpcAllowed()) {
                tile.putNpc( npc );
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;

    }








    // moet omdat de FinishedListener-interface geimplementeerd wordt
    // als de return-value true is staat de speler op de finish-tile en heeft hij dus gewonnen
    // als de value false is, is zijn health onder nul en is hij dood
    @Override
    public void finished( boolean hasWon ) {
        System.out.println( "FINISHED: " + (hasWon ? "You won" : "You lost") );
    }

    // todo nog beschrijven
    // hier wordt de listener van de finish-tile geset met een listener die meekomt als parameter
    public void setFinishedListener( FinishedListener listener ) {
        this.finish.listener = listener;
    }
}

package org.joost.games.mazegame.entities;

public abstract class Tile {
    private Player player;
    protected Npc npc;
    Tile north;
    Tile south;
    Tile east;
    Tile west;
    FinishedListener listener;

    // of er op de tile een blokkade aanwezig is
    abstract boolean isBlocking();

    // of er op de tile een npc toegestaan is
    abstract boolean isNpcAllowed();

    // het symbool van een tile op de map
    abstract String getChar();

    // de methode die voor elke tile bepaalt welk symbool op de map geprint moet worden
    public String toString() {

        if (player != null && npc != null) {
            if(!player.meetSomeone(npc)) {
                listener.finished(false);
            };
            return "B";
            // als de speler en een npc op hetzelfde veld staan en de health
            // van de speler niet lager dan 0 is, dan is het weer te geven symbool een 'B' (b+p)

        }
        if (player != null) {
            return player.getChar();
            // als alleen een speler
        }
        if (npc != null) {
            return npc.getChar();
            // als alleen een npc
        }

        return getChar();

    }

    // zet een speler op de tile door het attribuut te vullen
    // als de naam van de Finisch overeenkomt met de getChar van deze tile is de finish bereikt
    public void putPlayer( Player player ) {
        this.player = player;
        if (Finish.NAME.equals( getChar() )) {
            listener.finished( true );
        }
    }

    // zet een npc op de tile door het attribuut te vullen
    public void putNpc( Npc npc ) {
        this.npc=npc;

    }

    // haalt de speler van de tile af door het attribuut te legen
    public void removePlayer() {
        this.player = null;
    }

    // haalt de npc van de tile door het attribuut te legen
    // doet nog niks, omdat de npcs nog niet bewegen
    public void removeNpc() {
        this.npc = null;
    }
}

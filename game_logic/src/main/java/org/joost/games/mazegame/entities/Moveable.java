package org.joost.games.mazegame.entities;

public interface Moveable {
    // elke case: test of het doelveld bestaat en niet blocking is
    // als dat zo is: leegmaken van het spelerattribuut van de huidige tile
    // het tile-attribuut van de speler vullen met de doeltile
    // het spelerattribuut van de doeltile vullen met de speler
    boolean move( Direction direction );
}

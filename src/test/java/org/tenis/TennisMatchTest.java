package org.tenis;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisMatchTest {

    @Test
    void testPlayer1WinsAFullMatch() {
        TennisMatch match = new TennisMatch();

        match.playerOneScores();
        assertEquals("Sets: 0-0 | Games: 0-0 | Points: 1-0", match.getScore());

        // Jugador 2 gana un juego
        for (int i = 0; i < 4; i++) match.playerTwoScores();
        assertEquals("Sets: 0-0 | Games: 0-1 | Points: 0-0", match.getScore());

        // Jugador 2 gana un set, ya tiene un juego, necesita 3 más para un set de 4
        for (int i = 0; i < 12; i++) match.playerTwoScores();
        assertEquals("Sets: 0-1 | Games: 0-0 | Points: 0-0", match.getScore());

        // Jugador 1 gana un set
        for (int i = 0; i < 16; i++) match.playerOneScores();
        assertEquals("Sets: 1-1 | Games: 0-0 | Points: 0-0", match.getScore());

        // Jugador 1 gana el match
        for (int i = 0; i < 16; i++) match.playerOneScores();
        assertEquals("FINISHED!! Player 1 wins match", match.getScore());

        match.playerOneScores();
        match.playerTwoScores();
        assertEquals("FINISHED!! Player 1 wins match", match.getScore());
    }

    @Test
    void testPlayer2WinsMatch() {
        TennisMatch match = new TennisMatch();
        for (int i = 0; i < 32; i++) match.playerTwoScores();
        assertEquals("FINISHED!! Player 2 wins match", match.getScore());
    }

}
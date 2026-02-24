package org.tenis;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisMatchTest {

    @Test
    void testFullMatch_Player1Wins() {
        TennisMatch match = new TennisMatch();

        // el jugador 1 anota 31 puntos seguidos
        for (int i = 0; i < 31; i++) {
            match.playerOneScores();
        }

        // Debería tener 1 Set, 3 Juegos, y 3 Puntos
        assertEquals("Sets: 1-0 | Games: 3-0 | Points: 3-0", match.getScore());

        // Anota el punto decisivo (el punto número 32)
        match.playerOneScores();

        // Este último punto gana el juego, que gana el set, que gana el partido
        assertEquals("FINISHED!! Player 1 wins match", match.getScore());
    }

    @Test
    void testFullMatch_Player2Wins() {
        TennisMatch match = new TennisMatch();

        // el jugador 2 anota 31 puntos seguidos
        for (int i = 0; i < 31; i++) {
            match.playerTwoScores();
        }

        // Debería tener 1 Set, 3 Juegos, y 3 Puntos
        assertEquals("Sets: 0-1 | Games: 0-3 | Points: 0-3", match.getScore());

        // Anota el punto decisivo (el punto número 32)
        match.playerTwoScores();

        // Este último punto gana el juego, que gana el set, que gana el partido
        assertEquals("FINISHED!! Player 2 wins match", match.getScore());
    }
}
package org.tenis.basicCases;

import org.tenis.IScoreTranslator;

public class ThirtyLoveTranslator implements IScoreTranslator {

    @Override
    public boolean applies(int player1Score, int player2Score) {
        return (player1Score == 2 && player2Score == 0) || (player1Score == 0 && player2Score == 2);
    }

    @Override
    public String translate(int player1Score, int player2Score) {
        if (!applies(player1Score, player2Score)) {
            throw new IllegalArgumentException("ScoreBoard must be 2-0 o 0-2");
        }

        if (player1Score == 2) {
            return "Thirty-Love";
        } else {
            return "Love-Thirty";
        }
    }
}

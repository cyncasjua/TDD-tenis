package org.tenis.basicCases;

import org.tenis.IScoreTranslator;

public class FifteenThirtyTranslator implements IScoreTranslator {

    @Override
    public boolean applies(int player1Score, int player2Score) {
        return (player1Score == 1 && player2Score == 2) || (player1Score == 2 && player2Score == 1);
    }

    @Override
    public String translate(int player1Score, int player2Score) {
        if (!applies(player1Score, player2Score)) {
            throw new IllegalArgumentException("Scoreboard must be 1-2 o 2-1");
        }

        if (player1Score == 1) {
            return "Fifteen-Thirty";
        } else {
            return "Thirty-Fifteen";
        }
    }
}

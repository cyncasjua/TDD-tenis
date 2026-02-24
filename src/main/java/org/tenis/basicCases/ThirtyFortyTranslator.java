package org.tenis.basicCases;

import org.tenis.IScoreTranslator;

public class ThirtyFortyTranslator implements IScoreTranslator {

    @Override
    public boolean applies(int player1Score, int player2Score) {
        return (player1Score == 2 && player2Score == 3) || (player1Score == 3 && player2Score == 2);
    }

    @Override
    public String translate(int player1Score, int player2Score) {
        if (!applies(player1Score, player2Score)) {
            throw new IllegalArgumentException("Scoreboard must be 2-3 o 3-2");
        }

        if (player1Score == 2) {
            return "Thirty-Forty";
        } else {
            return "Forty-Thirty";
        }
    }
}

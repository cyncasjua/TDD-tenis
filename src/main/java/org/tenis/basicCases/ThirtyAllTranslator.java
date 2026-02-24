package org.tenis.basicCases;

import org.tenis.IScoreTranslator;

public class ThirtyAllTranslator implements IScoreTranslator {

    @Override
    public boolean applies(int player1Score, int player2Score) {
        return player1Score == 2 && player2Score == 2;
    }

    @Override
    public String translate(int player1Score, int player2Score) {
        if (!applies(player1Score, player2Score)) {
            throw new IllegalArgumentException("Both players must have a score of 2");
        }

        return "Thirty-Thirty";
    }
}

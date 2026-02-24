package org.tenis.basicCases;

import org.tenis.IScoreTranslator;

public class LoveLoveTranslator implements IScoreTranslator {

    @Override
    public boolean applies(int player1Score, int player2Score) {
        return player1Score == 0 && player2Score == 0;
    }

    @Override
    public String translate(int player1Score, int player2Score) {
        if (!applies(player1Score, player2Score)) {
            throw new IllegalArgumentException("Both players must have a score of 0");
        }

        return "Love-Love";
    }
}
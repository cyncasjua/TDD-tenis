package org.tenis;

public class FifteenAllTranslator implements IScoreTranslator {

    @Override
    public boolean applies(int player1Score, int player2Score) {
        return player1Score == 1 && player2Score == 1;
    }

    @Override
    public String translate(int player1Score, int player2Score) {
        if (!applies(player1Score, player2Score)) {
            throw new IllegalArgumentException("Both players must have a score of 1");
        }

        return "Fifteen-Fifteen";
    }
}

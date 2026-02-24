package org.tenis;

public class FifteenLoveTranslator implements IScoreTranslator {

    @Override
    public boolean applies(int player1Score, int player2Score) {
        return (player1Score == 1 && player2Score == 0) || (player1Score == 0 && player2Score == 1);
    }

    @Override
    public String translate(int player1Score, int player2Score) {
        if (!applies(player1Score, player2Score)) {
            throw new IllegalArgumentException("Scoreboard must be 1-0 o 0-1");
        }

        if (player1Score == 1) {
            return "Fifteen-Love";
        } else {
            return "Love-Fifteen";
        }
    }
}
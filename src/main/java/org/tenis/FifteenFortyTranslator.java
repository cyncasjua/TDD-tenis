package org.tenis;

public class FifteenFortyTranslator implements IScoreTranslator{

    @Override
    public boolean applies(int player1Score, int player2Score) {
        return (player1Score == 1 && player2Score == 3) || (player1Score == 3 && player2Score == 1);
    }

    @Override
    public String translate(int player1Score, int player2Score) {
        if (!applies(player1Score, player2Score)) {
            throw new IllegalArgumentException("Scoreboard must be 1-3 o 3-1");
        }

        if (player1Score == 1) {
            return "Fifteen-Forty";
        } else {
            return "Forty-Fifteen";
        }
    }
}

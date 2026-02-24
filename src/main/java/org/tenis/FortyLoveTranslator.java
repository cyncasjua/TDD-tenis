package org.tenis;

public class FortyLoveTranslator implements IScoreTranslator {

    @Override
    public boolean applies(int player1Score, int player2Score) {
        return (player1Score == 3 && player2Score == 0) || (player1Score == 0 && player2Score == 3);
    }

    @Override
    public String translate(int player1Score, int player2Score) {
        if (!applies(player1Score, player2Score)) {
            throw new IllegalArgumentException("Scoreboard 3-0 o 0-3");
        }

        if (player1Score == 3) {
            return "Forty-Love";
        } else {
            return "Love-Forty";
        }
    }
}

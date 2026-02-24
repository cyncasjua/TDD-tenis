package org.tenis;

public class AdvantageTranslator implements IScoreTranslator {

    @Override
    public boolean applies(int player1Score, int player2Score) {
        boolean bothReachedForty = player1Score >= 3 && player2Score >= 3;

        boolean isOnePointDifference = Math.abs(player1Score - player2Score) == 1;

        return bothReachedForty && isOnePointDifference;
    }

    @Override
    public String translate(int player1Score, int player2Score) {
        if (!applies(player1Score, player2Score)) {
            throw new IllegalArgumentException("Advantage is only applicable when both players have at least 3 points and there is a one point difference.");
        }

        if (player1Score > player2Score) {
            return "Advantage Player 1";
        } else {
            return "Advantage Player 2";
        }
    }
}
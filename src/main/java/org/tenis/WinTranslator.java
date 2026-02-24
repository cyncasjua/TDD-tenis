package org.tenis;

public class WinTranslator implements IScoreTranslator {

    @Override
    public boolean applies(int player1Score, int player2Score) {
        boolean someoneReachedFour = player1Score >= 4 || player2Score >= 4;

        boolean isTwoPointDifference = Math.abs(player1Score - player2Score) >= 2;

        return someoneReachedFour && isTwoPointDifference;
    }

    @Override
    public String translate(int player1Score, int player2Score) {
        if (!applies(player1Score, player2Score)) {
            throw new IllegalArgumentException("Any player has not reached 4 points with the difference of 2 points or more");
        }

        if (player1Score > player2Score) {
            return "Player 1 wins";
        } else {
            return "Player 2 wins";
        }
    }
}
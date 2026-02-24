package org.tenis;

public class SetTranslator implements IScoreTranslator{

    @Override
    public boolean applies(int player1Games, int player2Games) {
        return player1Games >= 4 || player2Games >= 4;
    }

    @Override
    public String translate(int player1Games, int player2Games) {
        if (!applies(player1Games, player2Games)) {
            return "Set in progress";
        }

        int difference = player1Games - player2Games;

        if (difference >= 2) return "Player 1 wins set";
        if (difference <= -2) return "Player 2 wins set";

        if (difference == 1) return "Advantage Player 1 set";
        if (difference == -1) return "Advantage Player 2 set";

        return "Deuce set";
    }
}
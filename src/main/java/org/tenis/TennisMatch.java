package org.tenis;

public class TennisMatch {

    private int p1Points = 0, p2Points = 0;
    private int p1Games = 0, p2Games = 0;
    private int p1Sets = 0, p2Sets = 0;

    private WinTranslator winTranslator = new WinTranslator();
    private SetTranslator setTranslator = new SetTranslator();
    private MatchTranslator matchTranslator = new MatchTranslator();

    public void playerOneScores() {
        p1Points++;
        checkScore();
    }

    public void playerTwoScores() {
        p2Points++;
        checkScore();
    }

    private void checkScore() {
        String gameResult = winTranslator.translate(p1Points, p2Points);

        if (gameResult.equals("Player 1 wins")) {
            p1Games++;
            resetPoints();
        } else if (gameResult.equals("Player 2 wins")) {
            p2Games++;
            resetPoints();
        }

        String setResult = setTranslator.translate(p1Games, p2Games);

        if (setResult.equals("Player 1 wins set")) {
            p1Sets++;
            resetGames();
        } else if (setResult.equals("Player 2 wins set")) {
            p2Sets++;
            resetGames();
        }

        String matchResult = matchTranslator.translate(p1Sets, p2Sets);
        if (!matchResult.isEmpty()) {
            System.out.println("¡PARTIDO TERMINADO! " + matchResult);
        }
    }

    private void resetPoints() {
        p1Points = 0;
        p2Points = 0;
    }

    private void resetGames() {
        p1Games = 0;
        p2Games = 0;
    }
}
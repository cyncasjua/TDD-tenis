package org.tenis;

public class TennisMatch {

    private int p1Points = 0, p2Points = 0;
    private int p1Games = 0, p2Games = 0;
    private int p1Sets = 0, p2Sets = 0;
    private boolean matchFinished = false;
    private String matchWinner = "";

    private final WinTranslator winTranslator = new WinTranslator();
    private final SetTranslator setTranslator = new SetTranslator();
    private final MatchTranslator matchTranslator = new MatchTranslator();

    public void playerOneScores() {
        if (matchFinished) return;
        p1Points++;
        checkScore();
    }

    public void playerTwoScores() {
        if (matchFinished) return;
        p2Points++;
        checkScore();
    }

    private void checkScore() {

        if (winTranslator.applies(p1Points, p2Points)) {
            String gameResult = winTranslator.translate(p1Points, p2Points);

            if (gameResult.equals("Player 1 wins")) p1Games++;
            else if (gameResult.equals("Player 2 wins")) p2Games++;

            resetPoints();

            if (setTranslator.applies(p1Games, p2Games)) {
                String setResult = setTranslator.translate(p1Games, p2Games);

                if (setResult.equals("Player 1 wins set")) { p1Sets++; resetGames(); }
                else if (setResult.equals("Player 2 wins set")) { p2Sets++; resetGames(); }

                if (matchTranslator.applies(p1Sets, p2Sets)) {
                    matchWinner = matchTranslator.translate(p1Sets, p2Sets);
                    matchFinished = true;
                }
            }
        }
    }

    public String getScore() {
        if (matchFinished) {
            return "FINISHED!! " + matchWinner;
        }
        return "Sets: " + p1Sets + "-" + p2Sets +
                " | Games: " + p1Games + "-" + p2Games +
                " | Points: " + p1Points + "-" + p2Points;
    }

    private void resetPoints() { p1Points = 0; p2Points = 0; }
    private void resetGames() { p1Games = 0; p2Games = 0; }
}
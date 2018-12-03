package com.MartaPrzybyl;

public class TennisPointCounter {
    boolean error = false;
    int player1Points;
    int player2Points;
    int ad = 0;
    int ad2 = 0;


    public TennisPointCounter() {
    }

    private void scenario(int player) {
        int chosenPlayer = 0, secondPlayer = 0;
        int adChosen = 0, adSecond = 0;
        if (player == 1) {
            chosenPlayer = player1Points;
            secondPlayer = player2Points;
            adChosen = ad;
            adSecond = ad2;
        } else if (player == 2) {
            chosenPlayer = player2Points;
            secondPlayer = player1Points;
            adChosen = ad2;
            adSecond = ad;
        }
        if (chosenPlayer < 30) {
            chosenPlayer += 15;
        } else if (chosenPlayer == 30) {
            chosenPlayer += 10;
            if (secondPlayer == 15) {
                adChosen = 2;
            }
        } else if (chosenPlayer >= 40) {
            chosenPlayer++;
            if (chosenPlayer > secondPlayer) {
                adChosen++;
                if (adSecond > 0) adSecond--;
                if (chosenPlayer - secondPlayer >= 2) {
                    adChosen = 2;
                }
            } else if (chosenPlayer == secondPlayer) {
                adChosen = 0;
                adSecond = 0;
            } else {
                if (adChosen > 0) adChosen--;
            }
        }
        if (player == 1) {
            player1Points = chosenPlayer;
            player2Points = secondPlayer;
            ad = adChosen;
            ad2 = adSecond;
        } else if (player == 2) {
            player1Points = secondPlayer;
            player2Points = chosenPlayer;
            ad2 = adChosen;
            ad = adSecond;
        }
    }

    public void addPointsToPlayer(int playerNumber) {
        if (playerNumber == 1) {
            scenario(1);
        } else if (playerNumber == 2) {
            scenario(2);
        } else {
            error = true;
        }
    }

    public String getPoints() {
        if (error) {
            return "Error!";
        } else {
            return printPoints(player1Points, player2Points);
        }
    }

    private String printPoints(int player1Points, int player2Points) {
        String p1Score, p2Score;
        if (ad == 1) {
            p1Score = "ad";
            p2Score = String.valueOf(player2Points);
        } else if (ad2 == 1) {
            p1Score = String.valueOf(player1Points);
            p2Score = "ad";
        } else if (ad == 2) {
            p1Score = "winner";
            p2Score = String.valueOf(player2Points);
        } else if (ad2 == 2) {
            p1Score = String.valueOf(player1Points);
            p2Score = "winner";
        } else {
            p1Score = String.valueOf(player1Points);
            p2Score = String.valueOf(player2Points);
        }
        return p1Score + ":" + p2Score;
    }
}
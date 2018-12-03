package com.MartaPrzybyl;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        TennisPointCounter game1 = new TennisPointCounter();
        game1.addPointsToPlayer(1);
        game1.addPointsToPlayer(2);
        game1.addPointsToPlayer(2);
        game1.addPointsToPlayer(2);
        System.out.println(game1.getPoints());
    }
}


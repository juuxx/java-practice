package javaBaseballGame;

import javaBaseballGame.util.BaseballUtil;

import java.util.Scanner;

public class GameController {

    private static final int RESTART_CODE = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int playingStatus;
        int[] computerNumbers = BaseballUtil.generateThreeDigitNumbers();
        do {
            GameHelper.play(sc, computerNumbers);
            playingStatus = GameHelper.isContinue(sc);
        }while (playingStatus == RESTART_CODE);

        sc.close();

    }
}

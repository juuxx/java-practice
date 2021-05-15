package javaBaseballGame;

import javaBaseballGame.domian.BaseballStatus;
import javaBaseballGame.util.BaseballUtil;

import java.util.Scanner;

public class GameHelper {
    private static final int TRIAL_NUMBER = 3;
    private static final int RESTART_CODE = 1;
    private static final int EXIT_CODE = 2;

    public static void play(Scanner sc, int[] computerNumbers){

        int count = 1;
        boolean isFinished = false;
        while (!isFinished){
            int[] userNumbers = getUserInputThreeNumber(sc);
            if(userNumbers[0] == -1){
                continue;
            }

            BaseballStatus baseballStatus = tryGuess(computerNumbers, userNumbers);
            System.out.println(baseballStatus.toString());
            if(endCondition(baseballStatus)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임 종료 ! ");
                break;
            }

            isFinished = stateChallenge(count++);
        }
    }

    private static boolean stateChallenge(int count){

        if(count == TRIAL_NUMBER){
            System.out.println("실패! 도전 횟수를 모두 소진하였습니다.");
            return true;
        }

        if(count < TRIAL_NUMBER){
            System.out.printf("남은 도전횟수 : %d회 ", (TRIAL_NUMBER) - count);
            System.out.println();
            return false;
        }

        return false;
    }

    public static int isContinue(Scanner sc){
        while (true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String input = sc.nextLine();

            if(!BaseballUtil.isStringNumberFormat(input)){
                continue;
            }

            int exitCode = Integer.parseInt(input);
            switch (exitCode){
                case 1:
                    return RESTART_CODE;
                case 2:
                    return EXIT_CODE;
                default:
                    System.out.println("1 또는 2를 입력하세요. ");
            }
        }
    }

    private static boolean endCondition(BaseballStatus baseballStatus){
        return 3 == baseballStatus.getStrike();
    }

    private static String userInput(Scanner sc){
        System.out.println("1 ~ 9 까지 숫자 중 세 개의 숫자를 ',(콤마)' 를 사용하여 입력하십시오.");
        System.out.println("(예) 1, 2, 3");

        return sc.nextLine();
    }

    private static int[] convertUserInput(String userInput){
        return BaseballUtil.guessThreeNumber(userInput);
    }

    private static int[] getUserInputThreeNumber(Scanner sc){
        String userInput = userInput(sc);
        return convertUserInput(userInput);
    }

    private static BaseballStatus tryGuess(int[] computerNumbers, int[] guessNumbers){
        return BaseballUtil.compareThreeNumber(computerNumbers, guessNumbers);
    }
}

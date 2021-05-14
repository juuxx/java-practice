import domian.Baseball;
import util.BaseballUtil;

import java.util.Scanner;

public class GameHelper {
    private static final int TRIAL_NUMBER = 10;

    public static void play(){
        Scanner sc = new Scanner(System.in);

        boolean[] trial = new boolean[TRIAL_NUMBER];
        int[] computerNums = BaseballUtil.generateThreeDigitNumbers();

        //비교 / 비교하고 결과값  반환 실패시 횟수 차감 및 다시 유저 넘버 뽑기
        int count = 0;
        while (true){
            int[] playerNums = getUserInputThreeNumber(sc);
            Baseball baseball = BaseballUtil.compareThreeNumber(computerNums, playerNums);
            int strike = baseball.getStrike();
            System.out.println(baseball.toString());
            if(strike == 3){
                System.out.println("성공! ");
                break;
            }
            if(strike != 3){
                System.out.println("실패! 다시 입력하세요");
                count++;
            }
            trial[count] = true;
            if(trial[TRIAL_NUMBER-1]){
                System.out.println("모든 기회를 다 썼습니다. 실패! ");
                 break;
            }
        }
        sc.close();


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
}

import domian.Baseball;
import util.BaseballUtil;

import java.util.Scanner;

public class GameHelper {

    public static void play(){
        Scanner sc = new Scanner(System.in);
        int[] computerNums = BaseballUtil.generateThreeDigitNumbers();

        int[] playerNums = getUserInputThreeNumber(sc);
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

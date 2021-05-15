package javaBaseballGame.util;

import javaBaseballGame.domian.Baseball;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BaseballUtil {

    private static final int BASEBALL_NUM = 3;      // 야구 게임 3자리 수 기준
    private static final int NUMBER_RANGE = 10;     // 야구 게임 숫자 범위

    //컴퓨터가 만든 3가지 숫자
    public static int[] generateThreeDigitNumbers(){
        boolean[] numberCheck = new boolean[NUMBER_RANGE];
        int[] numbers = new int[BASEBALL_NUM];
        int count = 0;
        while (count < BASEBALL_NUM){
            int ranNumber = ThreadLocalRandom.current().nextInt(NUMBER_RANGE -1) + 1;
            if(!numberCheck[ranNumber]){
                numbers[count] = ranNumber;
                numberCheck[ranNumber] = true;
                count++;
            }
        }

        for (int number : numbers) {
            System.out.print(number + ", ");
        }

        return numbers;
    }

    //유저가 입력한 숫자
    public static int[] guessThreeNumber(String userInput){
        int[] userInputIntegerSplit = initUserInput();
        String[] userInputStringSplit = userInput.split(",");

        if(userInputStringSplit.length != BASEBALL_NUM){
            System.out.println("[!] 형식에 맞게 입력해주세요.");
            return userInputIntegerSplit;
        }
        for (int i =0; i < userInputIntegerSplit.length; i++){
            String input = userInputStringSplit[i].trim();
            if(!isStringNumberFormat(input)){
                System.out.println("[!] 숫자만 입력해주세요.");
                break;
            }
            userInputIntegerSplit[i] = Integer.parseInt(input);
        }

        return userInputIntegerSplit;
    }

    private static int[] initUserInput(){
        int[] userInputIntegerSplit = new int[BASEBALL_NUM];
        Arrays.fill(userInputIntegerSplit, -1);
        return userInputIntegerSplit;
    }


    //컴퓨터와 유저 입력 숫자 비교
    public static Baseball compareThreeNumber(int[] computer, int[] user){
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computer.length; i ++){
            for(int j = 0; j < user.length; j++){
                if(computer[i] == user[j]){
                    if(i == j){
                        strike++;
                    }
                    if(i != j){
                        ball++;
                    }
                }
            }
        }

        return new Baseball(strike, ball);
    }

    public static boolean isStringNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}

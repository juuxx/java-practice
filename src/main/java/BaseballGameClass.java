import java.util.Random;
import java.util.Scanner;

public class BaseballGameClass {
    public static void dd() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] n = new int[3];
        int[] guess = new int[3];
        boolean[] tried = new boolean[10]; //10번 시도할 수 있음

        for(int i = 0; i < 10; i++){
            tried[i] = false;
        }
        int count = 0;
        while (count < 3){
            int trial = rand.nextInt(10);
            if(!tried[trial]){
                n[count] = trial;
                tried[trial] = true;
                count++;
            }
        }

        int strike;
        int ball;
        boolean isFinish = false;
        while (!isFinish){
            strike = 0;
            ball = 0;

            for (int i =0; i < 3; i++){
                System.out.println("0~9사이의 세 정수를 입력하세요>>");
                guess[i] = sc.nextInt();
                for (int j=0; j<3; j++){
                    if(guess[i] == n[j] ){
                        if(i == j) strike++;
                        else ball++;
                    }
                }
            }

            System.out.println(strike + " strike, " + ball + " ball");
            if(strike == 3){
                isFinish = true;
            }
        }
        sc.close();
        for (int i =0; i < 3; i++){
            System.out.print(n[i] + " ");
        }
        System.out.println(" : 축하합니다! ");
    }
}

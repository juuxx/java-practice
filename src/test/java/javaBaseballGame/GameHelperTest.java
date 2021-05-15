package javaBaseballGame;

import javaBaseballGame.util.BaseballUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameHelperTest {
    @Test
    public void boolean배열의_초기값_확인(){
        boolean[] testArray = new boolean[10];
       // assertJ
        assertThat(testArray[0]).isEqualTo(false);
        //boolean 배열의 초기값 -> false
    }

    @Test
    public void playTest(){
        String input = "가, 나, 다";
        int[] test = BaseballUtil.guessThreeNumber(input);
        assertThat(test).contains(-1);
    }

}
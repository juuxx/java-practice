package javaBaseballGame.domian;


public class BaseballStatus {
    private int strike;
    private int ball;

    public BaseballStatus(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return "nothing";
        }

        if (strike == 0) {
            return ball + " ball";
        }

        if (ball == 0) {
            return strike + " strike";
        }

        if (ball != 0 && strike != 0) {
            return strike + " strike " + ball + " ball";
        }

        return null;
    }

}

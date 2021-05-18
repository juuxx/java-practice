package javaCarRacingGame.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        String dash = "-";
        String result = "";
        for (int i = 0; i < position; i++){
            result += dash;
        }
        String print = name + " : " + result;
        return print;
    }
}

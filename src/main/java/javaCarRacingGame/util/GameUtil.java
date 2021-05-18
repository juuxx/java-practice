package javaCarRacingGame.util;

import javaCarRacingGame.domain.Car;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class GameUtil {

    private static final int NUMBER_RANGE = 10;

    public static List<Car> userInput(String userInput){
        String[] userInputs = userInput.split(",");
        //validate check 필요
        return initCars(userInputs);
    }

    public static int userInputNumber(String userInput){
        //validate check
        return Integer.parseInt(userInput);
    }

    private static List<Car> initCars(String[] userInputs){
        return Arrays.stream(userInputs)
                     .map(s -> new Car(s.trim(), 0))
                     .collect(Collectors.toList());
    }




    public static void playGames(int playTimes, List<Car> cars){
        int count = 0;
        while( count < playTimes){
            setGoPosition(cars);
            print(cars, count);
            count++;
        }
    }

    private static void setGoPosition(List<Car> cars) {
        cars.forEach(car->{
            int go = 0;
            int pseresntPosition = car.getPosition();
            int ranNumber = ThreadLocalRandom.current().nextInt(9);
            if(ranNumber > 4){
                go++;
            }
            car.setPosition(pseresntPosition + go);

            //print(car);
        });
    }

    private static void print(List<Car> cars, int count){
        System.out.println("");
        System.out.printf("%d회 경주 결과\n", count+1);
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println("");
    }

    public static void whoIsWinner(List<Car> cars){
        System.out.println("우승자는~~!");
        int max = getMaxPosition(cars);
        cars.stream().filter(car -> max == car.getPosition())
                .forEach(car -> System.out.println(car.getName()));
    }

    private static int getMaxPosition(List<Car> cars) {
        Car car = cars.stream().max(Comparator.comparing(Car::getPosition))
                .orElseThrow(NoSuchElementException::new);
        return car.getPosition();
    }


}

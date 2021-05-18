package javaCarRacingGame.util;

import javaCarRacingGame.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameUtilTest {

    @Test
    void java8_stream_테스트(){
        String[] userInputs = {"a", "b", "c"};

        List<Car> cars = new ArrayList<>();
        for (String carName : userInputs) {
            Car car = new Car(carName, 0);
            cars.add(car);
        }

        List<Car> cars1 = Arrays.stream(userInputs).map(s -> new Car(s, 0)).collect(Collectors.toList());

        assertThat(cars.get(0).getName()).isEqualTo(cars1.get(0).getName());
    }

    @Test
    void playTest(){
        List<Car> cars = GameUtil.userInput("a, b, c");
        GameUtil.playGames(10, cars);
        GameUtil.whoIsWinner(cars);
    }

    @Test
    public void 숫자_list_max_값_찾기() {
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("a", 9);
        Car car2 = new Car("b", 9);
        Car car3 = new Car("b", 8);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        GameUtil.whoIsWinner(cars);
    }
}
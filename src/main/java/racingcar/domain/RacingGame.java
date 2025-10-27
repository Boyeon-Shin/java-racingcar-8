package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private final List<Car> cars;

    public RacingGame(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> newCars = new ArrayList<>();
        for (String name : carNames) {
            newCars.add(new Car(name));
        }
        return newCars;
    }

    public void playRound() {
        for (Car car : cars) {
            int randomValue = generateRandomValue();
            car.move(randomValue);
        }
    }

    private int generateRandomValue() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return findCarNamesAtPosition(maxPosition);
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<String> findCarNamesAtPosition(int position) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == position) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}

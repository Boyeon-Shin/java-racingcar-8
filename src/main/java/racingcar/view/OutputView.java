package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String POSITION_SYMBOL = "-";
    private static final String DELIMITER = ", ";

    public void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        System.out.println();
        for (Car car : cars) {
            printCarStatus(car);
        }
    }

    private void printCarStatus(Car car) {
        System.out.println(car.getName() + " : " + createPositionString(car.getPosition()));
    }

    private String createPositionString(int position) {
        return POSITION_SYMBOL.repeat(position);
    }

    public void printWinners(List<String> winners) {
        System.out.println();
        System.out.println("최종 우승자 : " + String.join(DELIMITER, winners));
    }
}

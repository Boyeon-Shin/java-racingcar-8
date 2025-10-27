package racingcar.validator;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final  String DELIMITER = ",";

    public static void validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        String[] names = input.split(DELIMITER);
        for (String name : names) {
            validateCarName(name.trim());
        }
    }

    private static void validateCarName(final String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validateAttemptCount(String input) {
        try {
            int count  = Integer.parseInt(input);
            if(count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}

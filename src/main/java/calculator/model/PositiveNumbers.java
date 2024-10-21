package calculator.model;

import java.util.Collections;
import java.util.List;

public class PositiveNumbers {

    private static final String ERROR_POSITIVE_NUMBER_TYPE = "숫자는 양수를 입력해야 합니다.";
    private static final PositiveNumbers EMPTY_INSTANCE = new PositiveNumbers(List.of());

    private final List<Integer> numbers;

    private PositiveNumbers(List<Integer> numbers) {
        validatePositiveNumbers(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static PositiveNumbers from(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return EMPTY_INSTANCE;
        }
        return new PositiveNumbers(numbers);
    }

    private void validatePositiveNumbers(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 0)) {
            throw new IllegalArgumentException(ERROR_POSITIVE_NUMBER_TYPE);
        }
    }

    public int calculateSum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
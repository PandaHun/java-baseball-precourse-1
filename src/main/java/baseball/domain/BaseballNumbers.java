package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumbers {

    private static final int START_INCLUSIVE_IDX = 1;
    private static final int END_EXCLUSIVE_IDX = 4;
    private static final int NEEDS_SIZE = 3;
    private static final String SIZE_EXCEPTION_MESSAGE = "[ERROR] 숫자는 3개만 입력 가능합니다.";

    private final Set<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        baseballNumbers = IntStream.range(START_INCLUSIVE_IDX, END_EXCLUSIVE_IDX)
            .mapToObj(i -> new BaseballNumber(i, numbers.get(i - 1)))
            .collect(Collectors.toSet());
    }

    private void validateNumbers(List<Integer> numbers) {
        Set<Integer> converted = new HashSet<>(numbers);
        if (converted.size() != NEEDS_SIZE) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
    }

    public int size() {
        return baseballNumbers.size();
    }
}

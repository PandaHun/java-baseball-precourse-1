package baseball.domain;

public class BaseballNumber {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MINIMUM_POSITION = 1;
    private static final int MAXIMUM_POSITION = 3;
    private static final String NUMBER_EXCEPTION_MESSAGE = "[ERROR] %d 숫자를 가질 수 없습니다.";
    private static final String POSITION_EXCEPTION_MESSAGE = "[ERROR] %d 위치를 가질 수 없습니다.";


    private final int position;
    private final int number;

    public BaseballNumber(int position, int number) {
        this.position = position;
        this.number = number;
        validatePositionAndNumber();
    }

    private void validatePositionAndNumber() {
        if (position < MINIMUM_POSITION || position > MAXIMUM_POSITION) {
            throw new IllegalArgumentException(String.format(POSITION_EXCEPTION_MESSAGE, position));
        }
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(String.format(NUMBER_EXCEPTION_MESSAGE, number));
        }
    }

    public int number() {
        return number;
    }

    public int position() {
        return position;
    }
}

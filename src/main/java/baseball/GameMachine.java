package baseball;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;
import baseball.util.InputView;
import baseball.util.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.utils.Randoms;

public class GameMachine {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int REQUIREMENT_SIZE = 3;
    private static final long END_STRIKE_COUNT = 3;
    private static final String AGAIN = "1";
    private static final String AGAIN_OR_END_REGEX = "[12]";
    private static final Pattern AGAIN_OR_END_PATTERN = Pattern.compile(AGAIN_OR_END_REGEX);
    private static final boolean GAME_END = true;
    private static final boolean GAME_NOT_END = false;
    private static boolean isGameEnd;
    private static BaseballNumbers computerNumbers;

    public GameMachine() {
    }

    public void setUp() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < REQUIREMENT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        computerNumbers = new BaseballNumbers(numbers);
        isGameEnd = false;
    }

    public void play() {
        setUp();
        while (!isGameEnd) {
            String numbers = InputView.getNumbers();
            BaseballNumbers playerNumbers = new BaseballNumbers(parseNumbers(numbers));
            judgePlayer(playerNumbers);
        }
        needsAgain();
    }

    private void judgePlayer(BaseballNumbers playerNumbers) {
        long strikeCount = IntStream.range(1, 4)
            .filter(i -> computerNumbers.value(i - 1).equals(playerNumbers.value(i - 1)))
            .count();
        long ballCount = IntStream.range(1, 4)
            .map(i -> (int) judgeBall(i, playerNumbers.value(i - 1)))
            .sum();
        if (strikeCount == END_STRIKE_COUNT) {
            isGameEnd = GAME_END;
        }
        OutputView.showResult(strikeCount, ballCount);
    }

    private long judgeBall(int idx, BaseballNumber value) {
        return IntStream.range(1, 4)
            .filter(i -> i != idx)
            .filter(i -> computerNumbers.value(i - 1).number() == value.number())
            .count();
    }

    private List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }

    public void needsAgain() {
        String request = InputView.getAgainOrEnd();
        try {
            validateRequest(request);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        if (AGAIN.equals(request)) {
            isGameEnd = GAME_NOT_END;
        }
    }

    private void validateRequest(String request) {
        Matcher matcher = AGAIN_OR_END_PATTERN.matcher(request);
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
    }
}

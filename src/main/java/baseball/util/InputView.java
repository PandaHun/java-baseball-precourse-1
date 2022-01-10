package baseball.util;

import nextstep.utils.Console;

public class InputView {

    private static final String REQUEST_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String REQUEST_AGAIN_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";

    private InputView() {
    }

    public static String getNumbers() {
        System.out.print(REQUEST_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String getAgainOrEnd() {
        System.out.print(REQUEST_AGAIN_OR_END);
        return Console.readLine();
    }
}

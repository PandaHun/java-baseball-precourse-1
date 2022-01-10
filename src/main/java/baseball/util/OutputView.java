package baseball.util;

public class OutputView {

    private static final String GAME_END_MESSAGE = "게임 끝";
    private static final String NOTHING = "낫싱";
    private static final String STRIKE_PATTERN = "%d스트라이크 ";
    private static final String BALL_PATTERN = "%d볼 ";

    private OutputView() {
    }

    public static void gameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

    public static void showResult(long strikeCount, long ballCount) {
        if (strikeCount > 0) {
            showStrike(strikeCount);
        }
        if (ballCount > 0) {
            showBall(ballCount);
        }
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print(NOTHING);
        }
        System.out.println();
    }

    private static void showStrike(long strikeCount) {
        System.out.printf(STRIKE_PATTERN, strikeCount);
    }

    private static void showBall(long ballCount) {
        System.out.printf(BALL_PATTERN, ballCount);
    }
}

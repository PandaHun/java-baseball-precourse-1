package baseball;

import baseball.util.OutputView;

public class Application {

    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine();
        boolean runningFlag = true;
        while (runningFlag) {
            gameMachine.play();
            runningFlag = !gameMachine.isGameEnd();
        }
        OutputView.gameEnd();
    }
}

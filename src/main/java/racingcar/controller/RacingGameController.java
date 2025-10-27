package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<String> carNames = inputView.readCarNames();
        int attemptCount = inputView.readAttemptCount();

        RacingGame game = new RacingGame(carNames);
        playGame(game, attemptCount);

        List<String> winners = game.findWinners();
        outputView.printWinners(winners);
    }

    private void playGame(RacingGame game, int attemptCount) {
        outputView.printResultHeader();
        for (int i = 0; i < attemptCount; i++) {
            game.playRound();
            outputView.printRoundResult(game.getCars());
        }
    }
}
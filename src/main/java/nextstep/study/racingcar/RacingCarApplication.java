package nextstep.study.racingcar;

import nextstep.study.racingcar.controller.RaceController;

public class RacingCarApplication {

	public static void main(String[] args) {
		RaceController raceController = new RaceController();
		raceController.startGame();
	}

}

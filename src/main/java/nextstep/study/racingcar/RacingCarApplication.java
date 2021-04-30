package nextstep.study.racingcar;

import nextstep.study.racingcar.controller.RaceController;
import nextstep.study.racingcar.service.RaceInputService;

import java.util.List;

public class RacingCarApplication {

	public static void main(String[] args) {

		//자동차명과 시도횟수 입력 받기
		RaceInputService inputService = new RaceInputService();
		List<String> carNames = inputService.inputCarNames();
		int raceCount = inputService.inputRaceCount();

		//게임 시작하기
		RaceController raceController = new RaceController();
		raceController.startGame(carNames, raceCount);

	}

}

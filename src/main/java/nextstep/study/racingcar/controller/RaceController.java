package nextstep.study.racingcar.controller;

import nextstep.study.racingcar.domain.RaceResult;
import nextstep.study.racingcar.service.RaceGroup;
import nextstep.study.racingcar.service.RaceInputService;
import nextstep.study.racingcar.view.RaceView;

import java.util.List;

public class RaceController {

	private final RaceInputService inputService = new RaceInputService();

	public void startGame() {
		List<String> carNames = inputService.inputCarNames();
		int raceCount = inputService.inputRaceCount();

		RaceGroup raceGroup = new RaceGroup(carNames, raceCount);
		RaceResult raceResult = raceGroup.startRace();

		RaceView.printRaceResult(raceResult);
	}

}

package nextstep.study.racingcar.controller;

import nextstep.study.racingcar.domain.RaceGroup;
import nextstep.study.racingcar.domain.RaceResult;
import nextstep.study.racingcar.view.RaceView;

import java.util.List;

public class RaceController {

	public void startGame(List<String> carNames, int raceCount) {

		//경주 그룹 생성
		RaceGroup raceGroup = new RaceGroup(carNames, raceCount);

		//경주 시작
		RaceResult raceResult = raceGroup.startRace();

		//게임결과 출력하기
		RaceView.printRaceResult(raceResult);

	}

}

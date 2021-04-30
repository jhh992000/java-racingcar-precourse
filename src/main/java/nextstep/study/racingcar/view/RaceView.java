package nextstep.study.racingcar.view;

import nextstep.study.racingcar.domain.Car;
import nextstep.study.racingcar.domain.RaceResult;

import java.util.ArrayList;
import java.util.List;

public class RaceView {

	public static void printRaceResult(RaceResult raceResult) {
		System.out.println();
		System.out.println("실행 결과");
		for (int i = 0; i < raceResult.getRaceCount(); i++) {
			printRaceRound(raceResult, i);
			System.out.println();
		}
		printWinnerCars(raceResult.getWinnerCars());
	}

	private static void printRaceRound(RaceResult raceResult, int playIndex) {
		for (Car car : raceResult.getCars()) {
			System.out.print(car.getName() + ":" + car.getForwardCountByPlayIndex(playIndex));
			System.out.println();
		}
	}

	private static void printWinnerCars(List<Car> winnerCars) {
		List<String> winnerCarNames = new ArrayList<>();
		for (Car winnerCar : winnerCars) {
			winnerCarNames.add(winnerCar.getName());
		}
		System.out.println(String.join(",", winnerCarNames) + " 가 최종 우승했습니다.");
	}

}

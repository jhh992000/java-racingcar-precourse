package nextstep.study.racingcar.service;

import nextstep.study.racingcar.domain.Car;
import nextstep.study.racingcar.domain.RaceResult;

import java.util.ArrayList;
import java.util.List;

public class RaceGroup {

	private final List<Car> raceCars;
	private final int raceCount;

	public RaceGroup(List<String> carNames, int raceCount) {
		if (carNames == null || carNames.size() == 0) {
			throw new IllegalArgumentException("경주에 참여할 자동차는 최소 1개 이상이어야 합니다.");
		}
		if (raceCount < 1) {
			throw new IllegalArgumentException("경주 횟수는 최소 1회 이상이어야 합니다.");
		}
		this.raceCars = this.createCars(carNames);
		this.raceCount = raceCount;
	}

	private List<Car> createCars(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
		return cars;
	}

	public RaceResult startRace() {
		for (int i = 0; i < this.raceCount; i++) {
			this.play();
		}
		return new RaceResult(this.raceCars, this.raceCount);
	}

	private void play() {
		for (Car car : this.raceCars) {
			car.goForward();
		}
	}

}

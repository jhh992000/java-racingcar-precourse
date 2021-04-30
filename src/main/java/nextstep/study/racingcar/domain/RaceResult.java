package nextstep.study.racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RaceResult {
	private final List<Car> cars;
	private final int raceCount;
	private List<Car> winners = new ArrayList<>();

	public RaceResult(List<Car> cars, int raceCount) {
		this.cars = cars;
		this.raceCount = raceCount;
	}

	public int getRaceCount() {
		return raceCount;
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<Car> getWinnerCars() {
		List<Car> cloneCars = this.cloneCars(this.cars);
		int winnerForwardCount = this.getWinnerForwardCount(cloneCars);

		winners.clear();
		for (Car car : cloneCars) {
			this.setWinnerCar(car, winnerForwardCount);
		}
		return winners;
	}

	private List<Car> cloneCars(List<Car> cars) {
		return (ArrayList<Car>) ((ArrayList<Car>) cars).clone();
	}

	private int getWinnerForwardCount(List<Car> cars) {
		return this.descendingCars(cars).get(0).getForwardCount();
	}

	private List<Car> descendingCars(List<Car> cloneCars) {
		cloneCars.sort(Comparator.comparing(Car::getForwardCount).reversed().thenComparing(Car::getName));
		return cloneCars;
	}

	private void setWinnerCar(Car car, int winnerForwardCount) {
		if (car.getForwardCount() == winnerForwardCount) {
			this.winners.add(car);
		}
	}
}

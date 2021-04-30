package nextstep.study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("경주 결과 테스트")
public class RaceResultTest {

	@Test
	@DisplayName("우승자 선별 테스트")
	void test_getWinners() {
		//given
		Car car1 = new Car("pobi1", new CarSpeeds(new Speed(1)));
		Car car2 = new Car("pobi2", new CarSpeeds(new Speed(2)));
		Car car3 = new Car("pobi3", new CarSpeeds(new Speed(3)));
		Car car4 = new Car("pobi4", new CarSpeeds(new Speed(4)));
		Car car5 = new Car("pobi5", new CarSpeeds(new Speed(5)));
		Car car6 = new Car("pobi6", new CarSpeeds(new Speed(6)));
		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);
		cars.add(car6);

		//when
		RaceResult raceResult = new RaceResult(cars, 1);

		//then
		assertThat(raceResult.getWinnerCars()).hasSize(3)
				.contains(car4)
				.contains(car5)
				.contains(car6);
	}

}

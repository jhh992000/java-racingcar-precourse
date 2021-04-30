package nextstep.study.racingcar.service;

import nextstep.study.racingcar.domain.Car;
import nextstep.study.racingcar.domain.RaceResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("경주 그룹 테스트")
public class RaceGroupTest {

	@Test
	@DisplayName("경주 그룹 - 생성 테스트")
	void test_createRaceGroup() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			RaceGroup raceGroup = new RaceGroup(new ArrayList<>(), 4);
		});

		assertThatIllegalArgumentException().isThrownBy(() -> {
			RaceGroup raceGroup = new RaceGroup(Arrays.asList("poro"), 0);
		});

		assertThatIllegalArgumentException().isThrownBy(() -> {
			RaceGroup raceGroup = new RaceGroup(Arrays.asList("pororo"), 4);
		});

		RaceGroup raceGroup = new RaceGroup(Arrays.asList("poro", "crong", "pobi", "loopy", "petty"), 4);
	}

	@Test
	@DisplayName("경주 그룹 - 경주 테스트")
	void test_raceGroup_race() {
		RaceGroup raceGroup = new RaceGroup(Arrays.asList("pobi", "crong", "honux"), 3);
		RaceResult raceResult = raceGroup.startRace();

		System.out.println("실행 결과");
		for (int i = 0; i < raceResult.getRaceCount(); i++) {
			for (Car car : raceResult.getCars()) {
				System.out.print(car.getName() + ":" + car.getForwardCountByPlayIndex(i));
				System.out.println();
			}
			System.out.println();
		}


		int maxForwardCount = this.getMaxForwardCount(raceResult.getCars());
		System.out.println("최대 전진 횟수 : " + maxForwardCount);

		System.out.println();
		System.out.println("--우승자 목록--");

		List<Car> winnerCars = raceResult.getWinnerCars();
		for (Car winnerCar : winnerCars) {
			System.out.println(winnerCar.getName());
			assertThat(winnerCar.getForwardCount()).isEqualTo(maxForwardCount);
		}
	}

	private int getMaxForwardCount(List<Car> cars) {
		int maxForwardCount = 0;
		for (Car car : cars) {
			if (car.getForwardCount() > maxForwardCount) {
				maxForwardCount = car.getForwardCount();
			}
		}
		return maxForwardCount;
	}

}

package nextstep.study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarSpeedsTest {

	@Test
	@DisplayName("속도가 4이상인 전진횟수 확인")
	void test_forwardCount() {
		CarSpeeds carSpeeds = new CarSpeeds();
		carSpeeds.add(new Speed(2));
		carSpeeds.add(new Speed(3));
		carSpeeds.add(new Speed(4));
		carSpeeds.add(new Speed(5));

		assertThat(carSpeeds.getForwardCount()).isEqualTo(2);
	}

}

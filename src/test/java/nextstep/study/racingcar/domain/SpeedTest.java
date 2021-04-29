package nextstep.study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("속도(랜덤)수 테스트")
public class SpeedTest {

	@Test
	@DisplayName("생성한 랜덤값이 0~9사이의 값인지 확인")
	void test_randomNo() {
		TestNumberGenerator testNumberGenerator = new TestNumberGenerator(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
		for (int i = 0; i < 10; i++) {
			Speed speed = new Speed(testNumberGenerator);
			assertThat(speed.getSpeedNo()).isBetween(0, 9);
		}
	}

	@Test
	@DisplayName("생성한 속도값이 전진할 수 있는 값인지 확인")
	void test_forwardPossible() {
		assertThat(new Speed(3).isForwardable()).isFalse();
		assertThat(new Speed(4).isForwardable()).isTrue();
	}

}

package nextstep.study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("자동차 테스트")
public class CarTest {

	@Test
	@DisplayName("자동차 이름이 유효한지 확인, 5자 이내인지 확인")
	void carNameCheck() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Car car = new Car("abcdef");
		});

		Car car = new Car("abcde");
	}

	@Test
	@DisplayName("전진 테스트")
	void goForwardTest() {
		Car car = new Car("mycar");

		car.goForward(2);
		car.goForward(3);
		car.goForward(4);
		car.goForward(5);

		assertThat(car.getForwardCount()).isEqualTo(2);
	}

}

package nextstep.study.racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사용자 입력 서비스 테스트")
public class RaceInputServiceTest {
	RaceInputService raceInputService = new RaceInputService();

	@Test
	@DisplayName("입력한 자동차명 리스트가 유효한지 체크")
	void test_validationInputCarNames() {
		assertThat(raceInputService.validationInputCarNames("111,222,333")).isTrue();

		assertThatIllegalArgumentException().isThrownBy(() -> {
			boolean result = raceInputService.validationInputCarNames("");
		});

		assertThatIllegalArgumentException().isThrownBy(() -> {
			boolean result = raceInputService.validationInputCarNames("111,222,333333");
		});
	}

	@Test
	@DisplayName("자동차명이 유효한지 체크")
	void test_validationCarName() {
		assertThat(raceInputService.validationCarName("123")).isTrue();

		assertThatIllegalArgumentException().isThrownBy(() -> {
			boolean result = raceInputService.validationCarName("123456");
		});
	}

	@Test
	@DisplayName("사용자가 입력한 시도 횟수 문자열이 유효한지 체크")
	void test_validationInputRaceCount() {
		assertThat(raceInputService.validationInputRaceCount("123")).isTrue();

		assertThatIllegalArgumentException().isThrownBy(() -> {
			boolean result = raceInputService.validationInputRaceCount("123a");
		});
	}

	@Test
	@DisplayName("사용자가 입력한 자동차명 문자열이 유효하지 않을경우 재입력 여부 체크")
	void test_isContinuesInputCarNames() {
		assertThat(raceInputService.isContinuesInputCarNames("12345,67890")).isFalse();
		assertThat(raceInputService.isContinuesInputCarNames("123456,1234567")).isTrue();
	}

	@Test
	@DisplayName("사용자가 입력한 시도 횟수 문자열이 유효하지 않을경우 재입력 여부 체크")
	void test_isContinuesInputRaceCount() {
		assertThat(raceInputService.isContinuesInputRaceCount("10")).isFalse();
		assertThat(raceInputService.isContinuesInputRaceCount("abc")).isTrue();
	}

	@Test
	@DisplayName("입력값이 숫자가 아닐경우 체크")
	void test_wrongInputNumber() {
		String strNum = "1a3";
		boolean isNum = RaceInputService.isNumeric(strNum);
		assertThat(isNum).isFalse();
	}

	@Test
	@DisplayName("입력값이 숫자인 경우 테스트")
	void test_inputNumber() {
		String strNum = "123";
		boolean isNum = RaceInputService.isNumeric(strNum);
		assertThat(isNum).isTrue();
	}

	@Test
	@DisplayName("문자열을 리스트로 변환 테스트")
	void testStrToIntArray() {
		String str = "pobi,crong,loopy";
		List<String> carNames = RaceInputService.stringToList(str, RaceInputService.CAR_NAME_DELIMITER);

		assertThat(String.join(RaceInputService.CAR_NAME_DELIMITER, carNames)).isEqualTo(str);
	}

}

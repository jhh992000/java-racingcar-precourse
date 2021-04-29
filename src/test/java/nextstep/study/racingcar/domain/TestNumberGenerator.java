package nextstep.study.racingcar.domain;

public class TestNumberGenerator implements NumberGenerator {
	private Integer[] numbers;
	private int index = 0;

	public TestNumberGenerator(Integer[] numbers) {
		this.numbers = numbers;
	}

	@Override
	public int generateNumber() {
		if (this.index > MAX_NO) {
			this.index = 0;
		}
		return this.numbers[this.index++];
	}

}

package nextstep.study.racingcar.domain;

public class Speed {

	private static final int FORWARD_GREATER_NO = 4;
	private final int speedNo;

	public Speed() {
		this.speedNo = new RandomNumberGenerator().generateNumber();
	}

	public Speed(int speedNo) {
		if (speedNo < NumberGenerator.MIN_NO || speedNo > NumberGenerator.MAX_NO) {
			throw new IllegalArgumentException("자동차 속도는 0~9사이의 값이어야 합니다.");
		}
		this.speedNo = speedNo;
	}

	public Speed(NumberGenerator numberGenerator) {
		this.speedNo = numberGenerator.generateNumber();
	}

	public Speed(NumberGenerator numberGenerator, int speedNo) {
		if (speedNo < NumberGenerator.MIN_NO || speedNo > NumberGenerator.MAX_NO) {
			throw new IllegalArgumentException("자동차 속도는 0~9사이의 값이어야 합니다.");
		}
		this.speedNo = numberGenerator.generateNumber();
	}

	public boolean isForwardable() {
		return this.speedNo >= FORWARD_GREATER_NO;
	}

	public void printForwardString() {
		if (this.isForwardable()) {
			System.out.print("-");
		}
	}

	public int getSpeedNo() {
		return speedNo;
	}

}

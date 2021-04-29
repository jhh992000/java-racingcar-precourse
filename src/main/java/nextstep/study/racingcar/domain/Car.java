package nextstep.study.racingcar.domain;

public class Car {
	private final String name;
	private CarSpeeds carSpeeds;

	public Car(String name) {
		validateCarName(name);
		this.name = name;
		this.carSpeeds = new CarSpeeds();
	}

	protected boolean validateCarName(String carName) {
		if (carName == null || carName.length() == 0) {
			throw new IllegalArgumentException("자동차의 이름은 필수 입력항목입니다.");
		}
		if (carName.length() > 5) {
			throw new IllegalArgumentException("자동차의 이름은 5자 이내로 입력하셔야 합니다.");
		}
		return false;
	}

	public boolean goForward() {
		return this.goForward(new Speed());
	}

	public boolean goForward(int speedNo) {
		return this.goForward(new Speed(speedNo));
	}

	private boolean goForward(Speed speed) {
		this.carSpeeds.add(speed);
		return speed.isForwardable();
	}

	public int getForwardCount() {
		return this.carSpeeds.getForwardCount();
	}

}

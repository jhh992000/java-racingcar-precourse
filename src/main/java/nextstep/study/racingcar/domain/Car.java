package nextstep.study.racingcar.domain;

public class Car {
	private final String name;
	private CarSpeeds carSpeeds;

	public Car(String name) {
		validateCarName(name);
		this.name = name;
		this.carSpeeds = new CarSpeeds();
	}

	public Car(String name, CarSpeeds carSpeeds) {
		validateCarName(name);
		this.name = name;
		this.carSpeeds = carSpeeds;
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

	public CarStatus goForward() {
		return this.goForward(new Speed());
	}

	public CarStatus goForward(int speedNo) {
		return this.goForward(new Speed(speedNo));
	}

	private CarStatus goForward(Speed speed) {
		this.carSpeeds.add(speed);
		return speed.isForwardable() ? CarStatus.FORWARD : CarStatus.STOP;
	}

	public String getName() {
		return name;
	}

	public int getForwardCount() {
		return this.carSpeeds.getForwardCount();
	}

	public int getForwardCountByPlayIndex(int playIndex) {
		return this.carSpeeds.getForwardCount(playIndex);
	}

}

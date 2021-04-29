package nextstep.study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarSpeeds {

	private List<Speed> speeds = new ArrayList<>();

	public CarSpeeds() {

	}

	public void add(Speed speed) {
		this.speeds.add(speed);
	}

	public int getForwardCount() {
		int sum = 0;
		for (Speed speed : speeds) {
			sum += speed.getForwardCount();
		}
		return sum;
	}

}

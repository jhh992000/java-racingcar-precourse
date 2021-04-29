package nextstep.study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarSpeeds {

	private List<Speed> speeds = new ArrayList<>();

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

	public int getForwardCount(int playIndex) {
		if (playIndex > speeds.size()) {
			throw new IllegalArgumentException("경주 회차는 총 경주횟수보다 클 수 없습니다.");
		}
		int sum = 0;
		for (int i = 0; i <= playIndex; i++) {
			Speed speed = speeds.get(i);
			sum += speed.getForwardCount();
		}
		return sum;
	}

}

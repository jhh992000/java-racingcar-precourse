package nextstep.study.racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

	@Override
	public int generateNumber() {
		return new Random().nextInt(MAX_NO + 1);
	}

}

package nextstep.study.racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RaceInputService {

	public static final String CAR_NAME_DELIMITER = ",";
	private final Scanner scanner = new Scanner(System.in);

	private String getInputString() {
		return this.scanner.nextLine();
	}

	public List<String> inputCarNames() {
		boolean continues = true;
		String inputCarNames = null;
		while (continues) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			inputCarNames = getInputString();
			continues = isContinuesInputCarNames(inputCarNames);
		}
		return stringToList(inputCarNames, CAR_NAME_DELIMITER);
	}

	public int inputRaceCount() {
		boolean continues = true;
		String inputNums = null;
		while (continues) {
			System.out.println("시도할 횟수는 몇회인가요?");
			inputNums = getInputString();
			continues = isContinuesInputRaceCount(inputNums);
		}
		return Integer.parseInt(inputNums);
	}

	protected boolean isContinuesInputCarNames(String inputCarNames) {
		boolean continues;
		try {
			continues = !validationInputCarNames(inputCarNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			continues = true;
		}
		return continues;
	}

	protected boolean isContinuesInputRaceCount(String inputNums) {
		boolean continues;
		try {
			continues = !validationInputRaceCount(inputNums);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			continues = true;
		}
		return continues;
	}

	protected boolean validationInputCarNames(String inputCarNames) throws IllegalArgumentException {
		if (inputCarNames == null || inputCarNames.trim().length() == 0) {
			throw new IllegalArgumentException("자동차의 이름은 필수 입력항목입니다.");
		}
		List<String> carNames = stringToList(inputCarNames, CAR_NAME_DELIMITER);
		for (String carName : carNames) {
			validationCarName(carName);
		}
		return true;
	}

	protected boolean validationInputRaceCount(String inputNums) throws IllegalArgumentException {
		if (inputNums == null || inputNums.trim().length() == 0) {
			return false;
		}
		if (!isNumeric(inputNums)) {
			throw new IllegalArgumentException("경주 횟수는 숫자만 입력가능합니다.");
		}
		if (Integer.parseInt(inputNums) < 1) {
			throw new IllegalArgumentException("경주 횟수는 최소 1회 이상이어야 합니다.");
		}
		return true;
	}

	protected boolean validationCarName(String carName) throws IllegalArgumentException {
		if (carName == null || carName.trim().length() == 0) {
			throw new IllegalArgumentException("자동차의 이름은 필수 입력항목입니다.");
		}
		if (carName.trim().length() > 5) {
			throw new IllegalArgumentException("자동차의 이름은 5자 이내로 입력하셔야 합니다.");
		}
		return true;
	}

	public static List<String> stringToList(String str, String delimiter) {
		return Arrays.asList(str.split(delimiter));
	}

	public static boolean isNumeric(String str) {
		if (str == null || str.trim().length() == 0) {
			return false;
		}
		String regex = "[0-9]+";
		return str.matches(regex);
	}

}

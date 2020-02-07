package utils;

import java.util.List;

public class Validator {
	private static final String MINUS = "-";
	private static final int ONE = 1;
	private static final int ZERO = 0;

	public static boolean isValidSize(List<String> tokens) {
		if ((tokens.size() & ONE) == ONE) {
			return true;
		}
		return false;
	}

	public static void checkDivideByZero(double number) {
		if (number == ZERO) {
			throw new ArithmeticException("0으로 나눌 수는 없습니다.");
		}
	}

	public static void checkIsNumber(String term) {
		if (!isNumber(term)) {
			throw new IllegalArgumentException("유효한 식이 아닙니다.");
		}
	}

	public static void checkIsValidExpression(List<String> tokens) {
		if (!isValidSize(tokens) || !isNumber(tokens.get(ZERO))) {
			throw new IllegalArgumentException("유효한 식이 아닙니다.");
		}
	}

	public static boolean isNumber(String term) {
		int firstIndex = ZERO;

		if (isFirstNumberMinus(term)) {
			firstIndex = ONE;
		}

		for (int i = firstIndex; i < term.length(); i++) {
			if (Character.isDigit(term.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public static boolean isFirstNumberMinus(String term) {
		if (term.startsWith(MINUS) && term.length() > ONE) {
			return true;
		}
		return false;
	}
}
package pl.lodz.uni.math.dart301;

public enum PossibleMultipliers {
	SINGLE(1), DOUBLE(2), TRIPLE(3);

	private int value;

	private PossibleMultipliers(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

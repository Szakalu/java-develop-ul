package pl.lodz.uni.math.dart301;

public enum PointsOnBoard {
	ONE(1), TWO(2), THREE(3), FOURE(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), ELEVEN(11), TWELVE(
			12), THIRTEEN(13), FOURTEEN(14), FIFTEEN(
					15), SIXTEEN(16), SEVENTEEN(17), EIGHTEEN(18), NINETEEN(19), TWENTY(20), BULL(25), BULLSEYE(50);

	private int value;

	private PointsOnBoard(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

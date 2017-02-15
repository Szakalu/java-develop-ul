package pl.lodz.uni.math.dart301;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DartGameTest {

	DartGame dartGame;

	@Before
	public void setDartGame() {
		dartGame = new DartGame();
	}

	@Test
	public void winDartGameTest() {
		dartGame.newGame();
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.ONE, PossibleMultipliers.SINGLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.SINGLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.DOUBLE);
		assertEquals(0, dartGame.getScore());
	}

	@Test
	public void unlimitedDartGameHitingToOneTest() {
		dartGame.newGame();
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		assertEquals(61, dartGame.getScore());
	}

	@Test
	public void unlimitedDartGameHitingLowerThenZeroTest() {
		dartGame.newGame();
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.SINGLE);
		dartGame.throwDart(PointsOnBoard.ONE, PossibleMultipliers.SINGLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		assertEquals(40, dartGame.getScore());
	}

	@Test
	public void unlimitedDartGameLastScoreWasNotDouble() {
		dartGame.newGame();
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.TRIPLE);
		dartGame.throwDart(PointsOnBoard.TWENTY, PossibleMultipliers.SINGLE);
		dartGame.throwDart(PointsOnBoard.ONE, PossibleMultipliers.SINGLE);
		dartGame.throwDart(PointsOnBoard.TEN, PossibleMultipliers.SINGLE);
		dartGame.throwDart(PointsOnBoard.TEN, PossibleMultipliers.TRIPLE);
		assertEquals(30, dartGame.getScore());
	}
}
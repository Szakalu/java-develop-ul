package pl.lodz.uni.math.dart301;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
	static List<PointsOnBoard> pointsOnBoardList = new ArrayList<PointsOnBoard>();
	static List<PossibleMultipliers> possibleMultipliers = new ArrayList<PossibleMultipliers>();
	static DartGame dartGame;

	public static void main(String[] args) {
		createTwoListsOfEnums();
		dartGame = new DartGame();
		dartGame.newGame();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
		randomDartThrow();
	}

	private static void randomDartThrow() {
		Random random = new Random();
		int randomPoint = random.nextInt(22);
		int randomMult = random.nextInt(3);

		if (PointsOnBoard.BULL.equals(pointsOnBoardList.get(randomPoint))
				|| PointsOnBoard.BULLSEYE.equals(pointsOnBoardList.get(randomPoint))) {
			randomMult = 0;
		}

		PointsOnBoard pointsOnBoard = pointsOnBoardList.get(randomPoint);
		PossibleMultipliers multipliers = possibleMultipliers.get(randomMult);
		System.out.println("Point: " + (pointsOnBoard.getValue() * multipliers.getValue()));
		System.out.println("Hit: " + pointsOnBoard.getValue() + " Mult: " + multipliers.getValue());
		dartGame.throwDart(pointsOnBoardList.get(randomPoint), possibleMultipliers.get(randomMult));
	}

	private static void createTwoListsOfEnums() {
		possibleMultipliers.add(PossibleMultipliers.SINGLE);
		possibleMultipliers.add(PossibleMultipliers.DOUBLE);
		possibleMultipliers.add(PossibleMultipliers.TRIPLE);

		pointsOnBoardList.add(PointsOnBoard.ONE);
		pointsOnBoardList.add(PointsOnBoard.TWO);
		pointsOnBoardList.add(PointsOnBoard.THREE);
		pointsOnBoardList.add(PointsOnBoard.FOURE);
		pointsOnBoardList.add(PointsOnBoard.FIVE);
		pointsOnBoardList.add(PointsOnBoard.SIX);
		pointsOnBoardList.add(PointsOnBoard.SEVEN);
		pointsOnBoardList.add(PointsOnBoard.EIGHT);
		pointsOnBoardList.add(PointsOnBoard.NINE);
		pointsOnBoardList.add(PointsOnBoard.TEN);
		pointsOnBoardList.add(PointsOnBoard.ELEVEN);
		pointsOnBoardList.add(PointsOnBoard.TWELVE);
		pointsOnBoardList.add(PointsOnBoard.THIRTEEN);
		pointsOnBoardList.add(PointsOnBoard.FOURTEEN);
		pointsOnBoardList.add(PointsOnBoard.FIFTEEN);
		pointsOnBoardList.add(PointsOnBoard.SIXTEEN);
		pointsOnBoardList.add(PointsOnBoard.SEVENTEEN);
		pointsOnBoardList.add(PointsOnBoard.EIGHTEEN);
		pointsOnBoardList.add(PointsOnBoard.NINETEEN);
		pointsOnBoardList.add(PointsOnBoard.TWENTY);
		pointsOnBoardList.add(PointsOnBoard.BULL);
		pointsOnBoardList.add(PointsOnBoard.BULLSEYE);
	}
}

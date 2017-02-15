package pl.lodz.uni.math.dart301;

import org.apache.log4j.Logger;

public class DartGame {

	private static Logger logger = Logger.getLogger(DartGame.class.getName());

	private int score;

	public void throwDart(PointsOnBoard pointHit, PossibleMultipliers multiplier) {
		if (score == 0) {
			logger.info("You already won, maybe new game ??");
		} else {
			tryChangeScore(pointHit, multiplier);
			validScore(pointHit, multiplier);
			logger.info("Score: " + getScore());
		}
	}

	private void validScore(PointsOnBoard pointHit, PossibleMultipliers multiplier) {
		if (score == 0) {
			checkIfLastHitWasDouble(pointHit, multiplier);
		} else if (score < 0 || score == 1) {
			doWhenScoreLowerThenZeroOrIsOne(pointHit, multiplier);
		}
	}

	private void checkIfLastHitWasDouble(PointsOnBoard pointHit, PossibleMultipliers multiplier) {
		if (!multiplier.equals(PossibleMultipliers.DOUBLE)) {
			int pointsScored = pointHit.getValue() * multiplier.getValue();
			setScore(score + pointsScored);
			logger.info("Last hit was not double !!!");
		} else {
			logger.info("Congratulates you won !!!");
		}
	}

	private void doWhenScoreLowerThenZeroOrIsOne(PointsOnBoard pointHit, PossibleMultipliers multiplier) {
		int pointsScored = pointHit.getValue() * multiplier.getValue();
		setScore(score + pointsScored);
		logger.info("You score too many points !!!");
	}

	private void checkMultiplier(PointsOnBoard pointHit, PossibleMultipliers multiplier) {
		if (!multiplier.equals(PossibleMultipliers.SINGLE)) {
			if (pointHit.equals(PointsOnBoard.BULL) || pointHit.equals(PointsOnBoard.BULLSEYE)) {
				multiplier = PossibleMultipliers.SINGLE;
			}
		}
	}

	private void tryChangeScore(PointsOnBoard pointHit, PossibleMultipliers multiplier) {
		checkMultiplier(pointHit, multiplier);
		int pointsScored = pointHit.getValue() * multiplier.getValue();
		setScore(score - pointsScored);
	}

	public void newGame() {
		setScore(301);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}

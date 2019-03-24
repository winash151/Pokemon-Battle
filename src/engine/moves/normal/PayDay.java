package engine.moves.normal;

import engine.moves.Move;

public class PayDay extends NormalMove {

	/**
	 * id 275
	 * physical move
	 * base power 40
	 * base accuracy of 100
	 * pp 20
	 */
	public PayDay() {
		super(6, Move.PHYSICAL, 40, 1.0, 20, "Pay Day");
		setDescription("Numerous coins are hurled at the target to inflict damage. Money is earned after the battle.");
	}

	@Override
	public Move newInstance() {
		return new PayDay();
	}

}

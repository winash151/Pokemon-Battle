package engine.moves.normal;

import engine.moves.Move;

public class ExtremeSpeed extends NormalMove {

	/**
	 * id 243
	 * physical move
	 * base power 80
	 * base accuracy of 100
	 * pp 5
	 * speed priority 1
	 */
	public ExtremeSpeed() {
		super(245, Move.PHYSICAL, 80, 1.0, 5, "Extreme Speed", 2);
		setDescription("The user charges the target at blinding speed. This move always goes first.");
	}

	@Override
	public Move newInstance() {
		return new ExtremeSpeed();
	}

}

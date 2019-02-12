package engine.moves.water;

import engine.moves.Move;

public class AquaJet extends WaterMove {

	/**
	 * id 279
	 * physical move
	 * base power 40
	 * base accuracy of 100
	 * pp 30
	 * speed priority 1
	 */
	public AquaJet() {
		super(453, Move.PHYSICAL, 40, 1.0, 20, "Aqua Jet", 1);
		setDescription("The user lunges at the target speed that makes it almost invisible. This move always goes first.");
	}

	@Override
	public Move newInstance() {
		return new AquaJet();
	}
}

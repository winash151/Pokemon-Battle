package engine.moves.normal;

import engine.moves.Move;

public class Return extends NormalMove {

	/**
	 * id 315
	 * physical move
	 * base power 50
	 * base accuracy of 100
	 * pp 35
	 */
	public Return() {
		super(216, Move.PHYSICAL, 102, 1.0, 20, "Return");
		setDescription("A full-power attack that grows more powerful the more the user likes its Trainer.");
	}

	@Override
	public Move newInstance() {
		return new Return();
	}

}
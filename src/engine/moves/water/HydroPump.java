package engine.moves.water;

import engine.moves.Move;

public class HydroPump extends WaterMove {

	/**
	 * id 411
	 * special move
	 * base power 120
	 * base accuracy 80
	 * pp 5
	 */
	public HydroPump() {
		super(56, Move.SPECIAL, 120, 0.80, 5, "Hydro Pump");
		setDescription("The target is blasted by a huge volume of water launched under great pressure.");
	}

	@Override
	public Move newInstance() {
		return new HydroPump();
	}
}

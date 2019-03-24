package engine.moves.ground;

import engine.moves.Move;

public class Earthquake extends GroundMove {

	/**
	 * id 176
	 * physical
	 * base power 120
	 * 85 base accuracy
	 * pp 10
	 */
	public Earthquake() {
		super(89, Move.PHYSICAL, 100, 100, 10, "Earthquake");
		setDescription("The user sets off an earthquake that strikes every Pokémon around it.");
	}

	@Override
	public Move newInstance() {
		return new Earthquake();
	}

}

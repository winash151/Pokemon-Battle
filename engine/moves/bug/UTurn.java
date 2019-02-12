package engine.moves.bug;

import engine.moves.Move;

public class UTurn extends BugMove {

	/**
	 * id 315
	 * physical move
	 * base power 50
	 * base accuracy of 100
	 * pp 35
	 */
	public UTurn() {
		super(369, Move.PHYSICAL, 70, 1.0, 20, "U-Turn");
		setDescription("After making its attack, the user rushes back to switch places with a party Pokémon in waiting.");
	}

	@Override
	public Move newInstance() {
		return new UTurn();
	}

}
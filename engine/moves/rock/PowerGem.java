package engine.moves.rock;

import engine.moves.Move;

public class PowerGem extends RockMove {

	/**
	 * id 411
	 * special move
	 * base power 120
	 * base accuracy 80
	 * pp 5
	 */
	public PowerGem() {
		super(408, Move.SPECIAL, 80, 1, 20, "Power Gem");
		setDescription("The user attacks with a ray of light that sparkles as if it were made of gemstones.");
	}

	@Override
	public Move newInstance() {
		return new PowerGem();
	}
}
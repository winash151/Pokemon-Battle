package engine.moves.dragon;

import engine.moves.Move;

public class SpacialRend extends DragonMove {

	/**
	 * id 127
	 * special move
	 * base power 100
	 * base accuracy 95
	 * pp 5
	 * high crit rate
	 */
	public SpacialRend() {
		super(460, Move.SPECIAL, 100, .95, 5, "Spacial Rend", 0, 1);
		setDescription("The user tears the target along with the space around it. Critical hits land more easily.");
	}

	@Override
	public Move newInstance() {
		return new SpacialRend();
	}
}
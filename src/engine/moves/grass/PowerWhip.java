package engine.moves.grass;

import engine.moves.Move;

public class PowerWhip extends GrassMove {
	
	/**
	 * id 176
	 * physical
	 * base power 120
	 * 85 base accuracy
	 * pp 10
	 */
	public PowerWhip() {
		super(438, Move.PHYSICAL, 120, 0.85, 10, "Power Whip");
		setDescription("The user violently whirls its vines or tentacles to harshly lash the target.");
	}

	@Override
	public Move newInstance() {
		return new PowerWhip();
	}
}

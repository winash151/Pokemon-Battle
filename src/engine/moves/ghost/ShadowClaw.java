package engine.moves.ghost;

import engine.moves.Move;

public class ShadowClaw extends GhostMove {

	/**
	 * id 153
	 * physical
	 * base power 70
	 * 100 base accuracy
	 * pp 15
	 * high crit rate
	 */
	public ShadowClaw() {
		super(421, Move.PHYSICAL, 70, 1.0, 15, "Shadow Claw", 0, 1);
		setDescription("The user slashes with a sharp claw made from shadows. Critical hits land more easily.");
	}

	@Override
	public Move newInstance() {
		return new ShadowClaw();
	}
}

package engine.moves.ghost;

import engine.moves.Move;

public class ShadowSneak extends GhostMove {

	/**
	 * id 279
	 * physical move
	 * base power 40
	 * base accuracy of 100
	 * pp 30
	 * speed priority 1
	 */
	public ShadowSneak() {
		super(425, Move.PHYSICAL, 40, 1.0, 30, "Shadow Sneak", 1);
		setDescription("The user extends its shadow and attacks the target from behind. This move always goes first.");
	}

	@Override
	public Move newInstance() {
		return new ShadowSneak();
	}
}
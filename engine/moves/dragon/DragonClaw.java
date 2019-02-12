package engine.moves.dragon;

import engine.moves.Move;

public class DragonClaw extends DragonMove {

	/**
	 * Dragon Claw has an id of 41
	 * it is physical
	 * it has a base power of 80
	 * accuracy of 100
	 * and 15 pp
	 */
	public DragonClaw() {
		super(337, Move.PHYSICAL, 80, 1.0, 15, "Dragon Claw");
		setDescription("Sharp, huge claws hook and slash the foe quickly and with great power.");
	}

	@Override
	public Move newInstance() {
		return new DragonClaw();
	}
}

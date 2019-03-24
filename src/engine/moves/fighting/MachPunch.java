package engine.moves.fighting;

import engine.moves.Move;

public class MachPunch extends FightingMove {

	/**
	 * id 279
	 * physical move
	 * base power 40
	 * base accuracy of 100
	 * pp 30
	 * speed priority 1
	 */
	public MachPunch() {
		super(183, Move.PHYSICAL, 40, 1.0, 30, "Mach Punch", 1);
		setDescription("The user throws a punch at blinding speed. This move always goes first.");
	}

	@Override
	public Move newInstance() {
		return new MachPunch();
	}
}

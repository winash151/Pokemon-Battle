package engine.moves.electric;

import engine.Statuses;
import engine.moves.Move;

public class ThunderPunch extends ElectricMove {

	/**
	 * id 109
	 * physical
	 * 65 base power
	 * 95 base accuracy
	 * burn 10 percent
	 */
	public ThunderPunch() {
		super(424, Move.PHYSICAL, 75, 1, 15, "Thunder Punch", Statuses.PARALYSIS, 0.1);
		setDescription("The target is punched with an electrified fist. This may also leave the target with paralysis.");
	}
	
	

	@Override
	public Move newInstance() {
		return new ThunderPunch();
	}
}

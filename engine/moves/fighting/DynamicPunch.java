package engine.moves.fighting;

import engine.InBattlePokemon;
import engine.Statuses;
import engine.moves.Move;

public class DynamicPunch extends FightingMove {

	/**
	 * id 419
	 * special move
	 * base powre 60
	 * base acccuracy 100
	 * pp 20
	 * confuses target 20 percent
	 */
	public DynamicPunch() {
		super(223, Move.PHYSICAL, 100, .5, 5, "Dynamic Punch", Statuses.CONFUSED,
				1);
		setDescription("The user punches the target with full, concentrated power. This confuses the target if it hits.");
	}
	
	public boolean willSideStatusOccur(InBattlePokemon user,
			InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new DynamicPunch();
	}
}

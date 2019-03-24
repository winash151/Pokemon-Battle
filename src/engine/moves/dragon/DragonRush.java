package engine.moves.dragon;

import engine.Statuses;
import engine.moves.Move;

public class DragonRush extends DragonMove {

	/**
	 * di 129
	 * special mvoe
	 * base power 75
	 * bace accuracy 95
	 * pp 15
	 * flinches 30 percent
	 */
	public DragonRush() {
		super(407, Move.PHYSICAL, 100, .75, 10, "Dragon Rush", Statuses.FLINCHED,
				0.2);
		setDescription("The user tackles the target while exhibiting overwhelming menace. This may also make the target flinch.");
	}

	
	public Move newInstance() {
		return new DragonRush();
	}

}

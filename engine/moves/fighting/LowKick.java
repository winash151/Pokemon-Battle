package engine.moves.fighting;

import engine.InBattlePokemon;
import engine.moves.Move;

public class LowKick extends FightingMove {

	/**
	 * id of 54 it is a special move the base power varies so... the accuracy is
	 * 100 percent the pp is 10
	 */
	public LowKick() {
		super(67, Move.PHYSICAL, 80, 1.0, 20, "Low Kick");
		setDescription("A powerful low kick that makes the target fall over. The heavier the target, the greater the move's power.");
	}
	
	public int getBasePower(InBattlePokemon user, InBattlePokemon target) {
		if(target.getWeight()<21.9) {
			return 20;
		}
		if(target.getWeight()<55.1) {
			return 40;
		}
		if(target.getWeight()<110.2) {
			return 60;
		}
		if(target.getWeight()<220.4) {
			return 80;
		}
		if(target.getWeight()<440.9) {
			return 100;
		}
		return 120;
	}

	@Override
	public Move newInstance() {
		return new LowKick();
	}
}

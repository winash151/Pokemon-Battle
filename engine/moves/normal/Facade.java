package engine.moves.normal;

import engine.Abilities;
import engine.InBattlePokemon;
import engine.moves.Move;

public class Facade extends NormalMove {

	/**
	 * id 411
	 * special move
	 * base power 120
	 * base accuracy 80
	 * pp 5
	 */
	public Facade() {
		super(263, Move.PHYSICAL, 70, 100, 20, "Facade");
		setDescription("An attack move that doubles its power if the user is poisoned, burned, or has paralysis.");
	}
	
	public int getBasePower(InBattlePokemon user, InBattlePokemon target) {
		boolean isAfflicted = user.isPoisoned() || user.isBadlyPoisoned() || user.isParalyzed() || user.isBurned();
		
		if(isAfflicted) {
			if(user.getAbility().equals(Abilities.GUTS)){
				return 140;
			}
			return 280;
		}
		
		return 70;
	}

	@Override
	public Move newInstance() {
		return new Facade();
	}
}

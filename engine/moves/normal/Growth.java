package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Growth extends NormalMove {

	/**
	 * id 350
	 * status move
	 * pp 30
	 */
	public Growth() {
		super(74, Move.STATUS, 20, "Growth");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user's body grows all at once, raising the Attack and Sp. Atk stats.");
	}

	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		int attackIncrease = 1;
		int spAttackIncrease = 1;
		if(user.getBattlefield().isSunny()) {
			attackIncrease = 2;
			spAttackIncrease = 2;
		}
		
		boolean attackIncreased = user.increaseAttack(attackIncrease, true, user);
		boolean spAttackIncreased = user.increaseSpAttack(spAttackIncrease, true, user);
		
		if(attackIncreased || spAttackIncreased){
			user.getDisplay().animateStatIncrease(user);
		}
		
	}

	//can always hit
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}
	
	public Move newInstance() {
		return new Growth();
	}

}

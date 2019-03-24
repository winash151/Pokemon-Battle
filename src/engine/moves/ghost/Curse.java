package engine.moves.ghost;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Curse extends GhostMove {

	/**
	 * bulk up has an id of 71
	 * it is a status move
	 * the pp is 20
	 */
	public Curse() {
		super(174, Move.STATUS, 20, "Curse");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("A move that works differently for the Ghost type than for all other types.");
	}

	/**
	 * increases attack and defense by one stage
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		boolean attackIncreased = user.increaseAttack(1, true, user);
		boolean defenseIncreased = user.increaseDefense(1, true, user);
		if(attackIncreased || defenseIncreased){
			user.getDisplay().animateStatIncrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
		if(user.decreaseSpeed(1, true, user)){
			user.getDisplay().animateStatDecrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
		
	}

	/**
	 * This move can't miss
	 */
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new Curse();
	}
}

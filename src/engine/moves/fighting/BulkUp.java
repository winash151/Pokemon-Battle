package engine.moves.fighting;

import engine.InBattlePokemon;
import engine.moves.Move;

public class BulkUp extends FightingMove {

	/**
	 * bulk up has an id of 71
	 * it is a status move
	 * the pp is 20
	 */
	public BulkUp() {
		super(339, Move.STATUS, 20, "Bulk Up");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user tenses its muscles to bulk up its body, raising both its Attack and Defense stats.");
	}

	/**
	 * increases attack and defense by one stage
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		System.out.println(user.getName() + " became more bulky.");
		user.getDisplay().consolePrintln(user.getName() + " became more bulky.");
		boolean attackIncreased = user.increaseAttack(1, true, user);
		boolean defenseIncreased = user.increaseDefense(1, true, user);
		if(attackIncreased || defenseIncreased){
			user.getDisplay().animateStatIncrease(user);
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
		return new BulkUp();
	}
}
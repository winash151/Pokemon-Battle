package engine.moves.bug;

import engine.InBattlePokemon;
import engine.moves.Move;

public class QuiverDance extends BugMove {

	/**
	 * bulk up has an id of 71
	 * it is a status move
	 * the pp is 20
	 */
	public QuiverDance() {
		super(483, Move.STATUS, 20, "Quiver Dance");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user lightly performs a beautiful, mystic dance. This boosts the user's Sp. Atk, Sp. Def, and Speed stats.");
	}

	/**
	 * increases attack and defense by one stage
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		System.out.println(user.getName() + " became more bulky.");
		user.getDisplay().consolePrintln(user.getName() + " became more bulky.");
		boolean specialAttackIncreased = user.increaseSpAttack(1, true, user);
		boolean specialDefenseIncreased = user.increaseSpDefense(1, true, user);
		boolean speedIncreased = user.increaseSpeed(1, true, user);
		
		if(specialAttackIncreased || specialDefenseIncreased || speedIncreased){
			user.getDisplay().animateStatIncrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
		
	}
	
	@Override
	public Move newInstance() {
		return new QuiverDance();
	}
}
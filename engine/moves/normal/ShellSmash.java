package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class ShellSmash extends NormalMove {

	/**
	 * bulk up has an id of 71
	 * it is a status move
	 * the pp is 20
	 */
	public ShellSmash() {
		super(504, Move.STATUS, 15, "Shell Smash");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user breaks its shell, which lowers Defense and Sp. Def stats but sharply raises its Attack, Sp. Atk, and Speed stats.");
	}

	/**
	 * increases attack and defense by one stage
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		
		boolean defenseDecreased = user.decreaseDefense(1, true, user);
		boolean spDefenseDecreased = user.decreaseSpDefense(1, true, user);
		

		if(defenseDecreased || spDefenseDecreased){
			user.getDisplay().animateStatDecrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
		
		boolean attackIncreased = user.increaseAttack(2, true, user);
		boolean spAttackIncreased = user.increaseSpAttack(2, true, user);
		boolean speedIncreased = user.increaseSpeed(2, true, user);
		
		if(attackIncreased || spAttackIncreased || speedIncreased){
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
		return new ShellSmash();
	}
}

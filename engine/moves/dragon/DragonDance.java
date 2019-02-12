package engine.moves.dragon;

import engine.InBattlePokemon;
import engine.moves.Move;

public class DragonDance extends DragonMove {

	/**
	 * bulk up has an id of 353
	 * it is a status move
	 * the pp is 20
	 */
	public DragonDance() {
		super(349, Move.STATUS, 20, "Dragon Dance");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user vigorously performs a mystic, powerful dance that boosts its Attack and Speed stats.");
	}

	/**
	 * increases attack and defense by one stage
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		boolean increaseAttack = user.increaseAttack(1, true, user);
		boolean increaseSpeed = user.increaseSpeed(1, true, user);
		if(increaseAttack || increaseSpeed){
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
		return new DragonDance();
	}
}

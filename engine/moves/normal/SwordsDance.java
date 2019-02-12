package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class SwordsDance extends NormalMove {

	/**
	 * id 350
	 * status move
	 * pp 30
	 */
	public SwordsDance() {
		super(14, Move.STATUS, 20, "Swords Dance");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("A frenetic dance to uplift the fighting spirit. This sharply raises the user's Attack stat.");
	}

	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(user.increaseAttack(2, true, user)){
			user.getDisplay().animateStatIncrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
		
	}

	@Override
	public Move newInstance() {
		return new SwordsDance();
	}

}

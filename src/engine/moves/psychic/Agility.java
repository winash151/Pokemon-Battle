package engine.moves.psychic;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Agility extends PsychicMove {

	/**
	 * id 350
	 * status move
	 * pp 30
	 */
	public Agility() {
		super(97, Move.STATUS, 30, "Agility");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user relaxes and lightens its body to move faster. This sharply raises the Speed stat.");
	}

	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(user.increaseSpeed(2, true, user)){
			user.getDisplay().animateStatIncrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
		
	}

	//can always hit
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new Agility();
	}

}

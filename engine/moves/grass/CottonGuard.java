package engine.moves.grass;

import engine.InBattlePokemon;
import engine.moves.Move;

public class CottonGuard extends GrassMove {

	/**
	 * id 350
	 * status move
	 * pp 30
	 */
	public CottonGuard() {
		super(538, Move.STATUS, 10, "Cotton Guard");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user protects itself by wrapping its body in soft cotton, which drastically raises the user's Defense stat.");
	}

	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(user.increaseDefense(3, true, user)){
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
		return new CottonGuard();
	}

}

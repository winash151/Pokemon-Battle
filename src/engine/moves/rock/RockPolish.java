package engine.moves.rock;

import engine.InBattlePokemon;
import engine.moves.Move;

public class RockPolish extends RockMove {

	/**
	 * id 350
	 * status move
	 * pp 30
	 */
	public RockPolish() {
		super(397, Move.STATUS, 20, "Rock Polish");
		setNeedsTarget(false);
		setDescription("The user polishes its body to reduce drag. This can sharply raise the Speed stat.");
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
		return new RockPolish();
	}

}
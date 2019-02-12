package engine.moves.bug;

import engine.InBattlePokemon;
import engine.moves.Move;

public class StringShot extends BugMove {

	/**
	 * id 299
	 * status
	 * base accuracy 100
	 * pp 20
	 */
	public StringShot() {
		super(81, Move.STATUS, .95, 40, "String Shot");
		setDescription("The opposing Pokémon are bound with silk blown from the user's mouth that harshly lowers the Speed stat.");
	}

	/**
	 * decreases target's accuracy
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(target.decreaseSpeed(2, true, user)){
			user.getDisplay().animateStatDecrease(target);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
	}

	@Override
	public Move newInstance() {
		return new StringShot();
	}
}

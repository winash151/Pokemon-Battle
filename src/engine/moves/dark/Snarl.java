package engine.moves.dark;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Snarl extends DarkMove {

	/**
	 * id 365
	 * special
	 * base power 90
	 * base accuracy 100 percent
	 * pp 10
	 */
	public Snarl() {
		super(555, Move.SPECIAL, 55, .95, 15, "Snarl");
		setDescription("The user yells as if it's ranting about something, which lowers the Sp. Atk stat of opposing Pokémon.");
	}

	/**
	 * side status decreases targets defense
	 * @param target
	 */
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		if (willSideStatusOccur(user, target)) {
			if(target.decreaseSpAttack(1, false, user)){
				user.getDisplay().animateStatDecrease(target);
				while(user.getDisplay().isAnimatingStat()){
					System.out.print("");
				}
			}
			
		}
	}

	/**
	 * Uses randomness to determine whether a status effect will occur
	 * 10 percent of the time
	 * @return
	 */
	public boolean willSideStatusOccur(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new Snarl();
	}

}
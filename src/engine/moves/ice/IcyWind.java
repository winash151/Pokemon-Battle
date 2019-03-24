package engine.moves.ice;

import engine.InBattlePokemon;
import engine.moves.Move;

public class IcyWind extends IceMove {

	/**
	 * id 365
	 * special
	 * base power 90
	 * base accuracy 100 percent
	 * pp 10
	 */
	public IcyWind() {
		super(196, Move.SPECIAL, 55, .95, 15, "Icy Wind");
		setDescription("The user attacks with a gust of chilled air. This also lowers the opposing Pokémon's Speed stats.");
	}

	/**
	 * side status decreases targets defense
	 * @param target
	 */
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		if (willSideStatusOccur(user, target)) {
			if(target.decreaseSpeed(1, false, user)){
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
		return new IcyWind();
	}

}
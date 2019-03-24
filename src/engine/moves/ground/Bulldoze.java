package engine.moves.ground;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Bulldoze extends GroundMove {

	/**
	 * id 365
	 * special
	 * base power 90
	 * base accuracy 100 percent
	 * pp 10
	 */
	public Bulldoze() {
		super(523, Move.PHYSICAL, 60, 1.0, 20, "Bulldoze");
		setDescription("The user strikes everything around it by stomping down on the ground. This lowers the Speed stat of those hit.");
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
		return new Bulldoze();
	}

}
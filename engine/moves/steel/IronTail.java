package engine.moves.steel;

import engine.InBattlePokemon;
import engine.moves.Move;

public class IronTail extends SteelMove {

	/**
	 * id 397
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public IronTail() {
		super(231, Move.PHYSICAL, 100, 0.75, 15, "Iron Tail");
		setDescription("The target is slammed with a steel-hard tail. This may also lower the target's Defense stat.");
	}

	/**
	 * side status decreases targets defense
	 * @param target
	 */
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		if (willSideStatusOccur(user, target)) {
			if(target.decreaseDefense(1, false, user)){
				target.getDisplay().animateStatDecrease(target);
				while(user.getDisplay().isAnimatingStat()){
					System.out.print("");
				}
			}
			
		}
	}
	

	/**
	 * Uses randomness to determine whether a status effect will occur
	 * 30 percent of the time
	 * @return
	 */
	public boolean willSideStatusOccur(InBattlePokemon user, InBattlePokemon target) {
		if (user.getRandomGen().next() < 0.30)
			return true;
		return false;
	}

	@Override
	public Move newInstance() {
		return new IronTail();
	}
}

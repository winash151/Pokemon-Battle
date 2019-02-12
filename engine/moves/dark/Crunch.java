package engine.moves.dark;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Crunch extends DarkMove {

	/**
	 * id 21
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public Crunch() {
		super(242, Move.PHYSICAL, 80, 1.0, 15, "Crunch");
		setStatusProbability(0.2);
		setDescription("The user crunches up the target with sharp fangs. This may also lower the target's Defense stat.");
		setBite(true);
	}

	/**
	 * side status decreases targets defense
	 * @param target
	 */
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		if (willSideStatusOccur(user, target)) {
			if(target.decreaseDefense(1, false, user)) {
				user.getDisplay().animateStatDecrease(target);
				while(user.getDisplay().isAnimatingStat()){
					System.out.print("");
				}
			}
		}
		
	}

	@Override
	public Move newInstance() {
		return new Crunch();
	}

}

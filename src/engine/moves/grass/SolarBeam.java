package engine.moves.grass;

import engine.InBattlePokemon;
import engine.moves.Move;

public class SolarBeam extends GrassMove{
	//turn of two turn attack
	private int turn = 1;

	/**
	 * id 180
	 * special move
	 * base power 120
	 * base accuracy 100
	 * pp 10
	 */
	public SolarBeam() {
		super(76, Move.SPECIAL, 120, 1.0, 10, "Solar Beam");
		setDescription("A two-turn attack. The user gathers light, then blasts a bundled beam on the next turn.");
	}

	public boolean use(InBattlePokemon user, InBattlePokemon target) {
		boolean didWork;
		if (turn == 1) {//if first turn
			user.getDisplay().consolePrintln(user.getName() + " absorbed sunlight.");
			if(user.getBattlefield().isSunny()){
				setBasePower(120);
				didWork = super.use(user, target);
			} else{
				turn++;
				user.setLastMove(user.getIndexOfNextMove());
				didWork = true;
			}
		} else {//if second turn use move
			if(user.getBattlefield().isHailing() || user.getBattlefield().isRaining() || user.getBattlefield().isSandstorming()){
				setBasePower(60);
			}
			else{
				setBasePower(120);
			}
			didWork = super.use(user, target);
		}
		
		return didWork;
	}

	public void cleanUp(InBattlePokemon user, InBattlePokemon target) {
		turn = 1;
		super.cleanUp(user, target);
	}

	@Override
	public Move newInstance() {
		return new SolarBeam();
	}
}

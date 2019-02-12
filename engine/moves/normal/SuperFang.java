package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class SuperFang extends NormalMove {

	/**
	 * id 315
	 * physical move
	 * base power 50
	 * base accuracy of 100
	 * pp 35
	 */
	public SuperFang() {
		super(162, Move.PHYSICAL, 1, .9, 10, "Super Fang");
		setDescription("The user chomps hard on the target with its sharp front fangs. This cuts the target's HP in half.");
	}
	
	public int calculateDamage(InBattlePokemon user, InBattlePokemon target) {
		return (int) Math.ceil(target.getCurrentHP()/2.0);
	}

	@Override
	public Move newInstance() {
		return new SuperFang();
	}

}
package engine.moves.notype;

import engine.InBattlePokemon;
import engine.moves.Move;

public class BeingConfused extends NoTypeMove {

	public BeingConfused() {
		super(-1, Move.PHYSICAL, 40, 1, 50000, "Being Confused");
	}

	public boolean use(InBattlePokemon user, InBattlePokemon target) {
		System.out.println(user.getName() + " hurt itself in confusion.");
		doDamage(user, target, this.calculateDamage(user, user));
		return true;
	}
	
	public double getStab(InBattlePokemon user, InBattlePokemon target) {
		return 1;
	}
	
	public double getEffectiveness(InBattlePokemon user, InBattlePokemon target) {
		return 1;
	}
	
	public double applyScreens(InBattlePokemon user, InBattlePokemon target, double damage) {
		return damage;
	}
	
	public double applyAbility(InBattlePokemon user, InBattlePokemon target, double damage) {
		return damage;
	}

	@Override
	public Move newInstance() {
		return new BeingConfused();
	}

}

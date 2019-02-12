package engine.moves.fire;

import engine.InBattlePokemon;
import engine.Statuses;
import engine.moves.Move;

public class FireFang extends FireMove {

	/**
	 * id 109
	 * physical
	 * 65 base power
	 * 95 base accuracy
	 * burn 10 percent
	 */
	public FireFang() {
		super(424, Move.PHYSICAL, 65, .95, 15, "Fire Fang", Statuses.BURN, 0.1);
		setDescription("The user bites with flame-cloaked fangs. This may also make the target flinch or leave it with a burn.");
		setBite(true);
	}
	
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		double random = user.getRandomGen().next();
		if(random<0.1){
			target.afflictStatus(user, Statuses.BURN);
		} else if (random<0.2) {
			target.afflictStatus(user, Statuses.FLINCHED);
		}
	}

	@Override
	public Move newInstance() {
		return new FireFang();
	}
}

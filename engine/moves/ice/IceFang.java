package engine.moves.ice;

import engine.InBattlePokemon;
import engine.Statuses;
import engine.moves.Move;

public class IceFang extends IceMove {

	/**
	 * id 109
	 * physical
	 * 65 base power
	 * 95 base accuracy
	 * burn 10 percent
	 */
	public IceFang() {
		super(423, Move.PHYSICAL, 65, .95, 15, "Ice Fang", Statuses.FROZEN, 0.1);
		setDescription("The user bites with cold-infused fangs. This may also make the target flinch or leave it frozen.");
		setBite(true);
	}
	
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		double random = user.getRandomGen().next();
		if(random<0.1){
			target.afflictStatus(user, Statuses.FROZEN);
		} else if (random<0.2) {
			target.afflictStatus(user, Statuses.FLINCHED);
		}
	}

	@Override
	public Move newInstance() {
		return new IceFang();
	}
}

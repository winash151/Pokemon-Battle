package engine.moves.electric;

import engine.InBattlePokemon;
import engine.Statuses;
import engine.moves.Move;

public class ThunderFang extends ElectricMove {

	/**
	 * id 60
	 * special move
	 * 65 base power
	 * accuracy 95
	 * burn 10 percent
	 */
	public ThunderFang() {
		super(422, Move.PHYSICAL, 65, .95, 15, "Thunder Fang", Statuses.PARALYSIS,
				0.1);
		setDescription("The user bites with electrified fangs. This may also make the target flinch or leave it with paralysis.");
		setBite(true);
	}
	
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		double random = user.getRandomGen().next();
		if(random<0.1){
			target.afflictStatus(user, Statuses.PARALYSIS);
		} else if (random<0.2) {
			target.afflictStatus(user, Statuses.FLINCHED);
		}
	}

	@Override
	public Move newInstance() {
		return new ThunderFang();
	}

}

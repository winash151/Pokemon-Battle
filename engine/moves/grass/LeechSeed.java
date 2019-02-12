package engine.moves.grass;

import engine.InBattlePokemon;
import engine.Statuses;
import engine.moves.Move;

public class LeechSeed extends GrassMove {

	/**
	 * id 350
	 * status move
	 * pp 30
	 */
	public LeechSeed() {
		super(73, Move.STATUS, 20, "Leech Seed");
		setDescription("A seed is planted on the target. It steals some HP from the target every turn.");
	}

	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		target.afflictStatus(user, Statuses.SEEDED);
	}

	@Override
	public Move newInstance() {
		return new LeechSeed();
	}

}

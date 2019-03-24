package engine.moves.ghost;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Hex extends GhostMove {

	/**
	 * id of 147
	 * it is a physical move
	 * the base power varies so...
	 * the accuracy is 100 percent
	 * the pp is 10
	 */
	public Hex() {
		super(506, Move.SPECIAL, 65, 1.0, 10, "Hex");
		setDescription("This relentless attack does massive damage to a target affected by status conditions.");
	}
	
	
	public void preparation(InBattlePokemon user, InBattlePokemon target) {
		if(target.hasMajorStatusAilment())
			setBasePower(130);
		else
			setBasePower(65);
	}
	
	@Override
	public Move newInstance() {
		return new Hex();
	}

}

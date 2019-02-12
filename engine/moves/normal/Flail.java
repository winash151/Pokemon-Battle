package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Flail extends NormalMove {

	
	/**
	 * id of 246
	 * it is a physical move
	 * the base power varies so...
	 * the accuracy is 100 percent
	 * the pp is 10
	 */
	public Flail() {
		super(175, Move.PHYSICAL, 1, 1.0, 15, "Flail");
		setDescription("Inflicts damage on the target. The lower the user's HP, the greater the damage it inflicts.");
	}
	
	
	public void preparation(InBattlePokemon user, InBattlePokemon target) {
		int p = user.getCurrentHP()*48/user.getTotalHP();
		if(p>32)
			setBasePower(20);
		else if(p>16)
			setBasePower(40);
		else if(p>9)
			setBasePower(80);
		else if(p>4)
			setBasePower(100);
		else if(p>1)
			setBasePower(150);
		else
			setBasePower(200);
	}
	
	@Override
	public Move newInstance() {
		return new Flail();
	}

}

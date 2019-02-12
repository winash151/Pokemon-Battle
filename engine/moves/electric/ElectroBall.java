package engine.moves.electric;

import engine.InBattlePokemon;
import engine.moves.Move;

public class ElectroBall extends ElectricMove {

	/**
	 * id of 54 it is a special move the base power varies so... the accuracy is
	 * 100 percent the pp is 10
	 */
	public ElectroBall() {
		super(486, Move.SPECIAL, 1, 1.0, 10, "Electro Ball");
		setDescription("The user hurls an electric orb at the target."
				+ " The faster the user is than the target, the greater the move's power.");
	}
	
	public int getBasePower(InBattlePokemon user, InBattlePokemon target) {
		// the ratio of the target speed to the users speed
		double speedRatio = 1.0 * target.getSpeed() / user.getSpeed();

		System.out.println("The ratio for " + user.getName()
				+ "'s Electro Ball is " + speedRatio + ".");
		
		int basePower;

		if (speedRatio > 0.5) {
			basePower = 60;
			System.out.println("The base power for " + user.getName()
					+ "'s Electro Ball is " + 60 + ".");
		} else if (speedRatio > 1.0/3) {
			basePower = 80;
			System.out.println("The base power for " + user.getName()
					+ "'s Electro Ball is " + 80 + ".");
		} else if (speedRatio > 0.25) {
			basePower = 120;
			System.out.println("The base power for " + user.getName()
					+ "'s Electro Ball is " + 120 + ".");
		} else {
			basePower = 150;
			System.out.println("The base power for " + user.getName()
					+ "'s Electro Ball is " + 150 + ".");
		}
		
		return basePower;
	}

	@Override
	public Move newInstance() {
		return new ElectroBall();
	}
}

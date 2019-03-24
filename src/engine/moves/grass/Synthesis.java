package engine.moves.grass;

import engine.InBattlePokemon;
import engine.WeatherConditions;
import engine.moves.Move;

public class Synthesis extends GrassMove {

	/**
	 * id 183
	 * status move
	 * pp 5
	 */
	public Synthesis() {
		super(235, Move.STATUS, 5, "Synthesis");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("Restores the user's HP. The HP amount regained depends on the weather.");
	}

	/**
	 * can always hit
	 */
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	/**
	 * heal back hp
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {

		System.out.println(user.getCurrentHP() + "synth");
		if(user.getCurrentHP()==user.getTotalHP()){
			
			user.getDisplay().consolePrintln(user.getName() + "'s HP is already full.");
		}
		else{
			//if sunny heals 2/3
			if (user.getBattlefield().getWeather().equals(WeatherConditions.SUN)) {
				System.out.println("sunny so 2/3 back");
				user.increaseHP((int) (user.getTotalHP() * 2 / 3.0));
				//other nonclear restores 1/4
			} else if (!user.getBattlefield().getWeather().equals(WeatherConditions.CLEAR)) {
				System.out.println("unclear so quarter back");
				user.increaseHP(user.getTotalHP() / 4);
			} else{//clear restores a half
				System.out.println("clear so half back");
				user.increaseHP(user.getTotalHP() / 2);
			}
			user.getDisplay().consolePrintln(user.getName() + " regained health.");
		}
		System.out.println(user.getName() + "'s current health is "
				+ user.getCurrentHP() + "/" + user.getTotalHP() + ".");
	}

	@Override
	public Move newInstance() {
		return new Synthesis();
	}
}

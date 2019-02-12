package engine.moves.electric;
import engine.InBattlePokemon;
import engine.Statuses;
import engine.WeatherConditions;
import engine.moves.Move;

public class Thunder extends ElectricMove {

	/**
	 * id is 59
	 * it is a special move
	 * base power of 120
	 * normal accuracy of 70 percent
	 * pp of 10
	 * can cause paralysis 30 percent of the time
	 */
	public Thunder(){
		super(87, Move.SPECIAL, 110, 0.7,
				10, "Thunder", Statuses.PARALYSIS, 0.3);
		setDescription("A wicked thunderbolt is dropped on the target to inflict damage. This may also leave the target with paralysis.");
	}
	
	/**
	 * Thunder never misses in the rain
	 * in sunlight its accuracy is 50 percent
	 */
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		if(user.getBattlefield().getWeather().equals(WeatherConditions.RAIN)){
			System.out.println("it is raining thusly thunder cant miss");
			return true;
		}
		
		if(user.getBattlefield().getWeather().equals(WeatherConditions.SUN)){
			System.out.println("it is sunny so the accuracy is 50 percent for thunder");
			setAccuracy(.50);
		}
		else{
			setAccuracy(.70);
		}
			
		
		return super.willHit(user, target);
	}

	@Override
	public Move newInstance() {
		return new Thunder();
	}
}
package engine.moves.flying;
import engine.InBattlePokemon;
import engine.Statuses;
import engine.WeatherConditions;
import engine.moves.Move;

public class Hurricane extends FlyingMove {

	/**
	 * id is 59
	 * it is a special move
	 * base power of 120
	 * normal accuracy of 70 percent
	 * pp of 10
	 * can cause paralysis 30 percent of the time
	 */
	public Hurricane(){
		super(542, Move.SPECIAL, 110, 0.7,
				10, "Hurricane", Statuses.CONFUSED, 0.3);
		setDescription("The user attacks by wrapping its opponent in a fierce wind that flies up into the sky. This may also confuse the target.");
	}
	
	/**
	 * Thunder never misses in the rain
	 * in sunlight its accuracy is 50 percent
	 */
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		if(user.getBattlefield().getWeather().equals(WeatherConditions.RAIN)){
			System.out.println("it is raining thusly hurricane cant miss");
			return true;
		}
		
		if(user.getBattlefield().getWeather().equals(WeatherConditions.SUN)){
			System.out.println("it is sunny so the accuracy is 50 percent for hurricae");
			setAccuracy(.50);
		}
		else{
			setAccuracy(.70);
		}
			
		
		return super.willHit(user, target);
	}

	@Override
	public Move newInstance() {
		return new Hurricane();
	}
}

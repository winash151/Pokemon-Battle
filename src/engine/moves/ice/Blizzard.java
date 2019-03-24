package engine.moves.ice;
import engine.InBattlePokemon;
import engine.Statuses;
import engine.WeatherConditions;
import engine.moves.Move;

public class Blizzard extends IceMove {

	/**
	 * id is 59
	 * it is a special move
	 * base power of 120
	 * normal accuracy of 70 percent
	 * pp of 10
	 * can cause paralysis 30 percent of the time
	 */
	public Blizzard(){
		super(59, Move.SPECIAL, 110, 0.7,
				5, "Blizzard", Statuses.FROZEN, 0.1);
		setDescription("A howling blizzard is summoned to strike opposing Pokémon. This may also leave the opposing Pokémon frozen.");
	}
	
	/**
	 * Thunder never misses in the rain
	 * in sunlight its accuracy is 50 percent
	 */
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		if(user.getBattlefield().getWeather().equals(WeatherConditions.HAIL)){
			return true;
		}
		
		return super.willHit(user, target);
	}

	@Override
	public Move newInstance() {
		return new Blizzard();
	}
}
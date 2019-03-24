package engine.moves.fire;

import engine.Abilities;
import engine.InBattlePokemon;
import engine.Status;
import engine.Types;
import engine.WeatherConditions;
import engine.moves.Move;

public abstract class FireMove extends Move {

	public FireMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		super(idNum, Types.FIRE, kind, basePower, accuracy, totalPP, name,
				status, statusProbability);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param status
	 * @param statusProbability
	 */
	public FireMove(int idNum, String kind, double accuracy, int totalPP,
			String name, Status status, double statusProbability) {
		super(idNum, Types.FIRE, kind, accuracy, totalPP, name, status,
				statusProbability);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 */
	public FireMove(int idNum, String kind, double accuracy, int totalPP,
			String name) {
		super(idNum, Types.FIRE, kind, accuracy, totalPP, name);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param speedPriority
	 */
	public FireMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority) {
		super(idNum, Types.FIRE, kind, basePower, accuracy, totalPP, name,
				speedPriority);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param status
	 * @param statusProbability
	 * @param speedPriority
	 */
	public FireMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority) {
		super(idNum, Types.FIRE, kind, basePower, accuracy, totalPP, name,
				status, statusProbability, speedPriority);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 */
	public FireMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name) {
		super(idNum, Types.FIRE, kind, basePower, accuracy, totalPP, name);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param totalPP
	 * @param name
	 */
	public FireMove(int idNum, String kind, int totalPP, String name) {
		super(idNum, Types.FIRE, kind, totalPP, name);
	}

	public void damagingMoveDoesOtherStuff(InBattlePokemon user,
			InBattlePokemon target) {
		if(target.isFrozen())
			target.unFreeze();
	}

	public int calculateDamage(InBattlePokemon user, InBattlePokemon target) {
		int damage = super.calculateDamage(user, target);
		if (user.getBattlefield().getWeather().equals(WeatherConditions.SUN)) {
			return (int) (damage * 1.5);//sun boosts 50 percent
		}
		if (user.getBattlefield().getWeather().equals(WeatherConditions.RAIN)) {
			return (int) (damage / 2.0);//rain halves
		}
		
		if(user.isFlashFireActivated())
			damage = damage*3/2;
		
		if(user.getAbility().equals(Abilities.BLAZE)){
			double hpPercent = 1.0*user.getCurrentHP()/user.getTotalHP();
			if(hpPercent<=1.0/3){
				damage = damage*3/2;
			}
		}
		
		if(target.getAbility().equals(Abilities.THICK_FAT)){
			damage/=2;
		}
		
		if(target.getAbility().equals(Abilities.HEATPROOF)){
			damage/=2;
		}
		
		if(target.getAbility().equals(Abilities.DRY_SKIN)){
			damage*=1.25;
		}
		
		return damage;
	}
	
	public boolean canHitIfWillHit(InBattlePokemon user, InBattlePokemon target) {
		if(target.getAbility().equals(Abilities.FLASH_FIRE)){
			target.activateFlashFire();
			return false;
		}
		return super.canHitIfWillHit(user, target);
	}
}

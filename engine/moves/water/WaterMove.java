package engine.moves.water;

import engine.Abilities;
import engine.InBattlePokemon;
import engine.Status;
import engine.Types;
import engine.WeatherConditions;
import engine.moves.Move;

public abstract class WaterMove extends Move {

	public WaterMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		super(idNum, Types.WATER, kind, basePower, accuracy, totalPP, name,
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
	public WaterMove(int idNum, String kind, double accuracy, int totalPP,
			String name, Status status, double statusProbability) {
		super(idNum, Types.WATER, kind, accuracy, totalPP, name, status,
				statusProbability);
		//
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
	public WaterMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority) {
		super(idNum, Types.WATER, kind, basePower, accuracy, totalPP, name,
				speedPriority);
		//
	}

	public WaterMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority, int criticalHitBoost) {
		super(idNum, Types.WATER, kind, basePower, accuracy, totalPP, name,
				speedPriority, criticalHitBoost);
		//
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
	public WaterMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority) {
		super(idNum, Types.WATER, kind, basePower, accuracy, totalPP, name,
				status, statusProbability, speedPriority);
		//
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
	public WaterMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name) {
		super(idNum, Types.WATER, kind, basePower, accuracy, totalPP, name);
		//
	}

	public WaterMove(int idNum, String kind, int totalPP, String name) {
		super(idNum, Types.WATER, kind, 0, 1.0, totalPP, name, null, 0, 0);
	}

	/**
	 * affected by rain
	 */
	public int calculateDamage(InBattlePokemon user, InBattlePokemon target) {
		int damage = super.calculateDamage(user, target);
		if (user.getBattlefield().equals(WeatherConditions.SUN)) {
			return (int) (damage / 2.0);//sun halves damage
		}
		if (user.getBattlefield().equals(WeatherConditions.RAIN)) {
			return (int) (damage * 1.5);//rain *1.5
		}
		if(user.getAbility().equals(Abilities.TORRENT)){
			double hpPercent = 1.0*user.getCurrentHP()/user.getTotalHP();
			if(hpPercent<=1.0/3){
				damage = damage*3/2;
			}
		}
		return damage;
	}
	
	public boolean canHitIfWillHit(InBattlePokemon user, InBattlePokemon target) {
		if(target.getAbility().equals(Abilities.WATER_ABSORB)){
			target.increaseHP(target.getTotalHP()/4);
			return false;
		}
		
		if(target.getAbility().equals(Abilities.DRY_SKIN)){
			target.increaseHP(target.getTotalHP()/4);
			return false;
		}
		
		return super.canHitIfWillHit(user, target);
	}
}

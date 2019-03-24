package engine.moves;
import java.util.TreeMap;

/**
 * Move indeces from http://bulbapedia.bulbagarden.net/wiki/List_of_moves
 * @author Ashwin
 *
 */
public class Moves {
	//public static final Move[] moves = new Move[500];
	public static TreeMap<Integer, Move> moves = new TreeMap<Integer, Move>();
	
	public static void clearMoves(){
		moves = null;
	}
	
	public static void add(Move m){
		try{//for when a move is created after moves has been cleared
			moves.put(m.getIdNum(), m);
		} catch(Exception e){}
	}
	
	//static {
		/*moves.put(new ElectroBall().getIdNum(), new ElectroBall());
		moves.put(new Thunder().getIdNum(), new Thunder());
		moves.put(new BulkUp().getIdNum(), new BulkUp());
		moves.put(new Detect().getIdNum(), new Detect());
		moves.put(new FireFang().getIdNum(), new FireFang());
		moves.put(new Flamethrower().getIdNum(), new Flamethrower());
		moves.put(new FlareBlitz().getIdNum(), new FlareBlitz());
		moves.put(new Aeroblast().getIdNum(), new Aeroblast());
		moves.put(new AirSlash().getIdNum(), new AirSlash());
		moves.put(new SkyAttack().getIdNum(), new SkyAttack());
		moves.put(new ShadowClaw().getIdNum(), new ShadowClaw());
		moves.put(new MagicalLeaf().getIdNum(), new MagicalLeaf());
		moves.put(new PowerWhip().getIdNum(), new PowerWhip());
		moves.put(new Synthesis().getIdNum(), new Synthesis());
		moves.put(new Protect().getIdNum(), new Protect());
		moves.put(new QuickAttack().getIdNum(), new QuickAttack());
		moves.put(new SkullBash().getIdNum(), new SkullBash());
		moves.put(new Slash().getIdNum(), new Slash());
		moves.put(new SmokeScreen().getIdNum(), new SmokeScreen());
		moves.put(new SludgeBomb().getIdNum(), new SludgeBomb());
		moves.put(new Agility().getIdNum(), new Agility());
		moves.put(new CalmMind().getIdNum(), new CalmMind());
		moves.put(new LightScreen().getIdNum(), new LightScreen());
		moves.put(new AncientPower().getIdNum(), new AncientPower());
		moves.put(new IronTail().getIdNum(), new IronTail());
		moves.put(new HydroPump().getIdNum(), new HydroPump());
		moves.put(new WaterPulse().getIdNum(), new WaterPulse());
		moves.put(new AuraSphere().getIdNum(), new AuraSphere());
		moves.put(new Psychic().getIdNum(), new Psychic());
		moves.put(new Psystrike().getIdNum(), new Psystrike());
		moves.put(new BlastBurn().getIdNum(), new BlastBurn());
		moves.put(new SunnyDay().getIdNum(), new SunnyDay());
		moves.put(new FrenzyPlant().getIdNum(), new FrenzyPlant());
		moves.put(new SolarBeam().getIdNum(), new SolarBeam());
		moves.put(new HyperBeam().getIdNum(), new HyperBeam());
		moves.put(new HydroCannon().getIdNum(), new HydroCannon());
		moves.put(new RainDance().getIdNum(), new RainDance());
		moves.put(new IronDefense().getIdNum(), new IronDefense());
		moves.put(new Toxic().getIdNum(), new Toxic());
		moves.put(new Splash().getIdNum(), new Splash());
		moves.put(new Tackle().getIdNum(), new Tackle());
		moves.put(new Flail().getIdNum(), new Flail());
		moves.put(new Bounce().getIdNum(), new Bounce());
		moves.put(new PayDay().getIdNum(), new PayDay());
		moves.put(new NightSlash().getIdNum(), new NightSlash());
		moves.put(new Taunt().getIdNum(), new Taunt());
		moves.put(new ExtremeSpeed().getIdNum(), new ExtremeSpeed());
		moves.put(new ThunderFang().getIdNum(), new ThunderFang());
		moves.put(new Crunch().getIdNum(), new Crunch());
		moves.put(new Reflect().getIdNum(), new Reflect());
		moves.put(new Hex().getIdNum(), new Hex());
		moves.put(new DarkPulse().getIdNum(), new DarkPulse());
		moves.put(new ShadowBall().getIdNum(), new ShadowBall());
		moves.put(new SuckerPunch().getIdNum(), new SuckerPunch());
		moves.put(new NastyPlot().getIdNum(), new NastyPlot());
		moves.put(new DarkVoid().getIdNum(), new DarkVoid());
		moves.put(new DreamEater().getIdNum(), new DreamEater());
		moves.put(new DragonRush().getIdNum(), new DragonRush());
		moves.put(new DragonClaw().getIdNum(), new DragonClaw());
		moves.put(new Earthquake().getIdNum(), new Earthquake());
		moves.put(new CloseCombat().getIdNum(), new CloseCombat());
		moves.put(new HammerArm().getIdNum(), new HammerArm());
		moves.put(new MuddyWater().getIdNum(), new MuddyWater());
		moves.put(new DragonPulse().getIdNum(), new DragonPulse());
		moves.put(new Outrage().getIdNum(), new Outrage());
		moves.put(new IceBeam().getIdNum(), new IceBeam());
		moves.put(new SwordsDance().getIdNum(), new SwordsDance());
		moves.put(new Recover().getIdNum(), new Recover());
		moves.put(new CottonGuard().getIdNum(), new CottonGuard());*/
		
		/*moves[new DragonClaw()                   .getIdNum()] = new DragonClaw();
		moves[new ElectroBall()                   .getIdNum()] = new ElectroBall();
		moves[new Thunder()                   .getIdNum()] = new Thunder();
		moves[new BulkUp()                   .getIdNum()] = new BulkUp();
		moves[new Detect()                   .getIdNum()] = new Detect();
		moves[new FireFang()                   .getIdNum()] = new FireFang();
		moves[new Flamethrower()                   .getIdNum()] = new Flamethrower();
		moves[new FlareBlitz()                   .getIdNum()] = new FlareBlitz();
		moves[new Aeroblast()                   .getIdNum()] = new Aeroblast();
		moves[new AirSlash()                   .getIdNum()] = new AirSlash();
		moves[new SkyAttack()                   .getIdNum()] = new SkyAttack();
		moves[new ShadowClaw()                   .getIdNum()] = new ShadowClaw();
		moves[new MagicalLeaf()                   .getIdNum()] = new MagicalLeaf();
		moves[new PowerWhip()                   .getIdNum()] = new PowerWhip();
		moves[new Synthesis()                   .getIdNum()] = new Synthesis();
		moves[new Protect()                   .getIdNum()] = new Protect();
		moves[new QuickAttack()                   .getIdNum()] = new QuickAttack();
		moves[new SkullBash()                   .getIdNum()] = new SkullBash();
		moves[new Slash()                   .getIdNum()] = new Slash();
		moves[new SmokeScreen()                   .getIdNum()] = new SmokeScreen();
		moves[new SludgeBomb()                   .getIdNum()] = new SludgeBomb();
		moves[new Agility()                   .getIdNum()] = new Agility();
		moves[new CalmMind()                   .getIdNum()] = new CalmMind();
		moves[new LightScreen()                   .getIdNum()] = new LightScreen();
		moves[new AncientPower()                   .getIdNum()] = new AncientPower();
		moves[new IronTail()                   .getIdNum()] = new IronTail();
		moves[new HydroPump()                   .getIdNum()] = new HydroPump();
		moves[new WaterPulse()                   .getIdNum()] = new WaterPulse();*/
	//}
	
	public static Move get(int idNum){
		return moves.get(idNum).newInstance();
	}
}

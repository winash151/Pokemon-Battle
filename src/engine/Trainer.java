package engine;


import graphics.Display;

import java.util.ArrayList;

public class Trainer {
	private InBattlePokemon[] team;
	private BattleSide myBattleSide;
	private String name;
	private boolean isHome;
	private Display display;
	
	public static final int FIRST_POKEMON_CHOSEN = 0;
	public static final int SECOND_POKEMON_CHOSEN = 1;
	public static final int THIRD_POKEMON_CHOSEN = 2;
	public static final int FOURTH_POKEMON_CHOSEN = 3;
	public static final int FIFTH_POKEMON_CHOSEN = 4;
	public static final int SIXTH_POKEMON_CHOSEN = 5;

	public Trainer(String name, PartyPokemon[] team) {
		this(name, team, true);
	}
	
	public Trainer(String name, PartyPokemon[] team, boolean b) {
		this.name = name;
		
		this.team = new InBattlePokemon[team.length];
		
		for(int i = 0;i<team.length;i++){
			this.team[i] = new InBattlePokemon(team[i]);
			this.team[i].setBattleSide(myBattleSide);
		}
		
		String message = getName() + "'s team is ";
		for(PartyPokemon p: team){
			message+=p.getName() + ",";
		}
		
		isHome = b;
		
		if(isHome){
			this.team[0].initializeHomeImages();
		}
		else{
			this.team[0].initializeAwayImages();
		}
		
		System.out.println(message);
	}
	
	public Trainer(String name, ArrayList<PartyPokemon> team, boolean b) {
		this.name = name;
		
		this.team = new InBattlePokemon[team.size()];
		
		for(int i = 0;i<team.size();i++){
			this.team[i] = new InBattlePokemon(team.get(i));
			this.team[i].setBattleSide(myBattleSide);
		}
		
		String message = getName() + "'s team is ";
		for(PartyPokemon p: team){
			message+=p.getName() + ",";
		}
		
		isHome = b;
		
		if(isHome){
			this.team[0].initializeHomeImages();
		}
		else{
			this.team[0].initializeAwayImages();
		}
		
		System.out.println(message);
	}

	public String exportAsString(){
		String s = "";
		s += "Nickname:" + name;
		
		s+="newpkmn";
		
		for(PartyPokemon p: team){
			s+=p.exportAsString();
			s+="newpkmn";
		}
		
		s+="trainerfin";
		
		return s;
	}
	
	public static Trainer generateFromExportString(String str) {
		String s = str;
		s = s.substring(9);
		int newpkmnStrIndex = s.indexOf("newpkmn");
		String name = s.substring(0, newpkmnStrIndex);
		s = s.substring(newpkmnStrIndex+7);
		
		ArrayList<PartyPokemon> partyPokes = new ArrayList<PartyPokemon>(6);
		
		
		while(true){
			if(s.equals("trainerfin"))
				break;
			int newPkmnIndex = s.indexOf("newpkmn");
			PartyPokemon newPkmn = PartyPokemon.generateFromExportString(s.substring(0, newPkmnIndex));
			partyPokes.add(newPkmn);
			 s= s.substring(newPkmnIndex + 7);
		}
		
		int length = partyPokes.size();
		
		PartyPokemon[] array = new PartyPokemon[length];
		
		for(int  i =0;i<length;i++)
			array[i] = partyPokes.get(i);
		
		return new Trainer(name, array);
	}

	public BattleSide getMyBattleSide() {
		return myBattleSide;
	}

	public String getName() {
		return name;
	}

	public InBattlePokemon getInBattlePokemon() {
		return team[0];
	}

	public void setInBattlePokemon(InBattlePokemon inBattlePokemon) {
		team[0] = inBattlePokemon;
	}

	public InBattlePokemon[] getTeam() {
		return team;
	}

	public void setTeam(PartyPokemon[] team) {
		team = new InBattlePokemon[team.length];
		
		for(int i = 0;i<team.length;i++){
			this.team[i] = new InBattlePokemon(team[i]);
		}
		
		String message = getName() + " team is ";
		for(PartyPokemon p: team){
			message+=p.getName() + ",";
		}
		
		System.out.println(message);
	}

	public void setBattleSide(BattleSide battleSide) {
		myBattleSide = battleSide;
		for(int i = 0;i<team.length;i++){
			team[i].setBattleSide(myBattleSide);
		}
	}
	
	public void fixTeamAfterFaint(){
		ArrayList<InBattlePokemon> alive = new ArrayList<InBattlePokemon>(6);
		ArrayList<InBattlePokemon> fainted = new ArrayList<InBattlePokemon>(6);
		
		for(InBattlePokemon pok: team){
			if(pok.isFainted()){
				fainted.add(pok);
			}
			else{
				alive.add(pok);
			}
		}
		
		int i = 0;
		
		for(i = 0;i<alive.size();i++){
			team[i] = alive.get(i);
		}
		
		for(int j = 0;j<fainted.size();j++){
			team[i+j] = fainted.get(j);
		}
		
		String message = getName() + " team is ";
		for(PartyPokemon p: team){
			message+=p.getName() + ",";
		}
		
		System.out.println(message);
	}
	
	public void switchOutFor(int index){
		InBattlePokemon pok = team[index];
		InBattlePokemon prev = team[0];
		
		if(isHome){
			pok.initializeHomeImages();
		}
		else{
			pok.initializeAwayImages();
		}
		team[index] = team[0];
		team[0] = pok;
		prev.clearImages();

		display.resetHomeHP();
		display.resetAwayHP();
		
		System.out.println(pok.getName() + " switched in for " + prev.getName() + ".");
		
		prev.takeOutOfBattle();
		
		if(isHome()){
			if(index==0){
				display.consolePrintln(pok.getName() + ", I choose you!");
			} else{
				display.consolePrintln("That's enough " + prev.getName() + ". " + pok.getName() + ", I choose you!");
			}
			
		}else{
			display.consolePrintln(name + " sent out " + pok.getName() + ".");
		}
		
		String message = getName() + " team is ";
		for(PartyPokemon p: team){
			message+=p.getName() + ",";
		}
		
		System.out.println(message);
	}
	
	public boolean canStillBattle(){
		for(PartyPokemon p: team){
			if(!p.isFainted()){
				return true;
			}
		}
		System.out.println(getName() + " blacked out.");
		return false;
	}

	public boolean isHome() {
		return isHome;
	}

	public void setHome(boolean isHome) {
		this.isHome = isHome;
		team[0].clearImages();
		if(isHome){
			this.team[0].initializeHomeImages();
		}
		else{
			this.team[0].initializeAwayImages();
		}
	}

	public void setDisplay(Display display) {
		this.display = display;
		for(PartyPokemon p: team){
			p.setDisplay(display);
		}
	}
	
	//private RandomGen randomGen;

	public void setRandomGen(RandomGen randomGen) {
		//this.randomGen = randomGen;
		for(PartyPokemon p: team){
			p.setRandomGen(randomGen);
		}
	}

}

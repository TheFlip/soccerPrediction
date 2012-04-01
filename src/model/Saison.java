package model;

import java.util.ArrayList;

public class Saison {
	private final int TEAMCOUNT;
	private final String SAISON;
	
	private ArrayList<Team> teams = new ArrayList<Team>();
	private ArrayList<Spieltag> spieltage = new ArrayList<Spieltag>();
	
	private int spielTagCounter = 1;
	private Spieltag actSpieltag;
	
	public void addGame(Team h, Team a, int hg, int ag, float bwh, float bwd, float bwa){
		actSpieltag.addSpiel(new Spiel(h, a, hg, ag, actSpieltag, bwh, bwd, bwa));
	}

	public void addGame(Team h, Team a, int hg, int ag){
		this.addGame(h, a, hg, ag, (float)-1, (float)-1, (float)-1);
	}
	
	public Saison(int mc, String pSaison){
		this.TEAMCOUNT = mc;
		this.SAISON = pSaison;
		
		this.actSpieltag =new Spieltag(this.SAISON, this.spielTagCounter, this);
		spieltage.add(this.actSpieltag);
	}
	
	public int getTeamCount(){
		return this.TEAMCOUNT;
	}
	
	public void addTeam(Team t){
		teams.add(t);
	}
	
	public Team getTeam(String name){
		for(Team t : teams)
			if(name.equals(t.getName()))
				return t;
		
		return null;
	}
	
	public void incSpielTag(){
		actSpieltag = new Spieltag(this.SAISON, this.spielTagCounter, this);
		spieltage.add(actSpieltag);
		this.spielTagCounter++;
	}
	
	public void updateTabel(){
		for(Team t: teams)
			actSpieltag.updateTabel(new Tabellenstand(t.getGoalsShooten(), t.getGoalsGot(), t.getPoints(), t));
	}
	
	public ArrayList<Spieltag> getSpieltage(){
		return this.spieltage;
	}
	public void printTabelle(int nr){

		for(Spieltag st : spieltage)
			if(st.getNr() == nr)
				st.printTabelle();
	}

}

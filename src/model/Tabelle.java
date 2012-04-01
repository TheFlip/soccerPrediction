package model;

import java.util.ArrayList;
import java.util.Collections;

public class Tabelle {
	private ArrayList<Tabellenstand> tabellenstaende = new ArrayList<Tabellenstand>();
	private int spieltagNr;
	
	public Tabelle(int nr){
		this.spieltagNr = nr;
	}
	
	public void addStand(Tabellenstand ts){
		this.tabellenstaende.add(ts);
	}
	
	public void printTabelle(){
		Collections.sort(tabellenstaende);
		for(Tabellenstand t : tabellenstaende)
			System.out.println( t.getTeam().toString() + "  "+  t.getGoalsShooten() + ":" + t.getGoalsGot() + "  "  + t.getPoints());
	}
	
}

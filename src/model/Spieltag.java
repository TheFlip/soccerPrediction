package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Spieltag {
	ArrayList<Spiel> spiele = new ArrayList<Spiel>();
	String saison;
	Tabelle tabel;
	int nr;
	Saison lc;
	
	public Spieltag(String pSaison, int pNr, Saison lc){
		this.saison = pSaison;
		this.nr = pNr;
		this.tabel = new Tabelle(nr);
		this.lc = lc;
	}
	
	public void addSpiel(Spiel s){
		spiele.add(s);
		System.out.println(s);
		
		s.getHomeTeam().addSpiel(s);
		s.getAwayTeam().addSpiel(s);
	}

	public String toString() {
		return this.saison + " " + this.nr + ": ";
	}
	
	public void updateTabel(Tabellenstand t){
		tabel.addStand(t);
	}
	
	public void printTabelle(){
		tabel.printTabelle();
	}
	
	public int getNr(){
		return nr;
	}
	
	public String[] getSpielString(){
		String[] spielStrings = new String[spiele.size()];
		int counter = 0;
		for(Spiel s : spiele){
			Team home = s.getHomeTeam(), away = s.getAwayTeam();
			
			int homePoints = home.getPoints(nr-1),
			awayPoints = away.getPoints(nr-1),
			homeGoalsShooten = home.getGoalsShooten(nr-1),
			homeGoalsGot = home.getGoalsGot(nr-1),
			awayGoalsShooten = away.getGoalsShooten(nr-1),
			awayGoalsGot = away.getGoalsGot(nr-1);
			
			int lastGamesPoints[] = new int[4],
			lastGoals[] = new int[4];
			
			for(int i=0;i<lastGamesPoints.length; i++){
				lastGamesPoints[i] = home.getPointsLastGames(i+1, nr-1) - away.getPointsLastGames(i+1, nr-1);
				lastGoals[i] = ((home.getGoalsShootenLastGames(i+1,nr-1)-home.getGoalsGotLastGames(i+1, nr-1))
						-(away.getGoalsShootenLastGames(i+1,nr-1)-away.getGoalsGotLastGames(i+1, nr-1)));
			}

			
			int result;
			if(s.getHomeGoals() > s.getAwayGoals())
				result = 1;
			else if(s.getHomeGoals() < s.getAwayGoals())
				result = 2;
			else
				result = 3;
			
			spielStrings[counter] = homePoints-awayPoints + "," + 
			((homeGoalsShooten-homeGoalsGot)-(awayGoalsShooten-awayGoalsGot)) + "," + 
			//lastGamesPoints[4] + "," +
			lastGamesPoints[3] + "," +
			lastGamesPoints[2] + "," +
			lastGamesPoints[1] + "," +
			lastGamesPoints[0] + "," +
			//lastGoals[4] + "," +
			lastGoals[3] + "," +
			lastGoals[2] + "," +
			lastGoals[1] + "," +
			lastGoals[0] + "," +
			s.getBwinQuoteHome() + "," + 	
			s.getBwinQuoteDraw() + "," +
			s.getBwinQuoteAway() + "," + 
			result;

			
			spielStrings[counter]+= "\n";
			counter++;
		}
		
		return spielStrings;
	}
	

}

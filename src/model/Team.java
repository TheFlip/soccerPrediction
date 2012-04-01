package model;

import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Spiel> spiele = new ArrayList<Spiel>();
	
	public Team(String pName){
		this.name = pName;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addSpiel(Spiel s){
		spiele.add(s);
	}
	
	public void printSpiele(){
		for(Spiel s : spiele)
			System.out.println(s);
	}

	@Override
	public String toString() {
		return name;
	}
	
	public int getPoints(){
		return getPoints(this.spiele.size());
	}
	
	public int getPoints(int i){
		int points = 0, counter = 0;
		for(Spiel spiel : spiele){
			if(counter < i)
				if(spiel.getHomeGoals() == spiel.getAwayGoals())
					points += 1;
				else if((spiel.getHomeTeam().equals(this) && spiel.getHomeGoals() > spiel.getAwayGoals()) ||
					(spiel.getAwayTeam().equals(this) && spiel.getAwayGoals() > spiel.getHomeGoals()))
					points += 3;
			counter ++;
		}
		return points;	
	}

	public int getGoalsShooten(int i){
		int goals = 0, counter = 0;
		for(Spiel spiel : spiele){
			if(counter < i)
				if(spiel.getAwayTeam() == this)
					goals += spiel.getAwayGoals();
				else goals += spiel.getHomeGoals();
			counter ++;
			
		}
		return goals;		
	}
	
	public int getGoalsShooten() {
		return getGoalsShooten(this.spiele.size());
	}
	
	public int getGoalsGot(){
		return getGoalsGot(this.spiele.size());
	}
	
	public int getGoalsGot(int i) {
		int goals = 0, counter = 0;
		for(Spiel spiel : spiele){
			if(counter < i)
				if(spiel.getAwayTeam() == this)
					goals += spiel.getHomeGoals();
				else goals += spiel.getAwayGoals();
			counter ++;
		}
		return goals;
	}	
	
	public int getPointsLastGames(int gameCount, int end){
		int points = 0;
		for(;gameCount > 0; --gameCount){
			System.out.println("End: " + end);
			System.out.println("GameCount: " + gameCount);
			Spiel spiel = spiele.get(end-gameCount);
			if(spiel.getHomeGoals() == spiel.getAwayGoals())
				points += 1;
			else if((spiel.getHomeTeam().equals(this) && spiel.getHomeGoals() > spiel.getAwayGoals()) ||
				(spiel.getAwayTeam().equals(this) && spiel.getAwayGoals() > spiel.getHomeGoals()))
				points += 3;
		}
		return points;
	}
	
	public int getGoalsShootenLastGames(int gameCount, int end){
		int goals = 0;
		for(;gameCount > 0; --gameCount){
			Spiel spiel = spiele.get(end-gameCount);
			if(spiel.getHomeTeam().equals(this))
				goals += spiel.getHomeGoals();
			else
				goals += spiel.getAwayGoals();
		}
		return goals;
	}
	
	public int getGoalsGotLastGames(int gameCount, int end){
		int goals = 0;
		for(;gameCount > 0; --gameCount){
			Spiel spiel = spiele.get(end-gameCount);
			if(spiel.getHomeTeam().equals(this))
				goals += spiel.getAwayGoals();
			else
				goals += spiel.getHomeGoals();
		}
		return goals;
	}
	
}

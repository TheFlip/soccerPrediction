package model;

public class Tabellenstand implements Comparable<Tabellenstand>{
	private int goalsShooten;
	private int goalsGot;
	private int points;
	private Team team;
	
	public Tabellenstand(int gs, int gg, int p, Team t){
		this.goalsShooten = gs;
		this.goalsGot = gg;
		this.points = p;
		this.team = t;
	}
	
	public int getGoalsShooten() {
		return goalsShooten;
	}
	public void setGoalsShooten(int goalsShooten) {
		this.goalsShooten = goalsShooten;
	}
	public int getGoalsGot() {
		return goalsGot;
	}
	public void setGoalsGot(int goalsGot) {
		this.goalsGot = goalsGot;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}

	public int compareTo(Tabellenstand t) {
			if(t.getPoints() > this.getPoints())
				return 1;
			else if(t.getPoints() < this.getPoints())
				return -1;
			else if(t.getGoalsShooten() - t.getGoalsGot() > this.getGoalsShooten() - this.getGoalsGot())
				return 1;
			else if(this.getGoalsShooten() - this.getGoalsGot() > t.getGoalsShooten() - t.getGoalsGot())
				return -1;
			else if(t.getGoalsShooten() > this.getGoalsShooten())
				return 1;
			else if(this.getGoalsShooten() > t.getGoalsShooten())
				return -1;
			else
				return 1;
	}
}

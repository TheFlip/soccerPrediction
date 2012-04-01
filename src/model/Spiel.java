package model;

public class Spiel {
	private Team homeTeam;
	private Team awayTeam;
	
	private int homeGoals;
	private int awayGoals;
	
	private Spieltag st;
	private float bwinQuoteHome;
	private float bwinQuoteDraw;
	private float bwinQuoteAway;
	
	public Spiel(Team h, Team a, int hg, int ag, Spieltag pSpieltag, float pBwh, float pBwd, float pBwa){
		this.homeTeam = h;
		this.homeGoals = hg;
		this.awayTeam = a;
		this.awayGoals = ag;
		this.st = pSpieltag;
		this.bwinQuoteAway = pBwa;
		this.bwinQuoteDraw = pBwd;
		this.bwinQuoteHome = pBwh;
	}

	public float getBwinQuoteHome() {
		return bwinQuoteHome;
	}

	public void setBwinQuoteHome(float bwinQuoteHome) {
		this.bwinQuoteHome = bwinQuoteHome;
	}

	public float getBwinQuoteDraw() {
		return bwinQuoteDraw;
	}

	public void setBwinQuoteDraw(float bwinQuoteDraw) {
		this.bwinQuoteDraw = bwinQuoteDraw;
	}

	public float getBwinQuoteAway() {
		return bwinQuoteAway;
	}

	public void setBwinQuoteAway(float bwinQuoteAway) {
		this.bwinQuoteAway = bwinQuoteAway;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getHomeGoals() {
		return homeGoals;
	}

	public void setHomeGoals(int homeGoals) {
		this.homeGoals = homeGoals;
	}

	public int getAwayGoals() {
		return awayGoals;
	}

	public void setAwayGoals(int awayGoals) {
		this.awayGoals = awayGoals;
	}

	public String toString() {
		return this.st.toString() + homeTeam + "-" + awayTeam + " " + homeGoals + ":" + awayGoals;
	}
	
}

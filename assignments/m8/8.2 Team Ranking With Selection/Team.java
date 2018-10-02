public class Team implements Comparable {
	private String teamName;
	private int Wins;
	private int Losses;
	private int Draws;

	public Team(final String teamName,
	            final int Wins,
	            final int Losses,
	            final int Draws) {
		this.teamName = teamName;
		this.Wins = Wins;
		this.Losses = Losses;
		this.Draws = Draws;
	}

	public int getDraws() {
		return Draws;
	}

	public void setDraws(int Draws) {
		this.Draws = Draws;
	}

	public int getLosses() {
		return Losses;
	}

	public void setLosses(int Losses) {
		this.Losses = Losses;
	}

	public int getWins() {
		return Wins;
	}

	public void setWins(int Wins) {
		this.Wins = Wins;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int compareTo(Object other) {
		Team that = (Team) other;
		if (this.getWins() > that.getWins())
			return -1;
		if (this.getWins() < that.getWins())
			return 1;

		if (this.getLosses() < that.getLosses())
			return -1;
		if (this.getLosses() > that.getLosses())
			return 1;

		if (this.getDraws() > that.getDraws())
			return -1;
		if (this.getDraws() < that.getDraws())
			return 1;

		return 0;
	}

	public String toString() {
		// StringBuffer sb = new StringBuffer();
		// sb.append(this.getTeamName() + ",");
		// sb.append(this.getWins() + ",");
		// sb.append(this.getDraws() + ",");
		// sb.append(this.getLosses());
		return this.getTeamName();
	}
}
public class Team implements Comparable<Team>{
	private final int wins;
	private final int losses;
	private final int draws;
	private final string Team_name;

	public Team(final String Team_name,final int w,final int l, final int d) {
	wins=w,losses=l,draws=d;
	this.Team_name=Team_name;
	public int wins();{ return wins;}
	public int losses();{ return losses;}
	public int draws();{ return draws;}
	}

	public String getNam(){
		return Team_name;
	}
	public int setNam(){
		this.Team_name=Team_name;
	}
	public int getDraws(){
		return draws;
	}
	public int setDraws(){
		this.draws=draws;
	}
	public int getWins(){
		return wins;
	}
	public int setWins(){
		this.wins=wins;
	}
	public int getLossess(){
		return lossess;
	}
	public int setLossess(){
		this.lossess=lossess;
	}

	public int compareTo(Team that) {
		//Team that=(Team) other;
		//Object other
		if(this.getWins() < that.getWins()) return + 1;
		
		if(this.getlosses() > that.getlosses()) return + 1;
		
		if(this.getdraws() < that.getdraws()) return + 1;

		if(this.getWins() > that.getWins()) return - 1;
		
		if(this.getlosses() < that.getlosses()) return - 1;
		
		if(this.getdraws() > that.getdraws()) return - 1;
		
		return 0;
	}

	

	public String toString() { // print Name,win,loss,draws
		

		return Team_name + "," +draws + "," + lossess + "," + draws;
		


	}



}
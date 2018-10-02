public class Team implements Comparable<Team>{
	private final int wins;
	private final int losses;
	private final int draws;
	private final string Team_name;

	public Team(final String Team_name,final int wins,final int losses, final int draws) {
	
	this.Team_name=Team_name;
	this.wins=wins;
	 this.losses=losses;
	this.draws=draws;
	}

	public String getNam(){
		return Team_name;
	}
	public int setNam(String Team_name){
		this.Team_name=Team_name;
	}
	public int getDraws(){
		return draws;
	}
	public int setDraws(int draws){
		this.draws=draws;
	}
	public int getWins(){
		return wins;
	}
	public int setWins(int wins){
		this.wins=wins;
	}
	public int getLossess(){
		return losses;
	}
	public int setLossess(int losses){
		this.losses=losses;
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
		

		return this.getNam();
		


	}



}
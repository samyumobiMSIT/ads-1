/**
 * Class for team.
 */
class Team implements Comparable<Team> {
	String teamname;
	int wins, losses, draws;
	Team(String pname, int runs, int sixes, int twentys,
		int hundreds,int twohundreds,int zeroes) {
		this.pname = pname;
				this.hundreds = hundreds;
				this.twohundreds = twohundreds;
				this.zeroes = zeroes;
				this.runs = runs;
				this.sixes = sixes;
				this.twentys = twentys;
	}
	public int getRuns() {
				return runs;
			}
			public int getSixes() {
				return sixes;
			}
			public int getTwentys() {
				return twentys;
			}
			public void setRuns(int runs) {
				this.runs = runs;
			}
			public void setSixes(int sixes) {
				this.sixes = sixes;
			}
			public void setTwentys(int twentys) {
				this.twentys = twentys;
			}
			/**
			 * Gets the pname.
			 *
			 * @return     The pname.
			 */
			public String getpname() {
		          return this.pname;
			}
			/**
			 * Gets the hundreds.
			 *
			 * @return     The hundreds.
			 */
			public int gethundreds() {
				return this.hundreds;
			}
			/**
			 * Gets the twohundreds.
			 *
			 * @return     The twohundreds.
			 */
			public int gettwohundreds() {
				return this.twohundreds;
			}
			/**
			 * Gets the zeroes.
			 *
			 * @return     The zeroes.
			 */
			public int getzeroes() {
				return this.zeroes;
			}
			/**
			 * Sets the pname.
			 *
			 * @param      pname  The pname
			 */
			public void setpname(String pname) {
				this.pname = pname;
			}
			/**
			 * Sets the hundreds.
			 *
			 * @param      hundreds  The hundreds
			 */
			public void sethundreds(int hundreds) {
				this.hundreds = hundreds;
			}
			/**
			 * Sets the twohundreds.
			 *
			 * @param      twohundreds  The twohundreds
			 */
			public void settwohundreds(int twohundreds) {
				this.twohundreds = twohundreds;
			}
			/**
			 * Sets the zeroes.
			 *
			 * @param      zeroes  The zeroes
			 */
			public void setzeroes(int zeroes) {
				this.zeroes = zeroes;
			}
	
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return this.teamname;
	}
	/**
	 * { function_description }
	 *
	 * @param      that  The that
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(Team that) {
		if(this.hundreds > that.hundreds) return -1;
				if(this.hundreds < that.hundreds) return 1;
				if(this.twohundreds < that.twohundreds) return -1;
				if(this.twohundreds > that.twohundreds) return 1;
				if(this.zeroes > that.zeroes) return -1;
				if(this.zeroes < that.zeroes) return 1;
				if(this.runs > that.runs) return -1;
				if(this.runs < that.runs) return 1;
				if(this.sixes > that.sixes) return -1;
				if(this.sixes < that.sixes) return 1;
				if(this.twentys > that.twentys) return -1;
				if(this.twentys < that.twentys) return 1;
				
				return 0;
	}

}

/**
 * This class creates teams to be used in the application
 * Comparable is implemented in order to be able to sort objects in an ArrayList
 * We also need to override the compareTo() method which is done further down in this class
 * @author Troy Naidoo
 * @author Max Stronge
 * @author Mohamed Ebdalla
 */
public class Team implements Comparable<Team> {
	
	//Instance variables
	private String name;
	private int numGamesWon;
	
	/**
	 * Constructor for the class Team. Takes a String to set the name of the team to, and an int
	 * to set the number of games win by the team to
	 * @param teamName String to set the team name to
	 * @param gamesWon Number of games won by the team in the league
	 */
	public Team(String teamName, int gamesWon) {
		name = new String(teamName);
		if (gamesWon < 0) {
			System.out.print("Error: Games won cannot be negative");
				numGamesWon = 0;
			}
			
		else {
			numGamesWon = gamesWon;
    }
	}
	
	/**
	 * Allows the user to get the name of the team
	 * @return String Returns the name of the team
	 */
	public String getName() {
		return new String(name);
	}
	
	/**
	 * Allows the user to set the name of the team
	 * @param name String to set the name of the team to
	 */
	public void setName(String name) {
		this.name = new String(name);
	}
	
	/**
	 * Allows the user to get the number of games won by the team
	 * @return int Returns the number of games win by the team
	 */
	public int getNumGamesWon() {
		return numGamesWon;
	}
	
	/**
	 * Allows the user to set the number of games won by the team
	 * @param gamesWon Number to set the number of games won by the team to. Must be positive
	 */
	public void setNumGamesWon(int gamesWon) {
		if (numGamesWon < 0) {
			System.out.print("ERROR: Games won cannot be negative");
			numGamesWon = 0;
		}
		
		else {
			numGamesWon = gamesWon;
		}
	}
	
	/**
	 * Uses the number of games won and the total number of games to find the number of games
	 * lost by the team
	 * @param numberOfGames The total number of games the team plays
	 * @return int Returns the number of games lost by the team in the league
	 */
	public int numGamesLost(int numberOfGames) {
		if (numberOfGames < 1) {
			System.out.println("ERROR: number of games must be at least 1");
			return 0;
		}
		
		else {
			int numGamesLost = numberOfGames - numGamesWon;
			return numGamesLost;	
		}	
	}
	
	/**
	 * Overrides the compareTo() method so that it can be used in the TeamSorter class to
	 * sort teams in an ArrayList by their number of wins
	 * this section uses code from https://dzone.com/articles/sorting-java-arraylist
	 */
	@Override     
	  public int compareTo(Team aTeam) {          
	    return (this.getNumGamesWon() > aTeam.getNumGamesWon() ? -1 : 
	            (this.getNumGamesWon() == aTeam.getNumGamesWon() ? 0 : 1));     
	  }
	
	/**
	 * Allows the user to get information about the team out as a String
	 * @return String Returns a String containing the team name and number of games won
	 */
	public String toString() {
		int emptySpaces = 25 - this.name.length();
		if (emptySpaces < 1) {
			emptySpaces = 1;
		}
		String spaceString = ("");
		for (int i = 0; i < emptySpaces; i++) {
			spaceString = spaceString.concat(" ");
			
		}
	    return (this.name + spaceString + numGamesWon);     
	} 

}

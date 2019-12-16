package cardgame;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author: Abdul Mannan
// date: 06/03/2019
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    
    public int[] getWinners()
    {
    	int max = -1 , checked = 100;
        int[] winners = new int[scores.length];
        int[] players = new int[winners.length];
	    for(int y = 0; y < winners.length; y++) {
	    	for(int x = 0; x < winners.length; x++) {
	        	if(scores[x] > max && scores[x] < checked) {
	        		max = scores[x];
	        	}
	        }
	    	checked = max;
	    	max = -1;
	    	if(checked != -1) {
	    		winners[y] = checked;
	    	}
	    	for(int x = 0; x < winners.length; x++) {
	        	if(scores[x] == checked ) {
	        		winners[x] = checked;
	        	}
	        }
	    }    
	    for(int x = 0; x < winners.length; x++) {
    		for(int y = 0; y < winners.length; y++) {
    			if(winners[x] == scores[y]) {
    				players[x] = y;
    			}
    		}
    	}
	    return players;
    }	
        
}
    
 // end class ScoreCard

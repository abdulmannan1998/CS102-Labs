package cardgame;

import java.util.ArrayList;

// Cardgame
// author: Abdul Mannan
// date: 06/03/2019
public class CardGame
{
	// properties
	Cards             fullPack;
	ArrayList<Player> players;
	ScoreCard         scoreCard;
	Cards             cardsOnTable;
	int               roundNo;
	int               turnOfPlayer;

	// constructors
	public CardGame( Player p1, Player p2, Player p3, Player p4)
	{
		players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		fullPack = new Cards(true);
		cardsOnTable = new Cards(false);
		scoreCard = new ScoreCard(players.size());
		roundNo = 0;
		turnOfPlayer = 0;
		fullPack.shuffle();
		for(int x = 0; x < players.size(); x++) {
			for(int y = 0; y < 13; y++) {
				players.get(x).add(fullPack.getTopCard());
			}
		}
	}

	// methods
	public boolean playTurn( Player p, Card c)
	{
		if( isGameOver() || !isTurnOf(p)){
			return false;
		}

		cardsOnTable.addTopCard(c);

		if(turnOfPlayer < players.size() - 1) {
			turnOfPlayer++;
		}
		else {
			int max = -1, index = 0, card;
			for(int x = players.size() - 1; x >= 0 ; x--) {
				card = cardsOnTable.getTopCard().cardNo;
				if(card > max) {
					max = card;
					index = x;
				}
			}
			scoreCard.update(players.indexOf(players.get(index)), 1);

			if(!isGameOver()) {
				roundNo++;
				turnOfPlayer = 0;
			}
		}
		return true;
	}

	public boolean isTurnOf( Player p)
	{
		int playerNo = players.indexOf(p);
		if(turnOfPlayer == playerNo) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isGameOver()
	{
		if((((roundNo + 1) * players.size()) + turnOfPlayer) == fullPack.NOOFCARDSINFULLPACK) {
			return true;
		}
		else {
			return false;
		}
	}

	public int getScore( int playerNumber)
	{
		return scoreCard.getScore(playerNumber);
	}

	public String getName( int playerNumber)
	{
		return players.get(playerNumber).getName();
	}

	public int getRoundNo()
	{
		return roundNo;
	}

	public int getTurnOfPlayerNo()
	{
		return turnOfPlayer;
	}

	public Player[] getWinners()
	{
		int check = -1;
		Player[] positions = new Player[players.size()];
		int[] winners = new int[players.size()];
		winners = scoreCard.getWinners();
		for(int y = 0; y < positions.length ; y++) {
			positions[winners[y]] = players.get(y);
			check = winners[y];
			for(int x = 0; x < winners.length; x++) {
				if(winners[x] == check ) {
					winners[x] = winners[x] + 1;
				}
			}
		}
		return positions;
	}

	

	public String showScoreCard()
	{
		return scoreCard.toString();
	}

}
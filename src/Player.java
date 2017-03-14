
public abstract class Player {
	
	private PlayerType playerType;
	private Deck playerDeck, usableDeck;
	private int score;
	private PlayingStatus status;
	
	public Boolean reciveCard(Card revCard){
		return playerDeck.addOneCard(revCard);
	}
	
	public Boolean isCardEquals(Card c1, Card c2){  //return if it same type || same num || same color, one of that
		System.out.println("--Compare card -- " + c1.toString() + " : " + c2.toString());
		if(c1.getType() == c2.getType()){
			if(c1.getType() == CardType.NUMBER && c1.getNumber() == c2.getNumber()){return true;}
			else{return true;}
		}
		else if(c1.getColor() == c2.getColor()){
			if(c1.getType() == CardType.NUMBER && c1.getNumber() == c2.getNumber()){return true;}
			else{return true;}
		}
		return false;
	}
	
	public Deck checkPlayAbleCard(Card recentCard){
		for (int i = 0; i < playerDeck.countCard(); i++) {
			if(isCardEquals(recentCard, playerDeck.getCardAt(i))){
				usableDeck.addOneCard(playerDeck.getCardAt(i));
			}
		}
		return usableDeck;
	}
	
	public abstract Card chooseCard();
	
	public abstract void enterCard();
	
	
	
	
	

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

	public Deck getPlayerDeck() {
		return playerDeck;
	}

	public void setPlayerDeck(Deck playerDeck) {
		this.playerDeck = playerDeck;
	}

	public Deck getUsableDeck() {
		return usableDeck;
	}

	public void setUsableDeck(Deck usableDeck) {
		this.usableDeck = usableDeck;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public PlayingStatus getStatus() {
		return status;
	}

	public void setStatus(PlayingStatus status) {
		this.status = status;
	}
	
	
	
	
}

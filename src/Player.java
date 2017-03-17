
public abstract class Player {
	
	private PlayerType playerType;
	private Deck playerDeck, usableDeck;
	private int score;
	private PlayingStatus status;
	private String playerName;
	
	public Player() {
		super();
		playerDeck = new Deck();
		usableDeck = new Deck();
	}

	public Boolean reciveCard(Card revCard){
		return playerDeck.addOneCard(revCard);
	}
	
	public Boolean isCardCanPlaceOver(Card c1, Card c2){  //placeOver return if it same type || same color, one of that
		//System.out.println("--Compare card -- " + c1.toString() + " : " + c2.toString());
		if(c1.getColor() == c2.getColor()){return true;}
		else if(c1.getType() == c2.getType()){ //number need to equal
			if(c1.getType() == CardType.NUMBER && c1.getNumber() == c2.getNumber()){return true;}
			if(c1.getType() == CardType.NUMBER && c1.getNumber() != c2.getNumber()){return false;}
			else{return true;}
		}
		return false;
	}
	
	//can stack with this  if samecolor need diff type || if number same color need diff num
//	public Boolean isCardCanStack(Card c1, Card c2){  
//		System.out.println("--Compare card -- " + c1.toString() + " : " + c2.toString());
//		if(c1.getType() == c2.getType()){
//			if(c1.getType() != CardType.NUMBER){return true;}
//			else if(c1.getType() == CardType.NUMBER && c1.getNumber() == c2.getNumber()){return true;}
//			else{return false;}
//		}
//		else if(c1.getColor() == c2.getColor()){
//			if(c1.getType() == CardType.NUMBER && c1.getNumber() != c2.getNumber()){return false;}
//			else{return true;}
//		}
//		return false;
//	}
	
	public Deck checkPlayAbleCard(Card recentCard){
		for (int i = 0; i < playerDeck.countCard(); i++) {
			if(isCardCanPlaceOver(recentCard, playerDeck.getCardAt(i))){
				//System.out.println("equal");
				usableDeck.addOneCard(playerDeck.getCardAt(i));
			}
		}
		return usableDeck;
	}
	
	public abstract Card chooseCard();
	
	
	
	
	
	

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

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	

	
	
	
	
}

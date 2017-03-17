
public class HumanPlayer extends Player {
	
	public HumanPlayer() {
		super();
		this.playerType = PlayerType.Human;
	}

	public HumanPlayer(String playerName) {
		super();
		super.setPlayerName(playerName);
		this.playerType = PlayerType.Human;
	}

	private PlayerType playerType = PlayerType.Human;
	private Deck playerDeck, usableDeck;
	private int score;
	private PlayingStatus status = PlayingStatus.Playing;


	@Override
	public Card chooseCard() { //remove card from your deck too
		
		return null;
	}


	
}

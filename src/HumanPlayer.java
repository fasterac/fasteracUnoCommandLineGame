
public class HumanPlayer extends Player {
	
	public HumanPlayer() {
		super();
		this.playerType = PlayerType.Human;
	}

	private PlayerType playerType = PlayerType.Human;
	private Deck playerDeck, usableDeck;
	private int score;
	private PlayingStatus status = PlayingStatus.Playing;

	@Override
	public Card chooseCard() {
		
		return null;
	}

	@Override
	public void enterCard() {
		
		
	}

}

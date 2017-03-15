
public class ComputerPlayer extends Player {
	
	public ComputerPlayer() {
		super();
		this.playerType = PlayerType.Computer;
	}

	private PlayerType playerType = PlayerType.Computer;
	private Deck playerDeck, usableDeck;
	private int score;
	private PlayingStatus status;

	@Override
	public Card chooseCard() {
		
		return null;
	}

	@Override
	public void enterCard() {
		
		
	}

}

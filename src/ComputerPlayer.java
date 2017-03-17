
public class ComputerPlayer extends Player {
	
	public ComputerPlayer() {
		super();
		this.playerType = PlayerType.Computer;
	}
	

	public ComputerPlayer(String playerName) {
		super();
		super.setPlayerName(playerName);
		this.playerName = playerName;
		this.playerType = PlayerType.Computer;
	}


	private PlayerType playerType = PlayerType.Computer;
	private Deck playerDeck, usableDeck;
	private int score;
	private PlayingStatus status;
	private String playerName;

	@Override
	public Card chooseCard() {
		
		return null;
	}



	
}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameControl {
	
	public GameControl() {
		super();
	}

	private ArrayList<Player> listPlayer;
	private Deck unuseDeck, trashDeck;
	private Boolean isRotationRight = true, saidUno=false;
	private Card currentCard, roundCard;
	private int player, complay, humanplay;
	private final int INIT_CARD = 7, ALLGAME_CARD = 14*7, CARD_IN_SUIT = 14;
	private String tempstr;
	
	Scanner scanner = new Scanner(System.in);
	
	public Boolean gameSetting(){
		while(true){
			try{
				System.out.print("How many All player: "); //not <2 and >13 not 14
				tempstr = scanner.nextLine();
				player = Integer.parseInt(tempstr);
				break;
			}catch (NumberFormatException exception){
				System.err.println("Please enter number");
			}catch (InputMismatchException exception) {
				System.err.println("Please enter number");
			}
		}
		
		while(true){ //not 0 and <allplayer
			try{
				System.out.print("How many player want to play with computer: ");
				tempstr = scanner.nextLine();
				humanplay = Integer.parseInt(tempstr);				
				if(humanplay > player){
					throw new TooMuchHumanPlayerException();
				}
				break;
			}catch (TooMuchHumanPlayerException e) {
				System.err.println("Human can't be more than all player. Current All Player now:" + player);
			}catch (NumberFormatException exception){
				System.err.println("Please enter number");
			}catch (InputMismatchException exception) {
				System.err.println("Please enter number");
			}
		}
		
		complay = player - humanplay;
		System.out.println("------------------------------");
		System.out.println("Confirm Player--- All player:" + player + ", Human Player:" 
				+ humanplay + ", Computer:" + complay);
		System.out.println("PRESS ENTER TO START   or type anything and enter to edit");
		System.out.println("");
		
		tempstr = scanner.nextLine();
		if (tempstr.isEmpty()){
			gameStart();
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
	private void gameStart(){
		System.out.println("##############################");
		System.out.println("------------------------------");
		System.out.println("----------GAME START----------");
		System.out.println("------------------------------");
		System.out.println("##############################");
		System.out.println("");
		unuseDeck = CreateUnuseDeck();
		unuseDeck.shuffleCard(1);
		trashDeck = new Deck();
		listPlayer = createPlayerList();
		printRotation(listPlayer);
		drawCard();
		for (int i = 0; i < unuseDeck.countCard(); i++) { //first card must be number
			System.out.println(unuseDeck.countCard() + unuseDeck.getCardAt(i).getType().getText() );
			if(unuseDeck.getCardAt(i).getType() == CardType.NUMBER){
				exchangeCard(unuseDeck, trashDeck);
				break;
			}
		}
		currentCard = trashDeck.getCardAt(0);
		roundCard = trashDeck.getCardAt(0);
		
		
		//in turn   while game end == true
		for (Player player : listPlayer) {
			System.out.println("");
			System.out.println(player.getPlayerName() +" "+roundCard.toString());
			player.checkPlayAbleCard(roundCard);			
			player.getPlayerDeck().printAllCardInDeck();
			player.getUsableDeck().printAllCardInDeck();
			
//			if (player.getUsableDeck().countCard() != 0) {
//				if(currentCard.getType() == CardType.NUMBER){
//					currentCard = player.chooseCard();
//					
//					trashDeck.addOneCard(currentCard);
//				}
//				else if(currentCard.getType() == CardType.SKIP){
//					System.out.println(player.getPlayerName()" has been SKIPed");
//				}
//			}
//			else{
//				System.out.println("You Can't use any card there. Press ENTER to pass and recive card");
//				exchangeCard(unuseDeck, player.getPlayerDeck());
//			}
//			
//			if(player.getPlayerType() == PlayerType.Human && player.getStatus() == PlayingStatus.Uno && saidUno == false){
//				System.out.println("You forgot to said UNO......  Here are some card");
//				exchangeCard(unuseDeck, player.getPlayerDeck());
//			}
			
			/// end turn
			meansureRoundCard();
			if(unuseDeck.countCard() < 6){
				//get some card from trash
			}
		}
	}
	
	
	
	
	
	
	
	
	private Deck CreateUnuseDeck() { //can serializable
		Deck newDeck = new Deck();
		Random random = new Random();
		CardColor color = CardColor.BlACK; 
				
		for (int i = 0; i < ALLGAME_CARD; i++) {
			int colorN = random.nextInt(4) + 1;
			switch (colorN) {
				case 1: color = CardColor.RED; break;
				case 2: color = CardColor.GREEN; break;
				case 3: color = CardColor.BLUE; break;
				case 4: color = CardColor.YELLOW; break;
			}
			
			if(i%CARD_IN_SUIT <= 9){
				newDeck.addOneCard(new Card(i%CARD_IN_SUIT, color));
			}
			else if(i%CARD_IN_SUIT == 10){
				newDeck.addOneCard(new Card(CardType.SKIP, color));
			}
			else if(i%CARD_IN_SUIT == 11){
				newDeck.addOneCard(new Card(CardType.CHANGEROTATION, color));
			}
			else if(i%CARD_IN_SUIT == 12){
				newDeck.addOneCard(new Card(CardType.MULTIPLE2, color));
			}
			else if(i%CARD_IN_SUIT == 13){
				newDeck.addOneCard(new Card(CardType.MULTIPLE4, color));
			}
		}
		return newDeck;
	}
	
	private ArrayList<Player> createPlayerList(){
		int numhuman=1, numcom=1;
		ArrayList<Player> list = new ArrayList<Player>();
//		int ranCriteria = humanplay > complay ? complay/humanplay : humanplay/complay;
		while (humanplay > 0 && complay > 0) {
			if(humanplay > 0 || complay > 0){
				if(Math.random() < 0.5 && humanplay > 0){
					list.add(new HumanPlayer("Player" + String.format("%02d", humanplay)));
					humanplay -= 1;
				}
				else if(Math.random() >= 0.5 && complay > 0){
					list.add(new ComputerPlayer("Computer" + String.format("%02d", complay)));
					complay -= 1;
				}
			}
			if(humanplay > 0 && complay == 0){
				while (humanplay > 0) {
					list.add(new HumanPlayer("Player" + String.format("%02d", humanplay)));
					humanplay -= 1;
				}
			}
			else if(humanplay == 0 && complay > 0){
				while (complay > 0) {
					list.add(new ComputerPlayer("Computer" + String.format("%02d", complay)));
					complay -= 1;
				}
			}
		}
		return list;
	}
	
	private void printRotation(ArrayList<Player> listPlayer){ //player this turn  at left
		for (int i = 0; i < listPlayer.size(); i++) {
			System.out.print(listPlayer.get(i).getPlayerName());
			System.out.print(", ");
		}
		System.out.println("");
	}
	
	private void drawCard(){ //jakpai
		int playerCounter = listPlayer.size()-1;
		for (int i = 0; i < ALLGAME_CARD; i++) {
			if(i%INIT_CARD==0 && playerCounter >= 0 && i != 0){
				playerCounter -= 1;
			}
			if(playerCounter < 0){
				break;
			}
			exchangeCard(unuseDeck, listPlayer.get(playerCounter).getPlayerDeck());
		}
	}
	
	private void exchangeCard(Deck remvDeck, Deck recvDeck){ //exchange the first card of remvdeck
		recvDeck.addOneCard(remvDeck.getCardAt(0));
		remvDeck.removeOneCard(remvDeck.getCardAt(0));
	}
	
	private void meansureRoundCard(){   //should be apply next turn round card
		roundCard = currentCard;
	}


}

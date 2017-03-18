import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

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
	
	private Scanner scanp = new Scanner(System.in);
	private String playerMessage;
	private Boolean correctCard = false, isSaidUno = false;
	private String[] cardStrNum;


	@Override
	public Deck chooseCard(Card roundCard) { //remove card from your deck too
		Deck choosed = new Deck();
		isSaidUno = false;
		System.out.println("===== Turn of " + getPlayerName() + " =====");
		
		usableDeck = super.checkPlayAbleCard(roundCard);
		System.out.println("     Now you have " + getPlayerDeck().toText());
		System.out.println("     But now you can use " + usableDeck.toChooseText());
		System.out.println("     Below there, You can type anything that you want to say or do");
		System.out.print("     suggestion: Type \"pass\" if you want to pass or TYPE \"NUMBER\"[] BEFORE CARD THAT YOU WANT TO USE saperate by space:");
		while (!correctCard) {
			
			
//			if(playerMessage.substring(0, 2).equals("uno") || playerMessage.substring(0, 2).equals("Uno")){
//				playerMessage = playerMessage.substring(3, playerMessage.length());
//				isSaidUno = true;
//			}

			try {
				playerMessage = scanp.nextLine();
				System.out.println("     System: get Message "+playerMessage); //blank spc
				
				if(playerMessage.trim().equals("pass")){
					correctCard= true;
					break;
				}
				cardStrNum = playerMessage.split(" ");
				for (String n : cardStrNum) {
					if(Integer.parseInt(n) <= usableDeck.countCard()){
						//System.out.println(n + " " + usableDeck.getCardAt(Integer.parseInt(n)-1).toString() + " " + choosed.countCard());
						if(choosed.countCard() == 0){
							System.out.println("elif");
							choosed.addOneCard(usableDeck.getCardAt(Integer.parseInt(n)-1));
							usableDeck.removeOneCard(usableDeck.getCardAt(Integer.parseInt(n)-1));
						}
						else if(isCardCanStack(usableDeck.getCardAt(Integer.parseInt(n)-1), choosed.getCardAt(0)) && choosed.countCard() > 1){
							System.out.println("if");
							choosed.addOneCard(usableDeck.getCardAt(Integer.parseInt(n)-1));
							usableDeck.removeOneCard(usableDeck.getCardAt(Integer.parseInt(n)-1));
							
						}
						else{
							throw new CardCantStackException();
						}
					}
					else{
						throw new IndexOutOfBoundsException();
					}
					correctCard = true;
				}				
			} catch (NumberFormatException e){
				System.err.println("     Please enter number");
				System.out.print("     Please type again. TYPE \"NUMBER\"[] BEFORE CARD THAT YOU WANT TO USE saperate by space:");
			} catch (PatternSyntaxException e) {
				System.err.println("     Wrong Syntax");
				System.out.print("     Please type again. TYPE \"NUMBER\"[] BEFORE CARD THAT YOU WANT TO USE saperate by space:");
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
				System.err.println("     You have only " + usableDeck.countCard() + " card Please type in range 1-"+usableDeck.countCard());
				System.out.println("     You have   " + usableDeck.toChooseText() + "   Choose in this range");
				System.out.print("     Please type again. TYPE \"NUMBER\"[] BEFORE CARD THAT YOU WANT TO USE saperate by space:");
			} catch (CardCantStackException e) {
				System.err.println("     Using stack Card must same type. and Number card must to same number");
				System.out.println("     You have   " + usableDeck.toChooseText() + "   Choose in this range");
				System.out.print("     Please type again. TYPE \"NUMBER\"[] BEFORE CARD THAT YOU WANT TO USE saperate by space:");
			}
		}
		choosed.printAllCardInDeck();
		System.out.println("===== End turn " + getPlayerName() + " =====");
		return choosed;
	}
	
	private Boolean isAllCardContains(Deck d1, Deck d2){ //d1 are always smaller than d2
		for (int i = 0; i < d1.countCard(); i++) {
			if(!d2.haveCard(d1.getCardAt(i))){return false;}
		}
		return true;
	}

	public Boolean getIsSaidUno() {
		return isSaidUno;
	}

	public void setIsSaidUno(Boolean isSaidUno) {
		this.isSaidUno = isSaidUno;
	}


	
}

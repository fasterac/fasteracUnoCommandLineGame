import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Card c1 = new Card(1, CardColor.GREEN);
		Card c2 = new Card(4, CardColor.BLUE);
		Card c3 = new Card(8, CardColor.YELLOW);
		Card c4 = new Card(4, CardColor.GREEN);
		Card c5 = new Card(9, CardColor.RED);
		Card c6 = new Card(CardType.SKIP, CardColor.YELLOW);
		Card c7 = new Card(CardType.SKIP, CardColor.GREEN);
		
		Deck deck = new Deck();
		Deck deck2 = new Deck();
		deck.addOneCard(c1);
		deck.addOneCard(c2);
		deck.addOneCard(c3);
		deck.addOneCard(c4);
		deck.addOneCard(c5);
		deck.addOneCard(c6);
		deck.addOneCard(c7);
		
		deck.removeOneCard(c5);	
		//System.out.println(deck2.toText());
		
		//turn script test
//		ArrayList<Integer> rr = new ArrayList<Integer>();
//		rr.add(1); rr.add(2); //rr.add(3); rr.add(4); rr.add(5); rr.add(6); rr.add(7);
//		int ccc = 20;
//		Scanner scanner = new Scanner(System.in);
//		String tempstr;
//		Boolean rev = true;
//		
//		
//		while (ccc > 1) {
//			tempstr = scanner.nextLine();
//			if (!tempstr.isEmpty()){
//				rev = !rev;
//			}
//			if(rev){
//				Collections.rotate(rr, -1);
//			}
//			else if(!rev){
//				Collections.rotate(rr, 1);
//			}
//			System.out.println(rr);
//		}
		
		
//		HumanPlayer player = new HumanPlayer();
//		player.setPlayerDeck(deck);
//		player.checkPlayAbleCard(new Card(CardType.CHANGEROTATION, CardColor.GREEN));
//		player.getUsableDeck().printAllCardInDeck();
		

		System.out.println("");
		
		//----------------------------------------------------------
		GameControl gameControl = new GameControl();
		while(!gameControl.gameSetting()){
			System.out.println("System: ----------Setting again----------");
		}
		

	}

}

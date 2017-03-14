import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	/*** class that manage card more than one 
	 * can be on player hand or deck for game***/
	
	public Deck() {
		super();
	}
	
	
	private ArrayList<Card> cardInDeck = new ArrayList<Card>();
	
	
	public int countCard(){
		return cardInDeck.size();
	}
	
	public Card getCardAt(int index){
		return cardInDeck.get(index);
	}
	
	public Boolean addOneCard(Card card){
		return cardInDeck.add(card);
	}
	
	public Boolean removeOneCard(Card card){    //give card
		if( cardInDeck.isEmpty() ){
			return false;
		}
		else if( cardInDeck.contains(card) ){
			return cardInDeck.remove(card);
		}
		return false;
	}
	
	public Boolean allIsSameNumber() {
		int theSameNumber = cardInDeck.get(0).getNumber();
		for(Card c: cardInDeck){
			if(c.getType() == CardType.NUMBER && c.getNumber() == theSameNumber){
				theSameNumber = c.getNumber();
			}
			else{return false;}
		}
		return true;
	}
	
	public void shuffleCard(int times) {
		for (int i = 0; i < times; i++) {
			Collections.shuffle(cardInDeck, new Random());
		}
		
	}
	
	public void printAllCardInDeck(){
		for (int i = 0; i < countCard(); i++) {
			System.out.print(getCardAt(i).toString());
			System.out.print(", ");
		}
		System.out.println("");
	}
	
	
	
}

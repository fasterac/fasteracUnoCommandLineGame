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
		if(countCard() == 0){
			System.out.print("Deck has: -No card-");
		}
		else{
			System.out.print("Deck has: ");
			for (int i = 0; i < countCard(); i++) {			
				System.out.print(getCardAt(i).toString());
				System.out.print(", ");
			}
		}
		System.out.println("");
	}
	
	public void clearAllCard() {
		cardInDeck.clear();
	}
	
	public Boolean haveCard(Card card){
		return cardInDeck.contains(card);
	}
	
	public String toText(){
		String cardare = "";
		if(countCard() == 0){
			cardare = cardare+"(no card)";
		}
		else{			
			for (int i = 0; i < countCard(); i++) {		
				cardare = cardare+getCardAt(i).toString();
				cardare = cardare+", ";
			}
			cardare = cardare.substring(0, cardare.length()-2);
		}
		return cardare;
	}
	
	public String toChooseText(){
		String cardare = "";
		if(countCard() == 0){
			cardare = cardare+"[0](no card)";
		}
		else{			
			for (int i = 0; i < countCard(); i++) {	
				cardare = cardare+"["+(i+1)+"]";
				cardare = cardare+getCardAt(i).toString();
				cardare = cardare+", ";
			}
			cardare = cardare.substring(0, cardare.length()-2);
		}
		return cardare;
	}
	
	
}

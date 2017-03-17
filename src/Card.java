
public class Card {
	
	private CardType type;
	private CardColor color = CardColor.BlACK;
	private int number = -1;
	
	public Card(CardType type, CardColor color) {
		super();
		this.type = type;
		this.color = color;
		this.number = -1;
	}
	
	public Card(int number, CardColor color) {
		super();
		this.type = CardType.NUMBER;
		this.color = color;
		this.number = number;
	}

	
	public CardType getType() {
		return type;
	}
	public void setType(CardType type) {
		this.type = type;
	}
	public CardColor getColor() {
		return color;
	}
	public void setColor(CardColor color) {
		this.color = color;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String toString(){
		if(this.type == CardType.NUMBER){
			return this.type.getText() + ":" + this.color.getShortText() + this.number;
		}
		else if(this.type == CardType.MULTIPLE2){
			return this.type.getText() + ":" + this.color.getShortText();
		}
		else if(this.type == CardType.MULTIPLE4){
			return this.type.getText();
		}
		else{
			return this.type.getText() + ":" + this.color.getText();
		}
	}

}

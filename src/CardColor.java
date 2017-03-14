
public enum CardColor {
	RED, GREEN, BLUE, YELLOW, BlACK;
	
	String getText(){
		switch (this) {
		case RED: return "red"; 
		case GREEN: return "green";
		case BLUE: return "blue";
		case YELLOW: return "yellow";

		default:return "none";
		}
	}
	
	String getShortText(){
		switch (this) {
		case RED: return "r";
		case GREEN: return "g";
		case BLUE: return "b";
		case YELLOW: return "y";

		default:return "none";
		}
	}
}

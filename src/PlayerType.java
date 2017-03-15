
public enum PlayerType {
	Human, Computer;
	
	String getText(){
		switch (this) {
		case Human: return "Human"; 
		case Computer: return "Computer";

		default:return "none";
		}
	}
}

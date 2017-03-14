
public enum CardType {
	NUMBER, MULTIPLE2, MULTIPLE4, SKIP, CHANGEROTATION;
	
	String getText(){
		switch (this) {
		case NUMBER: return "number"; 
		case MULTIPLE2: return "multiple2";
		case MULTIPLE4: return "multiple4";
		case SKIP: return "skip";
		case CHANGEROTATION: return "changerotation";

		default:return "none";
		}
	}
	
}

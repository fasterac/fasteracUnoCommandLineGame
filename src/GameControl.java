import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameControl {
	
	public GameControl() {
		super();
	}

	ArrayList<Player> allPlayer;
	Deck unuseCard, trashCard;
	Boolean isRotationRight = true;
	Card currentCard, previousPlaceAbleCard;
	int player, complay, humanplay;
	String tempstr;
	
	Scanner scanner = new Scanner(System.in);
	
	public Boolean gameSetting(){
		while(true){
			try{
				System.out.print("How many All player: ");
				player = scanner.nextInt();
				break;
			}catch (InputMismatchException exception) {
				System.err.println("Please enter number");
			}
		}
		
		while(true){
			try{
				System.out.print("How many player want to play with computer: ");
				humanplay = scanner.nextInt();
				if(humanplay > player){
					throw new TooMuchHumanPlayerException();
				}
				break;
			}catch (TooMuchHumanPlayerException e) {
				System.err.println("Human can't be more than all player. Current All Player now:" + player);
			}catch (InputMismatchException exception) {
				System.err.println("Please enter number");
			}
		}
		
		System.out.println("------------------------------");
		System.out.println("Confirm Player--- All player:" + player + ", Human Player:" 
				+ humanplay + ", Computer:" + (player-humanplay));
		System.out.println("PRESS ENTER TO START   or type anything and enter to edit");
		System.out.println("");
		
		tempstr = scanner.nextLine();
		tempstr = scanner.nextLine();
		if (tempstr.isEmpty()){
			return true;
		}
		else{
			return false;
		}
		
		
	}
	

}

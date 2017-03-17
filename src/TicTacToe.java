import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
	public static Board board = new Board();
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int difficulty = Welcome(sc);
		//0 represents human - human game
		if(difficulty == 0){
			humanGame(sc);
		}else{
			AIGame(sc, difficulty);
		}
		sc.close();
	}

	public static int Welcome(Scanner sc) throws InterruptedException{
		int ret = 0;
		System.out.print("Please enter your name, when finished, press enter ");
		//		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Welcome, " + name + ".");
		Thread.sleep(500);
		System.out.print("Please pick the mode: 1 for Human vs AI, 2 for Human vs Human: ");
		if( getNum(2, "mode", sc) == 1 ){
			Thread.sleep(500);		
			System.out.print("Please enter the difficulty level: 1 for easy, 2 for medium"
					+ " and 3 for hard: ");
			ret = getNum(3, "level", sc);
		}else{
			System.out.print("Please enter your name, when finished, press enter ");
			String name2 = sc.nextLine();
			System.out.println("Welcome, " + name2 + ".");
		}
		return ret;
	}	

	public static int getNum(int max, String category, Scanner sc){
		boolean valid = false;
		int number = 0;

		while(!valid){
			if(!sc.hasNextInt()){
				System.out.println(sc.nextLine() 
						+ " is not an integer");
				System.out.println("Please input an integer between 1 and " + max);
			}else{
				number = sc.nextInt();
				if( number < 1 || number > max){
					System.out.println(number + " is not a valid " + category + ".");
					System.out.println("Please input the " + category + " again(The integer should between 1 and " 
							+ max +"): ");

				}else{
					valid = true;
				}
				if(max == 3 && category.equals("level")){
					printDif(number);
				}
			}

		}
		return number;
	}

	public static void printDif(int level){
		if(level == 1){
			System.out.println("You have picked the easy level.");
		}if(level == 2){
			System.out.println("You have picked the medium level.");
		}if(level == 3){
			System.out.println("You have picked the hard level.");
		}
	}

	public static void humanGame(Scanner sc) throws InterruptedException{

		int[] p1Stats = new int[3];
		int[] p2Stats = new int[3];
		Thread.sleep(500);
		System.out.println("Player one, you are assigned checker o");
		Thread.sleep(500);
		System.out.println("Player two, you are assignee checker x");
		Thread.sleep(500);
		board.initialBoard();
		board.printBoard();

		while(!board.finish()&&board.checkWin()==0){
			validInput(1, sc);
			board.printBoard();
			if(board.finish()||board.checkWin()!=0){
				break;
			}
			validInput(2, sc);
			board.printBoard();
		}
		int temp = board.checkWin();
		if(temp !=0){
			System.out.println("Congratulations! player " + temp + " won!");
			if(temp == 1){
				p1Stats[0] ++;
				p2Stats[2] ++;
			}else{
				p1Stats[2] ++;
				p2Stats[0] ++;
			}
		}else{
			System.out.println("The game is a tie.");
			p1Stats[1] ++;
			p2Stats[1] ++;
		}
		System.out.println("Player 1 won: " + p1Stats[0] + "Player 1 tie: " + p1Stats[1] +
				"Player 1 lose: " + p1Stats[2] );
		System.out.println("Player 2 won: " + p1Stats[0] + "Player 2 tie: " + p1Stats[1] +
				"Player 2 lose: " + p1Stats[2] );
	}


	public static void validInput(int player, Scanner sc){
		System.out.print("Player" + player + " ,");
		System.out.print("Please enter rows you want to insert into: ");
		int i = getNum(3, "rows", sc);
		System.out.print("Please enter columns you want to insert into: ");
		int j = getNum(3, "columns", sc);
		while(!board.getVacant(i, j)){
			System.out.println("It is occupied, please enter the coordinate again");
			System.out.print("Please enter rows you want to insert into: ");
			i = getNum(3, "rows", sc);
			System.out.print("Please enter columns you want to insert into: ");
			j = getNum(3, "columns", sc);
		}
		if(player == 1){
			board.setPoint(i, j, 'o');
		}else{
			board.setPoint(i, j, 'x');
		}
	}

	public static void AIGame(Scanner sc, int difficulty) throws InterruptedException{
		Random r = new Random();
		AIPlayer comp = new AIPlayer();

		//Determine which party plays first
		System.out.print("Please determine who goes first: 1 for AI, 2 for you and 3 for random: ");
		int fchoice = getNum(3, "first choice", sc);
		boolean AIfirst = true;
		if(fchoice == 3){
			int temp = r.nextInt(2);
			if( temp == 1){
				System.out.println("Player, you go first");
				AIfirst = false;
			}else{
				System.out.println("I will go first");
			}
		}else if(fchoice == 2){
			System.out.println("Player, you go first");
			AIfirst = false;
		}else{
			System.out.println("I will go first");
		}

		System.out.println("Player, your checker is o");
		board.initialBoard();
		board.printBoard();
		if(!AIfirst){
			//Human plays first
			playerPlay(sc, 'o');			
		}
		while(!board.finish()&&board.checkWin()==0){
			Thread.sleep(500);
			comp.AIPlay(difficulty, board);

			Thread.sleep(500);
			board.printBoard();
			if(board.finish()||board.checkWin()!=0){
				break;
			}
			System.out.println("AI is done for this round");
			//Human plays second
			playerPlay(sc, 'o');
			board.printBoard();
		}
		if(board.finish()){
			System.out.println("The game is a tie");
		}else{
			if(board.checkWin()==1){
				System.out.println("Congratulations, you win");
			}else{
				System.out.println("I win");
			}
		}
	}

	public static void playerPlay(Scanner sc, char checker){
		System.out.println("Player, it is you turn");
		System.out.print("Please enter rows you want to insert into: ");
		int i = getNum(3, "rows", sc);
		System.out.print("Please enter columns you want to insert into: ");
		int j = getNum(3, "columns", sc);
		while(!board.getVacant(i, j)){
			System.out.println("It is occupied, please enter the coordinate again");
			System.out.print("Please enter rows you want to insert into: ");
			i = getNum(3, "rows", sc);
			System.out.print("Please enter columns you want to insert into: ");
			j = getNum(3, "columns", sc);
		}
		board.setPoint(i, j, checker);
	}
}

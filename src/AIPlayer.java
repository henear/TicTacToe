import java.util.Random;
public class AIPlayer {
	int difficulty;
	
	Random r = new Random();
	public void AIPlay(int difficulty, Board board){
		this.difficulty = difficulty;
		
		if(difficulty == 1){
			easyMode(board);
		}else if(difficulty == 2){
			// Check if continuous 2 exists, if yes and next is vacant, take it
			// If not, take a random vacant place
			
			mediumMode(board);
		}else{
			hardMode(board);
		}
	}
	
	public void easyMode(Board board){
		int i = r.nextInt(3)+1;
		int j = r.nextInt(3)+1;
		while(!board.getVacant(i, j)){
			i = r.nextInt(3)+1;
			j = r.nextInt(3)+1;
		}
		board.setPoint(i, j, 'x');
	}

	public void mediumMode(Board board){
		//AIboard = b.board;
		
		boolean temp = medHardHelper(board, 'x');
		if(!temp){
			System.out.println("In 4th block");
			easyMode(board);
		}
	}

	public void hardMode(Board board){
		boolean temp = medHardHelper(board, 'x');
		if(!temp){
			boolean temp2 = medHardHelper(board, 'o');
			if(!temp2){
				mediumMode(board);
			}
		}
	}
	
	public boolean medHardHelper(Board board, char checker){
		boolean temp = false;
		
		for(int i = 0; i < 3; i++){
			System.out.println("In 1 block");
			if(board.getSpecChar(i, 0) == checker && board.getSpecChar(i, 1) == checker && 
					board.getSpecChar(i, 2)== '.'){
				board.setPoint(i+1, 3, 'x');
				temp = true;
				break;
			}
			if(board.getSpecChar(i, 0) == checker && board.getSpecChar(i, 1) == '.' && 
					board.getSpecChar(i, 2)== checker){
				board.setPoint(i+1, 2, 'x');
				temp = true;
				break;
			}
			if(board.getSpecChar(i, 0) == '.' && board.getSpecChar(i, 1) == checker && 
					board.getSpecChar(i, 2)== checker){
				board.setPoint(i+1, 1, 'x');
				temp = true;
				break;
			}
		}
		if(!temp){
			
			for(int i = 0; i < 3; i++){
				System.out.println("In 1 block");
				if(board.getSpecChar(0, i) == checker && board.getSpecChar(1, i) == checker && 
						board.getSpecChar(2, i)== '.'){
					board.setPoint(3, i+1, 'x');
					temp = true;
					break;
				}
				if(board.getSpecChar(0, i) == checker && board.getSpecChar(1, i) == '.' && 
						board.getSpecChar(2, i)== checker){
					board.setPoint(2, i+1, 'x');
					temp = true;
					break;
				}
				if(board.getSpecChar(0, i) == '.' && board.getSpecChar(1, i) == checker && 
						board.getSpecChar(2, i)== checker){
					board.setPoint(1, i+1, 'x');
					temp = true;
					break;
				}
			}
			System.out.println("temp is "+ temp);
		}
		if(!temp){
			System.out.println("In 3 block");
			if(board.getSpecChar(0, 0) == '.' && board.getSpecChar(1, 1) == checker && 
					board.getSpecChar(2, 2)== checker){
				board.setPoint(1, 1, 'x');
				temp = true;
			}
			else if(board.getSpecChar(0, 0) == checker && board.getSpecChar(1, 1) == '.' && 
					board.getSpecChar(2, 2)== checker){
				board.setPoint(2, 2, 'x');
				temp = true;
			}
			else if(board.getSpecChar(0, 0) == checker && board.getSpecChar(1, 1) == checker && 
					board.getSpecChar(2, 2)== '.'){
				board.setPoint(3, 3, 'x');				
				temp = true;
			}
			else if(board.getSpecChar(0, 2) == checker && board.getSpecChar(1, 1) == checker && 
					board.getSpecChar(2, 0)== '.'){
				board.setPoint(3, 1, 'x');
				temp = true;
			}
			else if(board.getSpecChar(0, 2) == checker && board.getSpecChar(1, 1) == '.' && 
					board.getSpecChar(2, 0)== checker){
				board.setPoint(2, 2, 'x');
				temp = true;
			}
			else if(board.getSpecChar(0, 2) == '.' && board.getSpecChar(1, 1) == checker && 
					board.getSpecChar(2, 0)== checker){
				board.setPoint(1, 3, 'x');
				temp = true;
			}
		}
		return temp;
	}
}

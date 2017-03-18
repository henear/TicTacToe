
public class Board {
	public char[][] board = new char[3][3];
	
	public void initialBoard(){
		for(int i = 0; i < 3;i ++){
			for(int j = 0; j < 3; j++){
				board[i][j] = '.';
			}
		}
	}
	
	public void printBoard(){
		System.out.println("Current board is: ");
		for(int i = 0; i < 3;i ++){
			for(int j = 0; j < 3; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void setPoint(int i, int j, char checker){
		board[i-1][j-1] = checker;
	}
	
	public boolean getVacant(int i, int j){
		return board[i-1][j-1] == '.';
	}
	
	public char getSpecChar(int i, int j){
		return board[i][j];
	}
	
	public int checkWin(){
		//Check a row
		if((board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == 'o')
		 ||(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == 'o')
		 ||(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == 'o')){
			return 1;
		}
		else if((board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == 'x')
		||(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == 'x')
		||(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == 'x')){
			return 2;
		}
		//Check a column
		else if((board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == 'o')
		 ||(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == 'o')
		 ||(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == 'o')){
			return 1;
		}
		else if((board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == 'x')
		||(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == 'x')
		||(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == 'x')){
			return 2;
		}
		//Check diagonal
		else if((board[0][0]== board[1][1] && board[1][1]== board[2][2] && board[0][0]== 'o')
		 ||(board[0][2]== board[1][1] && board[1][1]== board[2][0] && board[0][2]== 'o')){
			return 1;
		}
		else if((board[0][0]== board[1][1] && board[1][1]== board[2][2] && board[0][0]== 'x')
		   ||(board[0][2]== board[1][1] && board[1][1]== board[2][0] && board[0][2]== 'x')){
			return 2;
		}else{
			return 0;
		}
	}
	
	public boolean isEmpty(){		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == 'o' || board[i][j] == 'x'){
					return false;
				}
			}
		}
		return true;
	}
	
	public int countVacant(){
		int count = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == '.'){
					count++;
				}
			}
		}
		return count;
	}
	
	public boolean finish(){
		boolean b = true;
		for(int i = 0; i < 3 && b; i++){
			for(int j = 0; j < 3&& b; j++){
				if(board[i][j]=='.'){
					b = false;
					break;
				}
			}
		}
		return b;
	}
}

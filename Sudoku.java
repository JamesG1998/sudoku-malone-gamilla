import java.util.*;

public class Sudoku {
	Scanner keyboard = new Scanner(System.in);
	Random r = new Random();
	int xcurs = 1;
	int ycurs = 2;
	String[][] board = new String[13][13];
	String[][] numbers = new String[9][9];
	boolean[][] edit = new boolean[13][13];
	int rannum = 0;

	public void setNumbersArray(){
		for (int i = 0; i < 9; i++){
      if (i < 3){
        for (int j = 0; j < 3; j++){
  				numbers[i][j] = board[i+1][j+1];
        }
        for (int j = 3; j < 6; j++){
  				numbers[i][j] = board[i+1][j+2];
  			}
        for (int j = 6; j < 9; j++){
  				numbers[i][j] = board[i+1][j+3];
  			}
      }
      else if (i < 6){
        for (int j = 0; j < 3; j++){
          numbers[i][j] = board[i+2][j+1];
        }
        for (int j = 3; j < 6; j++){
          numbers[i][j] = board[i+2][j+2];
        }
        for (int j = 6; j < 9; j++){
          numbers[i][j] = board[i+2][j+3];
        }
      }
      else if (i < 9){
        for (int j = 0; j < 3; j++){
          numbers[i][j] = board[i+3][j+1];
        }
        for (int j = 3; j < 6; j++){
          numbers[i][j] = board[i+3][j+2];
        }
        for (int j = 6; j < 9; j++){
          numbers[i][j] = board[i+3][j+3];
        }
      }
    }
	}

	public void setBlankBoard(){
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j<board.length; j++){
				board[i][j] = " . ";
			}
		}
		for (int i = 0; i<board.length; i+=4){
			for (int j = 0; j<board.length; j++){
				board[j][i] = " | ";
				edit[j][i] = false;
				board[i][j] = "---";
				edit[i][j] = false;
				if((i!=0||i!=13)&&(j!=0||j!=13)&&j%4==0){
					board[i][j]=" + ";
					board[j][i]=" + ";
				}
			}
		}
    this.setNumbersArray();
	}

	public int getRandomNumber(){
		return r.nextInt(9)+1;
	}

	public void setRandBoard(int diff){
		for (int d = 0; d<=diff; d++){


		}
	}

	public void printBoard(){
		for (int i = 0; i<board.length; i++){
			for (int j = 0; j<board.length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public void printCoord(int x, int y){
		System.out.print(x + "," + y);
		System.out.println(" board:"+board[y][x]);
	}

	public boolean isBlank(int x, int y){
		if (board[y][x] == " . "||board[y][x]=="< >")
			return true;
		else{
			return false;
		}
	}

	public boolean cursorIsBlank(){
		return isBlank(xcurs,ycurs);
	}

	public void setBoard(String s){
		board[ycurs][xcurs] = s;
	}

	public void readInput(){
		String input = "";
		char c;
		do{
			do{
				System.out.print("input:");
				input = keyboard.nextLine();
			}while(input.length()==0);
			c = input.charAt(0);
		}while(!(c>='1'&&c<='9')&&!(c=='w'||c=='a'||c=='s'||c=='d'));
		if((c>='1')&&(c<='9')){
			setBoard(" "+input+" ");
			System.out.println("65");
		}
		else if(c=='w'||c=='a'||c=='s'||c=='d'){
			moveCursor(c);
		}
		else{
			System.out.println("71");
		}
	}

	public void moveCursor(char c){
		if(cursorIsBlank()){
			setBoard(" . ");
		}
		switch(c){
			case 's': ycurs++;
				while (!cursorIsBlank()){
					ycurs++;} break;
			case 'a': xcurs--;
				while (!cursorIsBlank()){
					xcurs--;} break;
			case 'w': ycurs--;
				while (!cursorIsBlank()){
					ycurs--;} break;
			case 'd': xcurs++;
				while (!cursorIsBlank()){
					xcurs++;} break;
		}
		setBoard("< >");
	}



	public static void main(String[] args){
		Sudoku test = new Sudoku();
		test.setBlankBoard();
		test.setNumbersArray();
		for (int i = 0; i < test.numbers.length; i++){
			for (int j = 0; j < test.numbers.length; j++){
				System.out.print(test.numbers[i][j]);
			}
		System.out.println();
		}
		test.printBoard();
		do{
			test.readInput();
			test.printBoard();
		}while(true);
	}
}

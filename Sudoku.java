import java.util.*;
import java.io.*;

public class Sudoku {
	Scanner keyboard = new Scanner(System.in);
	Random r = new Random();
	private int xCurs;
	private int yCurs;
	private int[][] logic;
	private String[][] board;
	private boolean[][] edit;
	private final int[] SOLVE = {1, 2, 3, 4, 5, 6, 7, 8, 9};


	public Sudoku(){
		xCurs = 4;
		yCurs = 4;
		logic = new int[9][9]; //Creates a 9x9 in[][] of 0s.
		/*{
			{1, 2, 3, 4, 5, 6, 7, 8, 9},
			{7, 8, 9, 1, 2, 3, 4, 5, 6},
			{4, 5, 6, 7, 8, 9, 1, 2, 3},
			{9, 1, 2, 3, 4, 5, 6, 7, 8},
			{6, 7, 8, 9, 1, 2, 3, 4, 5},
			{3, 4, 5, 6, 7, 8, 9, 1, 2},
			{8, 9, 1, 2, 3, 4, 5, 6, 7},
			{5, 6, 7, 8, 9, 1, 2, 3, 4},
			{2, 3, 4, 5, 6, 7, 8, 9, 1}
		};*/
		edit = new boolean[9][9];
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9;j++){
				edit[i][j] = true;
			}
		}
		board = new String[13][13];
		for (int i = 0; i < 9; i++){
      if (i < 3){
        for (int j = 0; j < 3; j++){
  				board[i+1][j+1] = " " + logic[i][j] + " ";
        }
        for (int j = 3; j < 6; j++){
  				board[i+1][j+2] = " " + logic[i][j] + " ";
  			}
        for (int j = 6; j < 9; j++){
  				board[i+1][j+3] = " " + logic[i][j] + " ";
  			}
      }
      else if (i < 6){
        for (int j = 0; j < 3; j++){
          board[i+2][j+1] = " " + logic[i][j] + " ";
        }
        for (int j = 3; j < 6; j++){
          board[i+2][j+2] = " " + logic[i][j] + " ";
        }
        for (int j = 6; j < 9; j++){
          board[i+2][j+3] = " " + logic[i][j] + " ";
        }
      }
      else if (i < 9){
        for (int j = 0; j < 3; j++){
          board[i+3][j+1] = " " + logic[i][j] + " ";
        }
        for (int j = 3; j < 6; j++){
          board[i+3][j+2] = " " + logic[i][j] + " ";
        }
        for (int j = 6; j < 9; j++){
          board[i+3][j+3] = " " + logic[i][j] + " ";
        }
      }
    }
		for (int i = 0; i < board.length; i += 4){
			for (int j = 0; j < board.length; j++){
				board[j][i] = " | ";
				board[i][j] = "---";
				if((i != 0 || i != 13) && (j != 0 || j != 13) && (j % 4 == 0)){
					board[i][j]=" + ";
					board[j][i]=" + ";
				}
			}
		}
	}

	//"Clears" the screen by printing 100 empty lines.
	public final static void clear(){
		String repeat = new String(new char[100]).replace("", "\n");
		System.out.println(repeat);
	}
	//Updates the Board String[][] with information from Logic int[][].
	public void syncLogicToBoard(){
		for (int i = 0; i < 9; i++){
      if (i < 3){
        for (int j = 0; j < 3; j++){
  				board[i+1][j+1] = " " + logic[i][j] + " ";
        }
        for (int j = 3; j < 6; j++){
  				board[i+1][j+2] = " " + logic[i][j] + " ";
  			}
        for (int j = 6; j < 9; j++){
  				board[i+1][j+3] = " " + logic[i][j] + " ";
  			}
      }
      else if (i < 6){
        for (int j = 0; j < 3; j++){
          board[i+2][j+1] = " " + logic[i][j] + " ";
        }
        for (int j = 3; j < 6; j++){
          board[i+2][j+2] = " " + logic[i][j] + " ";
        }
        for (int j = 6; j < 9; j++){
          board[i+2][j+3] = " " + logic[i][j] + " ";
        }
      }
      else if (i < 9){
        for (int j = 0; j < 3; j++){
          board[i+3][j+1] = " " + logic[i][j] + " ";
        }
        for (int j = 3; j < 6; j++){
          board[i+3][j+2] = " " + logic[i][j] + " ";
        }
        for (int j = 6; j < 9; j++){
          board[i+3][j+3] = " " + logic[i][j] + " ";
        }
      }
    }
	}
	//Updates the Logic int[][] with information from Board String[][].
	public void syncBoardToLogic(){
		for (int i = 0; i < 9; i++){
      if (i < 3){
        for (int j = 0; j < 3; j++){
  				logic[i][j] = board[i+1][j+1].charAt(1);
        }
        for (int j = 3; j < 6; j++){
  				logic[i][j] = board[i+1][j+2].charAt(1);
  			}
        for (int j = 6; j < 9; j++){
  				logic[i][j] = board[i+1][j+3].charAt(1);
  			}
      }
      else if (i < 6){
        for (int j = 0; j < 3; j++){
          logic[i][j] = board[i+2][j+1].charAt(1);
        }
        for (int j = 3; j < 6; j++){
          logic[i][j] = board[i+2][j+2].charAt(1);
        }
        for (int j = 6; j < 9; j++){
          logic[i][j] = board[i+2][j+3].charAt(1);
        }
      }
      else if (i < 9){
        for (int j = 0; j < 3; j++){
          logic[i][j] = board[i+3][j+1].charAt(1);
        }
        for (int j = 3; j < 6; j++){
          logic[i][j] = board[i+3][j+2].charAt(1);
        }
        for (int j = 6; j < 9; j++){
          logic[i][j] = board[i+3][j+3].charAt(1);
        }
      }
    }
	}
	//Returns a boolean dependant on the numbers int[][] being solved or not.
	public boolean isSolved(){
		int i, j, x, y, count;
		boolean isSolved = true;
		//The following checks if all rows are correct.
		for (i = 0; i < logic.length; i++){
			int[] row = new int[9];
			for (j = 0; j < logic.length; j++){
				row[j] = logic[i][j];
			}
			Arrays.sort(row);
			if (!Arrays.equals(SOLVE, row)) isSolved = false;
		}
		//The following checks if all columns are correct.
		for (i = 0; i < logic.length; i++){
			int[] column = new int[9];
			for (j = 0; j< logic.length; j++){
				column[j] = logic[j][i];
			}
			Arrays.sort(column);
			if (!Arrays.equals(SOLVE, column)) isSolved = false;
		}
		//The following checks if all 3x3 boxes are correct.
		int[] box = new int[9];
		for (i = 0; i < logic.length; i += 3){
			for (j = 0; j < logic.length; j += 3){
				count = 0;
				for (x = i; x < 3; x++){
					for (y = j; y < 3; y++){
						box[count] = logic[x][y];
						count++;
					}
				}
			Arrays.sort(box);
			if (!Arrays.equals(SOLVE, box)) isSolved = false;
			}
		}
		return isSolved;
	}
	//Retrieves a from Puzzle.class with puzzle number "puzzleNumber".
	public void newPuzzle(int puzzleNumber) throws IOException{
		Puzzle newPuzzle = new Puzzle(puzzleNumber);
		newPuzzle.readFile();
		int[][] puzzle = newPuzzle.getPuzzle();
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				logic[i][j] = puzzle[i][j];
			}
		}
	}

	public void setBlankBoard(){
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				board[i][j] = " . ";
			}
		}
		for (int i = 0; i < board.length; i += 4){
			for (int j = 0; j < board.length; j++){
				board[j][i] = " | ";
				edit[j][i] = false;
				board[i][j] = "---";
				edit[i][j] = false;
				if((i != 0 || i != 13) && (j != 0 || j != 13) && (j % 4 == 0)){
					board[i][j]=" + ";
					board[j][i]=" + ";
				}
			}
		}
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

	public void printCoord(int x,  int y){
		System.out.print(x + ", " + y);
		System.out.println(" board:"+board[y][x]);
	}

	public boolean isBlank(int x,  int y){
		if (board[y][x] == " . "||board[y][x]=="< >")
			return true;
		else{
			return false;
		}
	}

	public boolean cursorIsBlank(){
		return isBlank(xCurs, yCurs);
	}

	public void setBoard(String s){
		board[yCurs][xCurs] = s;
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
			case 's': yCurs++;
				while (!cursorIsBlank()){
					yCurs++;} break;
			case 'a': xCurs--;
				while (!cursorIsBlank()){
					xCurs--;} break;
			case 'w': yCurs--;
				while (!cursorIsBlank()){
					yCurs--;} break;
			case 'd': xCurs++;
				while (!cursorIsBlank()){
					xCurs++;} break;
		}
		setBoard("< >");
	}

	public static void main(String[] args) throws IOException{
		Sudoku test = new Sudoku();
		test.newPuzzle(1);
		test.syncLogicToBoard();
		for (int i = 0; i < test.board.length; i++){
			for (int j = 0; j < test.board.length; j++){
				System.out.print(test.board[i][j]);
			}
			System.out.println();
		}
		System.out.println("isSolved() = " + test.isSolved());
	}
}

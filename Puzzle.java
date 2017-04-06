import java.util.*;
import java.io.*;

public class Puzzle{
  private int puzzleNumber = 1;
  private int[][] puzzle = new int[9][9];

  public Puzzle(int puzzleNumber){
    this.puzzleNumber = puzzleNumber;
  }

  public int[][] getPuzzle(){
    return puzzle;
  }

  public void readFile() throws IOException{
    String puzzleFile = "puzzle1.txt";
    switch (puzzleNumber){
      case 1:
        puzzleFile = "puzzle1.txt";
        break;
      case 2:
        puzzleFile = "puzzle2.txt";
    }
    File inFile = new File(puzzleFile);
    if (!inFile.exists()){
      System.out.println("Error: Couldn't find " + puzzleFile + "!");
      System.exit(0);
    }
    Scanner inStream = new Scanner(inFile);
    while (inStream.hasNextInt()){
      for (int i = 0; i < puzzle.length; i++){
        for (int j = 0; j < puzzle.length; j++){
          puzzle[i][j] = inStream.nextInt();
        }
      }
    }
  }
}

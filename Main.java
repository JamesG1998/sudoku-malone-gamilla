import java.util.*;
import java.io.*;

public class Main{

  public static void menu() throws IOException{
    clear();
    System.out.println("+-------------------------------+");
    System.out.println("|             SUDOKU            |");
    System.out.println("| Marina Malone & James Gamilla |");
    System.out.println("|              v1.0             |");
    System.out.println("+-------------------------------+");
    System.out.println();
    System.out.println("[1] Play Levels");
    System.out.println("[2] Freeplay");
    System.out.println("[3] Help");
    System.out.println("[4] Quit");
    switch (input()){
      case "1":
        playLevels();
        break;
      case "2":
        freeplay();
        break;
      case "3":
        help();
        break;
      case "4":
        System.exit(0);
      default:
        menu();
    }
  }

  public static void playLevels() throws IOException{
    clear();
    System.out.println("[1] Easy Levels");
    System.out.println("[2] Medium Levels");
    System.out.println("[3] Hard Levels");
    System.out.println("[4] Go Back");
    switch (input()){
      case "1":
        easyLevels();
        break;
      case "2":
        mediumLevels();
        break;
      case "3":
        hardLevels();
        break;
      case "4":
        menu();
        break;
      default:
        playLevels();
    }
  }

  public static void easyLevels() throws IOException{
    clear();
    Sudoku puzzle = new Sudoku();
    System.out.println("[1] Easy 1");
    System.out.println("[2] Easy 2");
    System.out.println("[3] Easy 3 *Not Available*");
    System.out.println("[4] Go Back");
    switch (input()){
      case "1":
        puzzle.playLevel(1);
        break;
      case "2":
        puzzle.playLevel(2);
        break;
      case "3":
        easyLevels();
        break;
      case "4":
        playLevels();
        break;
      default:
        easyLevels();
    }
  }

  public static void mediumLevels() throws IOException{
    clear();
    System.out.println("[1] Medium 1 *Not Available*");
    System.out.println("[2] Medium 2 *Not Available*");
    System.out.println("[3] Medium 3 *Not Available*");
    System.out.println("[4] Go Back");
    switch (input()){
      case "1":
        mediumLevels();
        break;
      case "2":
        mediumLevels();
        break;
      case "3":
        mediumLevels();
        break;
      case "4":
        playLevels();
        break;
      default:
        mediumLevels();
    }
  }

  public static void hardLevels() throws IOException{
    clear();
    System.out.println("[1] Hard 1 *Not Available*");
    System.out.println("[2] Hard 2 *Not Available*");
    System.out.println("[3] Hard 3 *Not Available*");
    System.out.println("[4] Go Back");
    switch (input()){
      case "1":
        hardLevels();
        break;
      case "2":
        hardLevels();
        break;
      case "3":
        hardLevels();
        break;
      case "4":
        playLevels();
        break;
      default:
        hardLevels();
    }
  }

  public static void freeplay() throws IOException{
    clear();
    Sudoku puzzle = new Sudoku();
    System.out.println("[1] Start Freeplay");
    System.out.println("[2] Go Back");
    switch (input()){
      case "1":
        clear();
        System.out.println("How many clues would you like (Between 17 and 80)?");
        int response = Integer.parseInt(input());
        puzzle.playFreeplay(response);
        break;
      case "2":
        menu();
        break;
      default:
        freeplay();
    }
  }

  public static void help() throws IOException{
    clear();
    System.out.println("Controls:");
    System.out.println("  W = Up       S = Down");
    System.out.println("  A = Left     D = Right");
    System.out.println("  Enter 1 - 9 to input number.");
    System.out.println("  Enter \"Menu\" to go back to menu.");
    System.out.println("  Enter \"Quit\" to exit Sudoku.");
    System.out.println();
    System.out.println("[1] Go Back");
    switch (input()){
      case "1":
        menu();
        break;
      default:
        help();
    }
  }

  public static String input(){
    Scanner input = new Scanner(System.in);
    String output = input.nextLine();
    return output;
  }

  public final static void clear(){
		String repeat = new String(new char[100]).replace("", "\n");
		System.out.println(repeat);
	}


  public static void main(String[] args) throws IOException{
    menu();
  }
}

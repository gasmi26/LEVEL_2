import java.util.Scanner;

public class Level2_Task1 {

  private char[][] boardofgame;
  private char currentPlayer;

  public Level2_Task1() {
    this.boardofgame = new char[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        this.boardofgame[i][j] = ' ';
      }
    }
    this.currentPlayer = 'X';
  }

  public void printBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(this.boardofgame[i][j] + " | ");
      }
      System.out.println();
      if (i < 2) {
        System.out.println("---.---.---");
      }
    }
  }

  public boolean isValidMove(int row, int col) {
    return this.boardofgame[row][col] == ' ';
  }

  public boolean makeMove(int row, int col) {
    if (this.isValidMove(row, col)) {
      this.boardofgame[row][col] = this.currentPlayer;
      return true;
    }
    return false;
  }

  public boolean checkWin() {
   
    for (int i = 0; i < 3; i++) {
      if (this.boardofgame[i][0] != ' ' && this.boardofgame[i][0] == this.boardofgame[i][1] && this.boardofgame[i][0] == this.boardofgame[i][2]) {
        return true;
      }
    }
 
    for (int i = 0; i < 3; i++) {
      if (this.boardofgame[0][i] != ' ' && this.boardofgame[0][i] == this.boardofgame[1][i] && this.boardofgame[0][i] == this.boardofgame[2][i]) {
        return true;
      }
    }
 
    if ((this.boardofgame[0][0] != ' ' && this.boardofgame[0][0] == this.boardofgame[1][1] && this.boardofgame[0][0] == this.boardofgame[2][2]) ||
        (this.boardofgame[0][2] != ' ' && this.boardofgame[0][2] == this.boardofgame[1][1] && this.boardofgame[0][2] == this.boardofgame[2][0])) {
      return true;
    }
    return false;
  }

  public boolean checkTie() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (this.boardofgame[i][j] == ' ') {
          return false;
        }
      }
    }
    return true;
  }

  public void playGame() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      this.printBoard();
      System.out.println("Player " + this.currentPlayer + "'s turn. Enter row and column (0-2) or -1 to exit:");
      int row = scanner.nextInt();
      if (row == -1) {
        System.out.println("Exiting the game...");
        System.exit(0);
      }
      int col = scanner.nextInt();
      if (col == -1) {
        System.out.println("Exiting the game...");
        System.exit(0);
      }
      if (this.makeMove(row, col)) {
        if (this.checkWin()) {
          this.printBoard();
          System.out.println("Player " + this.currentPlayer + " wins!");
          break;
        } else if (this.checkTie()) {
          this.printBoard();
          System.out.println("It's a tie!");
          break;
        }
        this.currentPlayer = this.currentPlayer == 'X' ? 'O' : 'X';
      } else {
        System.out.println("Invalid move, try again.");
      }
    }
    scanner.close();
  }

  public static void main(String[] args) {
    Level2_Task1 game = new Level2_Task1();
    game.playGame();
  }
}

package cs5004.tictactoe;

import java.io.IOException;
import java.util.Scanner;

public class TicTacToeConsoleController implements TicTacToeController {

  private Readable in;
  private Appendable out;

  public TicTacToeConsoleController(Readable r, Appendable a) {
    this.in = r;
    this.out = a;
  }

  @Override
  public void playGame(TicTacToe m) {

    Scanner s = new Scanner(this.in);
    boolean gameQuit = false;
    boolean badInput = false;
    while (!m.isGameOver()) {

      if (!badInput) {
        try {
          this.out.append(m.toString() + "\n");
        } catch (IOException e) {
          throw new IllegalStateException("Error when outputing current game state");
        }

        try {
          this.out.append("Enter a move for " + m.getTurn().toString() + ":\n");
        } catch (IOException e) {
          throw new IllegalStateException("Error when prompting the user for input ");
        }
      }

      badInput = false;
      String firstInput = "";
      if (s.hasNext()) {
        firstInput = s.next();
      }
      if (firstInput.toLowerCase().equals("q")) {
        gameQuit = true;
        break;
      }

      String secondInput = "";
      if (s.hasNext()) {
        secondInput = s.next();
      }
      if (secondInput.toLowerCase().equals("q")) {
        gameQuit = true;
        break;
      }

      if ((!firstInput.equals("1") && !firstInput.equals("2") && !firstInput.equals("3"))
          || (!secondInput.equals("1") && !secondInput.equals("2") && !secondInput.equals("3"))) {
        badInput = true;
      }

      if (badInput) {
        try {
          this.out.append("Input must consist of two integers between 1 and 3 ro q.\n");
        } catch (IOException e) {
          throw new IllegalStateException("Error when informing user that bad input was given");
        }
        continue;
      }

      try {
        m.move(Integer.parseInt(firstInput) - 1, Integer.parseInt(secondInput) - 1);
      } catch (IllegalArgumentException e) {
        badInput = true;
        try {
          this.out.append("That position is already occupied.\n");
        } catch (IOException e2) {
          throw new IllegalStateException("Error when informing user that space was occupied");
        }
      }

    }

    // when the game was quit or game is over
    s.close();
    if (gameQuit) {
      try {
        this.out.append("Game quit! Ending game state:\n" + m.toString() + "\n");
      } catch (IOException e) {
        throw new IllegalStateException("Error when giving quit state");
      }
    } else {
//      try {
//        this.out.append(m.toString() + "\n");
//        this.out.append("Game is over! ");
//        if (m.getWinner() == Player.X) {
//          this.out.append("X Wins.");
//        } else if (m.getWinner() == Player.O) {
//          this.out.append("O Wins.");
//        } else {
//          this.out.append("Tie game.");
//        }
//      } catch (IOException e) {
//        e.printStackTrace();
//      }

      String outString = "";
      outString += m.toString() + "\n";
      outString += "Game is over! ";
      if (m.getWinner() == Player.X) {
        outString += "X Wins.";
      } else if (m.getWinner() == Player.O) {
        outString += "O Wins.";
      } else {
        outString += "Tie game.";
      }

      try {
        this.out.append(outString);
      } catch (IOException e) {
        throw new IllegalStateException("Error when giving game over game sate");
      }
    }
  }

}

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
    try {
      this.out.append("Hello World.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }

    Scanner s = new Scanner(this.in);
    boolean firstTime = true;

    while (s.hasNext()) {
      if (firstTime) {
        try {
          this.out.append("You input: ");
        } catch (IOException e) {
          s.close();
          return;
        }
        firstTime = false;
      }

      String myInput = s.next();

      try {
        this.out.append("You input: " + myInput + "\n");
      } catch (IOException e) {
        s.close();
        return;
      }
    }

    s.close();
  }

}

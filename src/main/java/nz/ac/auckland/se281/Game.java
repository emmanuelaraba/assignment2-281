package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  public static int roundNumber = 1;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]); // prints options[0] as the player name
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));
    roundNumber++; // increment round number by 1

    MessageCli.ASK_INPUT.printMessage(); // prints "Give <fingers> and press enter"
    String inputFingers = Utils.scanner.nextLine(); // reads input from the user

    // if the input is not a number between 0 and 5, print "Error! Invalid input, you should give
    // one integer number between 0 and 5 (inclusive), please try again"
    while (!inputFingers.matches("[0-5]")) {
      MessageCli.INVALID_INPUT.printMessage();
      inputFingers = Utils.scanner.nextLine();
    }

    MessageCli.PRINT_INFO_HAND.printMessage(
        "1", inputFingers); // prints "Player 1: fingers: <input>"
  }

  public void endGame() {}

  public void showStats() {}
}

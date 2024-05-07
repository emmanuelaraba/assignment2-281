package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  public static int roundNumber = 1;
  public static String playerName;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]); // prints options[0] as the player name
    Game.playerName = options[0];
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));

    MessageCli.ASK_INPUT.printMessage();
    String inputFingers = Utils.scanner.nextLine(); // reads input from the user

    // if the input is not a number between 0 and 5, print error message and prompt again
    int InputFingersInt = Integer.parseInt(inputFingers);

    while (InputFingersInt < 0 || InputFingersInt > 5) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      inputFingers = Utils.scanner.nextLine();
      InputFingersInt = Integer.parseInt(inputFingers);
    }

    MessageCli.PRINT_INFO_HAND.printMessage(
        playerName, inputFingers); // prints the player name and the number of fingers
    roundNumber++; // increments the round number
  }

  public void endGame() {}

  public void showStats() {}
}

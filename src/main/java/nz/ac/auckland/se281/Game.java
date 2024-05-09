package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int roundNumber = 1;
  private String playerName;
  private Bot bot; // Bot object
  private String choice; // choice of the player (EVEN or ODD)

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]); // prints options[0] as the player name
    this.playerName = options[0];
    this.bot = BotFactory.makeBot(difficulty); // creates a new bot
    this.choice = choice.toString(); // sets the choice

    roundNumber = 1; // resets the round number
  }

  public void getWinner(int botMove) {}

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

    // checks the

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, inputFingers);
    roundNumber++;
  }

  public void endGame() {}

  public void showStats() {}
}

package nz.ac.auckland.se281;

import java.util.*;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int roundNumber;
  private String playerName;
  private Bot bot; // Bot object
  private Choice playerChoice; // choice of the player (EVEN or ODD)
  private String inputFingers; // input from the player
  final String computerName = "HAL-9000"; // name of the computer bot "HAL 9000
  private ArrayList<Integer> playerFingersList = new ArrayList<Integer>();
  private Stats stats;
  private boolean gameStarted = false;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]); // prints options[0] as the player name
    this.playerName = options[0];
    this.playerChoice = choice; // sets the choice
    roundNumber = 1; // resets the round number
    this.stats = new Stats(playerFingersList, playerChoice);
    this.bot = BotFactory.makeBot(difficulty, stats);
    gameStarted = true;
  }

  /**
   * This method calculates the sum of the player's input and the bot's move and checks if it is
   * even or odd. It then prints the outcome of the round.
   *
   * @param botMove the bot's move, as an integer
   */
  public void getWinner(int botMove) {
    int inputFingersInt = Integer.parseInt(inputFingers);
    int sum = inputFingersInt + botMove;

    if (sum % 2 == 0) {
      if (playerChoice == Choice.EVEN) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", playerName);
        stats.setLastWin(false);
        stats.incrementPlayerWins();
      } else if (playerChoice == Choice.ODD) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", computerName);
        stats.setLastWin(true);
        stats.incrementBotWins();
      }
    } else {
      if (playerChoice == Choice.ODD) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", playerName);
        stats.setLastWin(false);
        stats.incrementPlayerWins();
      } else if (playerChoice == Choice.EVEN) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", computerName);
        stats.setLastWin(true);
        stats.incrementBotWins();
      }
    }
  }

  /**
   * This method checks if the player's input is a number between 0 and 5. If it is not, it prompts
   * the player to enter a valid input.
   */
  public void checkInput() {
    int playerFingers = Integer.parseInt(inputFingers);

    while (playerFingers < 0 || playerFingers > 5) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      inputFingers = Utils.scanner.nextLine();
      playerFingers = Integer.parseInt(inputFingers);
    }
  }

  /**
   * This method finds the number of odd numbers in the player's input and sets the odd count in the
   */
  public void findOddCount() {
    int count = 0;
    for (Integer integer : playerFingersList) {
      if (Utils.isOdd(integer)) {
        count++;
      }
    }
    stats.setOddCount(count);
  }

  /**
   * This method finds the number of even numbers in the player's input and sets the even count in
   * the stats object.
   */
  public void findEvenCount() {
    int count = 0;
    for (Integer integer : playerFingersList) {
      if (Utils.isEven(integer)) {
        count++;
      }
    }
    stats.setEvenCount(count);
  }

  public void play() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // welcomes player to the game \
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));

    // asks the player for input
    MessageCli.ASK_INPUT.printMessage();
    inputFingers = Utils.scanner.nextLine(); // reads input from the user
    playerFingersList.add(Integer.parseInt(inputFingers));

    int botMove = bot.returnMove();
    String botMoveString = Integer.toString(botMove);

    checkInput(); // checks if the input is valid
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, inputFingers);
    MessageCli.PRINT_INFO_HAND.printMessage(computerName, botMoveString);

    // find the winner by using the bot's move
    getWinner(botMove);
    roundNumber++;
    stats.incrementRoundNumber();
    findOddCount();
    findEvenCount();
  }

  public void endGame() {
    if (stats.getBotWins() > stats.getPlayerWins()) {
      MessageCli.PRINT_END_GAME.printMessage(computerName);
    } else if (stats.getBotWins() < stats.getPlayerWins()) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    gameStarted = false;
  }

  public void showStats() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, Integer.toString(stats.getPlayerWins()), Integer.toString(stats.getBotWins()));

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        computerName,
        Integer.toString(stats.getBotWins()),
        Integer.toString(stats.getPlayerWins()));
  }
}

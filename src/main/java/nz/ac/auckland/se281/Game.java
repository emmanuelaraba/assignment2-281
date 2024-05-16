package nz.ac.auckland.se281;

import java.util.ArrayList;
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

  /**
   * This method starts a new game by setting the player's name, choice, and difficulty level. It
   * also resets the round number and initializes the stats object.
   *
   * @param difficulty the difficulty level of the bot
   * @param choice the choice of the player (EVEN or ODD)
   * @param options the player's name
   */
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
    // parse the player's input to an integer
    int inputFingersInt = Integer.parseInt(inputFingers);
    int sum = inputFingersInt + botMove;

    if (sum % 2 == 0) { // if we have an even sum
      if (playerChoice == Choice.EVEN) {
        // declre the player as the winner if the player's choice is EVEN
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", playerName);
        // set the last bot win to false
        stats.setLastWin(false);
        // increment the number of player wins by 1
        stats.incrementPlayerWins();
      } else if (playerChoice == Choice.ODD) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", computerName);
        stats.setLastWin(true);
        stats.incrementBotWins();
      }
    } else { // if we have an odd sum
      if (playerChoice == Choice.ODD) {
        // declare the player as the winner if the player's choice is ODD
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", playerName);
        // set last bot win to false
        stats.setLastWin(false);
        // increment the number of player wins by 1
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
    // check if the input is a number and not a string
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
   * stats object.
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

  /**
   * This method plays a round of the game. It asks the player for input, gets the bot's move, and
   * calculates the winner.
   */
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
    try {
      Integer.parseInt(inputFingers);
    } catch (NumberFormatException e) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      return;
    }

    playerFingersList.add(Integer.parseInt(inputFingers));

    int botMove = bot.returnMove();
    String botMoveString = Integer.toString(botMove);

    checkInput(); // checks if the input is valid
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, inputFingers);
    MessageCli.PRINT_INFO_HAND.printMessage(computerName, botMoveString);

    // find the winner by using the bot's move
    getWinner(botMove);
    // increment the round number
    roundNumber++;
    // increment the round number in the stats object
    stats.incrementRoundNumber();
    // find the odd finger count and the even finger count
    findOddCount();
    findEvenCount();
  }

  /** This method ends the game and prints the winner of the game. */
  public void endGame() {
    // if the game has not started, print an error message
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // checking which player has more wins
    if (stats.getBotWins() > stats.getPlayerWins()) {
      MessageCli.PRINT_END_GAME.printMessage(computerName);
    } else if (stats.getBotWins() < stats.getPlayerWins()) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    gameStarted = false;
  }

  /** This method prints the number of rounds won by the player and the bot. */
  public void showStats() {
    // if the game has not started, print an error message
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // prints the number of rounds won by the player
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, Integer.toString(stats.getPlayerWins()), Integer.toString(stats.getBotWins()));

    // prints the number of rounds won by the bot
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        computerName,
        Integer.toString(stats.getBotWins()),
        Integer.toString(stats.getPlayerWins()));
  }
}

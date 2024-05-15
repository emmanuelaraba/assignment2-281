package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/**
 * This class represents the BotFactory class which is used to create a bot based on the difficulty
 */
public class BotFactory {
  /**
   * Factory method to create a bot based on the difficulty level.
   *
   * @param difficulty - the difficulty choice from the player input
   * @param stats - the stats class which contains the statistics for the round we are in
   * @return Bot - the bot of the difficulty of our choosing
   */
  public static Bot makeBot(Difficulty difficulty, Stats stats) {
    // bot factory method using factory pattern
    // create a bot based on the difficulty level
    switch (difficulty) {
      case EASY:
        return new EasyBot();
      case MEDIUM:
        return new MediumBot(stats);
      case HARD:
        return new HardBot(stats);
      default:
        MessageCli.INVALID_DIFFICULTY.printMessage();
    }
    return null;
  }
}

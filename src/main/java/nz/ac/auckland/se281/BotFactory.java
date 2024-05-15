package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/**
 * This class represents the BotFactory class which is used to create a bot based on the difficulty
 */
public class BotFactory {
  /**
   * Factory method to create a bot based on the difficulty level.
   *
   * @param difficulty
   * @param stats
   * @return
   */
  public static Bot makeBot(Difficulty difficulty, Stats stats) {
    // bot factory method using factory pattern

    switch (difficulty) {
        // create a bot based on the difficulty level
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

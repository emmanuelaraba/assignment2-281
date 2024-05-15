package nz.ac.auckland.se281;

/**
 * This class represents the Strategy interface which is used to implement the strategy pattern for
 * the bot classes.
 */
public interface Strategy {
  /**
   * @return the integer guess that the bot will make
   */
  public int chooseMove(); // choosing the move to be made
}

package nz.ac.auckland.se281;

/** Strategy */
public interface Strategy {
  /**
   * @returns the integer guess that the bot will make
   */
  public int chooseMove(); // choosing the move to be made
}

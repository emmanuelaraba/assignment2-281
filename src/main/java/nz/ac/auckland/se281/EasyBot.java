package nz.ac.auckland.se281;

/** This class represents the EasyBot class which implements the Bot interface. */
public class EasyBot implements Bot {
  private Strategy strategy;

  /** This method chooses the strategy for the bot. */
  @Override
  public void chooseStrat() {
    // generates a random number between 0 and 5
    strategy = new RandomStrat();
  }

  /**
   * This method returns the move based on the strategy chosen.
   *
   * @return the move based on the strategy chosen
   */
  @Override
  public int returnMove() {
    chooseStrat(); // initialize strategy if it's null
    return strategy.chooseMove();
  }
}

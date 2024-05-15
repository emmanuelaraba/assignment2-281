package nz.ac.auckland.se281;

/** This class represents the MediumBot class which implements the Bot interface. */
public class MediumBot implements Bot {

  private Stats stats;
  private Strategy strategy;

  public MediumBot(Stats stats) {
    this.stats = stats;
  }

  /** This method chooses the strategy for the bot. */
  @Override
  public void chooseStrat() {
    if (stats.getRoundNumber() >= 3) {
      strategy = new TopStrat(stats);
    } else {
      strategy = new RandomStrat();
    }
  }

  /**
   * This method returns the move based on the strategy chosen.
   *
   * @return the move based on the strategy chosen
   */
  @Override
  public int returnMove() {
    chooseStrat();
    return strategy.chooseMove();
  }
}

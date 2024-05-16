package nz.ac.auckland.se281;

/** This class represents the HardBot class which implements the Bot interface. */
public class HardBot implements Bot {
  private Stats stats;
  private Strategy strategy;

  public HardBot(Stats stats) {
    this.stats = stats;
  }

  /** This method chooses the strategy for the bot. */
  @Override
  public void chooseStrat() {
    // if the round number is greater than or equal to 3, use the top strategy
    if (stats.getRoundNumber() < 3) {
      strategy = new RandomStrat();
    } else {
      // otherwise, based on the last win, continue with the same strategy, or change if we lose

      if (stats.getLastWin() && strategy instanceof TopStrat) {
        strategy = new TopStrat(stats);
      } else {
        strategy = new RandomStrat();
      }

      if (stats.getLastWin() && strategy instanceof RandomStrat) {
        strategy = new RandomStrat();
      } else {
        strategy = new TopStrat(stats);
      }
    }
  }

  /**
   * This method returns the move based on the strategy chosen.
   *
   * @return the move based on the strategy chosen.
   */
  @Override
  public int returnMove() {
    chooseStrat();
    return strategy.chooseMove();
  }
}

package nz.ac.auckland.se281;

public class MediumBot implements Bot {
  private Strategy strategy = new RandomStrat();
  private Stats stats;

  public MediumBot(Stats stats) {
    this.stats = stats;
  }

  @Override
  public void chooseStrat() {
    if (stats.getRoundNumber() > 3) {
      strategy = new TopStrat(stats);
    }
  }

  @Override
  public int returnMove() {
    return strategy.chooseMove();
  }
}

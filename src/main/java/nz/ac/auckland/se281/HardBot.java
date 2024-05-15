package nz.ac.auckland.se281;

public class HardBot implements Bot {
  private Stats stats;
  private Strategy strategy;

  public HardBot(Stats stats) {
    this.stats = stats;
  }

  @Override
  public void chooseStrat() {
    if (stats.getRoundNumber() >= 3) {
      strategy = new TopStrat(stats);
    } else {
      if (stats.getLastWin()) {
        strategy = new TopStrat(stats);
      } else {
        strategy = new RandomStrat();
      }
    }
  }

  public int returnMove() {
    chooseStrat();
    return strategy.chooseMove();
  }
}

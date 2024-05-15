package nz.ac.auckland.se281;

public class MediumBot implements Bot {
  private Strategy strategy;
  Stats stats;

  @Override
  public void chooseStrat() {
    if (stats.getRoundNumber() > 3) {
      strategy = new TopStrat(stats.getMoves(), stats.getPlayerChoice());
    } else {
      strategy = new RandomStrat();
    }
  }

  @Override
  public int returnMove() {
    return strategy.chooseMove();
  }
}

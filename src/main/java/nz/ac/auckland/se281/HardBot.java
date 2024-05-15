package nz.ac.auckland.se281;

public class HardBot implements Bot {
  Stats stats;

  public HardBot(Stats stats) {
    this.stats = stats;
  }

  @Override
  public void chooseStrat() {}

  @Override
  public int returnMove() {
    return 3;
  }
}

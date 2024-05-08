package nz.ac.auckland.se281;

public class Easy implements Bot {
  Strategy strategy = null;

  public void chooseStrat() {
    // generates a random number between 0 and 5
    this.strategy = new RandomStrat();
  }

  @Override
  public int returnMove() {
    return this.strategy.returnMove();
  }
}

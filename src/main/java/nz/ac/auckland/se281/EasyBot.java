package nz.ac.auckland.se281;

public class EasyBot implements Bot {
  private Strategy strategy;

  @Override
  public void chooseStrat() {
    // generates a random number between 0 and 5
    strategy = new RandomStrat();
  }

  @Override
  public int returnMove() {
    chooseStrat(); // initialize strategy if it's null
    return strategy.chooseMove();
  }
}

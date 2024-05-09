package nz.ac.auckland.se281;

public class RandomStrat implements Strategy {

  public int chooseMove() {
    return Utils.random.nextInt(6);
  }
}

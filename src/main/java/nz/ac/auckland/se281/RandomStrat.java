package nz.ac.auckland.se281;

public class RandomStrat implements Strategy {

  public int returnMove() {
    return Utils.random.nextInt(6);
  }
}

package nz.ac.auckland.se281;

/** This class represents the RandomStrat class which implements the Strategy interface. */
public class RandomStrat implements Strategy {

  @Override
  public int chooseMove() {
    return Utils.random.nextInt(6);
  }
}

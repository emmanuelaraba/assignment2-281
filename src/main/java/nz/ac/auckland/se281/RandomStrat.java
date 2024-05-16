package nz.ac.auckland.se281;

/** This class represents the RandomStrat class which implements the Strategy interface. */
public class RandomStrat implements Strategy {

  /**
   * This method will choose the correct integer output for the bot.
   *
   * @return the integer guess that the bot will make.
   */
  @Override
  public int chooseMove() {
    return Utils.random.nextInt(6);
  }
}

package nz.ac.auckland.se281;

public class MediumBot implements Bot {

  @Override
  public void chooseStrat() {
    System.out.println("Medium Bot");
  }

  TopStrat topStrategy = new TopStrat();

  @Override
  public int returnMove() {
    if (this.topStrategy.getRoundNumber() > 3) {
      return topStrategy.chooseMove();
    } else {
      return Utils.random.nextInt(6);
    }
  }
}

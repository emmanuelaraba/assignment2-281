package nz.ac.auckland.se281;

public class MediumBot implements Bot {

  @Override
  public void chooseStrat() {
    System.out.println("Medium Bot");
  }

  @Override
  public int returnMove() {
    return 2;
  }
}

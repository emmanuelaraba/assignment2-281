package nz.ac.auckland.se281;

public class HardBot implements Bot {

  @Override
  public void chooseStrat() {
    System.out.println("Hard Bot");
  }

  @Override
  public int returnMove() {
    return 3;
  }
}

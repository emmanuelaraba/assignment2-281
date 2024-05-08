package nz.ac.auckland.se281;

public class Easy implements Bot {

  @Override
  public void returnName() {
    System.out.println("Easy Bot");
  }

  @Override
  public int BotLogic() {
    // generates a random number between 0 and 5
    return Utils.random.nextInt(6);
  }
}

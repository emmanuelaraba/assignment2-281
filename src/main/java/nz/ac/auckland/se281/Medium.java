package nz.ac.auckland.se281;

public class Medium implements Bot {

  @Override
  public void returnName() {
    System.out.println("Medium Bot");
  }

  @Override
  public int BotLogic() {
    return 2;
  }
}

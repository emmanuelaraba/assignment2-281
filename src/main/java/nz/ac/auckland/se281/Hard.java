package nz.ac.auckland.se281;

public class Hard implements Bot {

  @Override
  public void returnName() {
    System.out.println("Hard Bot");
  }

  @Override
  public int BotLogic() {
    return 3;
  }
}

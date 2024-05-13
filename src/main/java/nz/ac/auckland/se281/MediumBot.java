package nz.ac.auckland.se281;

public class MediumBot implements Bot {
  Game game = new Game();

  @Override
  public void chooseStrat() {
    System.out.println("Medium Bot");
  }

  @Override
  public int returnMove() {
    if (game.getRoundNumber() < 3) {
      RandomStrat randomStrategy = new RandomStrat();
      return randomStrategy.chooseMove();
    } else {
      TopStrat topStrategy = new TopStrat();
      return topStrategy.chooseMove();
    }
  }
}

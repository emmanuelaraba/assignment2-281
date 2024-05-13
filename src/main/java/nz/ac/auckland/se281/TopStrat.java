package nz.ac.auckland.se281;

import java.util.ArrayList;

public class TopStrat implements Strategy {
  ArrayList<Integer> moves;

  Game game = new Game();

  public int returnTopChoice() {
    return 1;
  }

  @Override
  public int chooseMove() {
    if (game.getRoundNumber() < 3) {
      return Utils.random.nextInt(6);
    } else {
      return returnTopChoice();
    }
  }
}

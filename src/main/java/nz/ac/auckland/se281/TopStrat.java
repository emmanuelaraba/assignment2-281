package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class TopStrat implements Strategy {
  Game game = new Game();
  ArrayList<Integer> moves = game.playerFingersList;

  public int returnTopChoice() {
    // count the number of odd numbers in the fingers list
    int oddCount = 0;
    for (int i = 0; i < moves.size(); i++) {
      if (moves.get(i) % 2 != 0) {
        oddCount++;
      }
    }
    int evenCount = moves.size() - oddCount; // count the number of even numbers in the fingers list
    // checking what the player choice is and using the opposite
    if (game.getPlayerChoice() == Choice.EVEN) {
      if (evenCount > oddCount) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomOddNumber();
      }
    } else { // if the player choice is odd
      if (evenCount > oddCount) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomOddNumber();
      }
    }
  }

  @Override
  public int chooseMove() {
    return returnTopChoice();
  }
}

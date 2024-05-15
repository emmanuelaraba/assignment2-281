package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class TopStrat implements Strategy {
  ArrayList<Integer> moves;
  Choice playerChoice;

  public TopStrat(ArrayList<Integer> moves, Choice playerChoice) {
    this.moves = moves;
    this.playerChoice = playerChoice;
  }

  public int getRoundNumber() {
    return moves.size();
  }

  public int returnTopChoice() {
    // count the number of odd numbers in the fingers list
    int oddCount = 0;
    int evenCount = 0;
    for (Integer integer : moves) {
      if (integer % 2 != 0) {
        oddCount++;
      } else {
        evenCount++;
      }
    }
    // checking what the player choice is and using the opposite
    if (playerChoice == Choice.ODD) { // if the player needs an even number
      if (evenCount > oddCount) { // and they have picked more even numbers
        return Utils.getRandomOddNumber(); // return an odd number
      } else { // if they have picked more odd numbers
        return Utils.getRandomEvenNumber(); // return an even number
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

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrat implements Strategy {
  private Stats stats;

  public TopStrat(Stats stats) {
    this.stats = stats;
  }

  public int getRoundNumber() {
    return stats.getRoundNumber();
  }

  @Override
  public int chooseMove() {
    // // count the number of odd numbers in the fingers list
    System.out.println(stats.getPlayerChoice().toString());
    int evenCount = stats.getEvenCount();
    int oddCount = stats.getOddCount();
    boolean playerPrefersEven = evenCount > oddCount;
    // checking what the player choice is and using the opposite
    if (stats.getPlayerChoice() == Choice.ODD) { // if the player needs an even number
      if (playerPrefersEven) { // and they have picked more even numbers
        return Utils.getRandomEvenNumber(); // return an odd number
      } else { // if they have picked more odd numbers
        return Utils.getRandomOddNumber(); // return an even number
      }
    } else { // if the player choice is even
      if (playerPrefersEven) { // and they have picked more even numbers
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomEvenNumber();
      }
    }
  }
}

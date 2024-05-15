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

  public int returnTopChoice() {
    // count the number of odd numbers in the fingers list

    // checking what the player choice is and using the opposite
    if (stats.getPlayerChoice() == Choice.ODD) { // if the player needs an even number
      if (stats.getEvenCount() > stats.getOddCount()) { // and they have picked more even numbers
        return Utils.getRandomOddNumber(); // return an odd number
      } else { // if they have picked more odd numbers
        return Utils.getRandomEvenNumber(); // return an even number
      }
    } else { // if the player choice is odd
      if (stats.getEvenCount() > stats.getOddCount()) { // and they have picked more even numbers
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

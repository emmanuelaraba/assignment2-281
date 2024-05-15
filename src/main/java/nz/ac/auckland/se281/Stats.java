package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class Stats {
  private int oddCount = 0;
  private int evenCount = 0;
  private ArrayList<Integer> moves;
  private Choice playerChoice;
  private int roundNumber = 0;

  public Stats(ArrayList<Integer> moves, Choice playerChoice) {
    this.moves = moves;
    this.playerChoice = playerChoice;
  }

  public int getRoundNumber() {
    return roundNumber;
  }

  public ArrayList<Integer> getMoves() {
    return moves;
  }

  public int getOddCount() {
    for (Integer integer : moves) {
      if (integer % 2 != 0) {
        oddCount++;
      }
    }
    return oddCount;
  }

  public int getEvenCount() {
    for (Integer integer : moves) {
      if (integer % 2 == 0) {
        evenCount++;
      }
    }
    return evenCount;
  }

  public Choice getPlayerChoice() {
    return playerChoice;
  }

  public void incrementRoundNumber() {
    roundNumber++;
  }
}

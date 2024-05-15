package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class Stats {
  private int oddCount;
  private int evenCount;
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

  public void setOddCount(int oddCount) {
    this.oddCount = oddCount;
  }

  public void setEvenCount(int evenCount) {
    this.evenCount = evenCount;
  }

  public int getOddCount() {
    return oddCount;
  }

  public int getEvenCount() {

    return evenCount;
  }

  public Choice getPlayerChoice() {
    return playerChoice;
  }

  public void incrementRoundNumber() {
    roundNumber++;
  }
}

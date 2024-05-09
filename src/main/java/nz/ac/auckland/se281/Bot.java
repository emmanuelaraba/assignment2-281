package nz.ac.auckland.se281;

public interface Bot {

  public void chooseStrat(); // method to choose strategy e.g (RandomStrat, TopStrat)

  public int returnMove(); // based on the strategy chosen, return the move from chosen strategy
}

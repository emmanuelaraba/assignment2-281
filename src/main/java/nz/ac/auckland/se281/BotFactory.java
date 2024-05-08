package nz.ac.auckland.se281;

public class BotFactory {

  public Bot makeBot(String bot) {

    switch (bot) {
      case "EASY":
        return new Easy();
      case "MEDIUM":
        return new Medium();
      case "HARD":
        return new Hard();
      default:
        MessageCli.INVALID_DIFFICULTY.printMessage();
    }
    return null;
  }
}

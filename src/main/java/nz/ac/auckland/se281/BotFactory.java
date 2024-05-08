package nz.ac.auckland.se281;

public class BotFactory {

  public static Bot setStrategy(String bot) {
    if (bot.equals("Easy")) {
      return new Easy();
    } else if (bot.equals("Medium")) {
      return new Medium();
    } else if (bot.equals("Hard")) {
      return new Hard();
    }
    return null;
  }
}

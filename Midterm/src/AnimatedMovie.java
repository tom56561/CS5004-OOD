/**
 * Animated movie is a specific type of movie (it implements the Movie
 * interface). You need to make a class diagram. The class diagram should
 * include the methods the interface requires, as well as any class variables
 * that you think the class would require given the methods and the descriptions
 * in the interface.
 * 
 * Once you have your class diagram, you need to give the concrete
 * implementations for getPublicationYear, jumpToTime, and resetProgress
 * 
 * You can assume that getTitle and saveProgress are implemented correctly. You
 * can also assume that there is a constructor that properly initializes all of
 * the class variables that you include in your class diagram.
 * 
 * If you think you need any other methods to properly implement your 3 methods,
 * you may add them as private methods, and then update your class diagram to
 * include them.
 * 
 * You do not need to make your code run or test your code. Instead you should
 * try to give the best implementation you can based off of the documentation.
 * If you have any assumptions you wish to make, you should specify them in
 * comments. If you don't understand how something should work, decide how you
 * think it should work and make sure you write documentation specifying how you
 * think it should work.
 * 
 * Make sure to include the class diagram, that is as important as the code you
 * write here.
 *
 */
public class AnimatedMovie implements Movie {
  /* Put your class diagram here:
  
  -----------------------------
 |          Movie              |
  -----------------------------
 | + getPublicationYear(): int |
 | + getTitle(): String        |
 | + resetProgress(): void     |
 | + saveProgress(): void      |
 | + jumpToTime(int,int): void |
 |                             |
  -----------------------------
              ^
              |
              |
              |  
   
  -----------------------------
 |       AnimatedMovie         |
  -----------------------------
 | - publicationYear: int      |
 | - currentMinute: int        |
 | - currentSeconds: int       |
  -----------------------------
 | + getPublicationYear(): int |
 | + getTitle(): String        |
 | + resetProgress(): void     |
 | + saveProgress(): void      |
 | + jumpToTime(int,int): void |
 |                             |
  -----------------------------
*/
  
  private int publicationYear;
  private int currentMinute;
  private int currentSeconds;

  @Override
  public int getPublicationYear() {
    return this.publicationYear;
  }

  @Override
  public void jumpToTime(int minute, int seconds) throws IllegalArgumentException {
    if (seconds > 60) {
      throw new IllegalArgumentException("Seconds can not larger than 60");
    }
    this.currentMinute = minute;
    this.currentSeconds = seconds;
  }

  @Override
  public void resetProgress() {
    this.currentMinute = 0;
    this.currentSeconds = 0;
  }

  // ALL THE METHODS BELOW HERE ARE ASSUMED TO BE PROPERLY IMPLEMENTED

  @Override
  public String getTitle() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void saveProgress() {
    // TODO Auto-generated method stub

  }

}

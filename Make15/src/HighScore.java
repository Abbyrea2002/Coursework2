import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by abbyr on 20/12/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class HighScore implements Comparable<HighScore>
{
   private static final int MAX_HIGH_SCORES = 5;
   private static List<HighScore> highScores = new ArrayList<>();
   private final String playerName;
   private final int score;

   public HighScore(String playerName, int score){
      this.playerName = playerName;
      this.score = score;
   }
   public String getPlayerName(){
      return playerName;
   }
   public int getScore(){
      return score;
   }
   public static void addHighScore(String name, int score) {
      HighScore newScore = new HighScore(name, score);
      highScores.add(newScore);
      Collections.sort(highScores); // Sorts based on `compareTo` in HighScore

      // Trim the list to the top MAX_HIGH_SCORES
      if (highScores.size() > MAX_HIGH_SCORES) {
         highScores.remove(highScores.size() - 1);
      }
   }
   public static void displayHighScores() {
      System.out.println("----- High Scores -----");
      if (highScores.isEmpty()) {
         System.out.println("No high scores yet.");
      } else {
         for (int i = 0; i < highScores.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, highScores.get(i));
         }
      }
      System.out.println("-----------------------");
   }
   public static boolean isNewHighScore(int score) {
      return highScores.size() < MAX_HIGH_SCORES || score > highScores.get(highScores.size() - 1).getScore();
   }


   @Override
   public int compareTo(HighScore other) {
      return Integer.compare(other.score, this.score);
   }
   public String toString() {
      return String.format("%-15s | %d", playerName, score); // Neatly formatted string
   }

}//class

/**
 * Created by abbyr on 04/01/2025
 * COMMENTS ABOUT PROGRAM HERE
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class HighscoreTest
{
   @BeforeEach
   public void setup() {
      HighScore.addHighScore("Player1", 100);
      HighScore.addHighScore("Player2", 200);
   }

   @Test
   public void testAddHighScore() {
      HighScore.addHighScore("Player3", 300);
      assertTrue(HighScore.isNewHighScore(250), "New high score should be recognized");
   }

   @Test
   public void testDisplayHighScores() {
      // Assuming displayHighScores prints to console
      // Capture the console output or mock System.out to verify
   }

   @Test
   public void testIsNewHighScore() {
      assertTrue(HighScore.isNewHighScore(250), "Higher score should be recognized as new high score");
      assertFalse(HighScore.isNewHighScore(50), "Lower score should not be recognized as new high score");
   }

}//class

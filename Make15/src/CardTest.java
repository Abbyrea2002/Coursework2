import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Created by abbyr on 04/01/2025
 * COMMENTS ABOUT PROGRAM HERE
 */
public class CardTest
{
      @Test
      public void testCardCreation() {
         Card card = new Card(1, 2); // "3 of Hearts"
         assertEquals("3", card.getRank());
         assertEquals("Hearts", card.getSuit());
      }

      @Test
      public void testCardEquality() {
         Card card1 = new Card(1, 2);
         Card card2 = new Card(1, 2);
         Card card3 = new Card(0, 3); // "2 of Spades"
         assertEquals(card1, card2);
         assertNotEquals(card1, card3);
      }

      @Test
      public void testCardRankValue() {
         Card card = new Card(0, 1); // "2 of Diamonds"
         assertEquals(2, card.getRankValue());
      }



}//class

/**
 * Created by abbyr on 04/01/2025
 * COMMENTS ABOUT PROGRAM HERE
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

   public class HandTest {
      private Hand hand;

      @BeforeEach
      public void setup() {
         hand = new Hand();
      }

      @Test
      public void testAddCard() {
         Card card = new Card(0, 0);
         hand.addCard(card);
         assertEquals(1, hand.getHandSize(), "Hand size should be 1 after adding a card");
         assertEquals(card, hand.getCards().get(0), "Card should be added to hand");
      }




      @Test
      public void testReplaceCard() {
         Card card1 = new Card(0, 0);
         Card card2 = new Card(1, 0);
         hand.addCard(card1);
         hand.replace(0, card2);
         assertEquals(card2, hand.getCards().get(0), "Card should be replaced with new card");
      }



      @Test
      public void testReplaceInvalidIndexThrowsException() {
         Card card = new Card(0, 0);
         hand.addCard(card);
         assertThrows(IllegalArgumentException.class, () -> hand.replace(1, card), "Replacing at invalid index should throw exception");
      }

}//class

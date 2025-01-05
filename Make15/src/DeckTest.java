/**
 * Created by abbyr on 04/01/2025
 * COMMENTS ABOUT PROGRAM HERE
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DeckTest {
   private Deck deck;

   @BeforeEach
   public void setup() {
      deck = new Deck();
   }

   @Test
   public void testDeckInitialization() {
      assertNotNull(deck, "Deck should be initialized");
   }

   @Test
   public void testShuffle() {
      Card[] originalOrder = new Card[52];
      for (int i = 0; i < 52; i++) {
         originalOrder[i] = new Card(i % 13, i / 13);
      }

      boolean differentOrder = false;
      for (int i = 0; i < 52; i++) {
         if (!originalOrder[i].equals(deck.deal())) {
            differentOrder = true;
            break;
         }
      }
      assertTrue(differentOrder, "Deck should be shuffled");
   }

   @Test
   public void testDeal() {
      assertFalse(deck.isEmpty(), "Deck should not be empty initially");
      assertNotNull(deck.deal(), "Dealt card should not be null");
   }

   @Test
   public void testDeckEmptyAfterDealingAllCards() {
      for (int i = 0; i < 52; i++) {
         deck.deal();
      }
      assertTrue(deck.isEmpty(), "Deck should be empty after dealing all cards");
   }

   @Test
   public void testDealFromEmptyDeckThrowsException() {
      while (!deck.isEmpty()) {
         deck.deal();
      }

      assertThrows(IllegalStateException.class, () -> {
         deck.deal();
      }, "Dealing from an empty deck should throw an exception");
   }
}


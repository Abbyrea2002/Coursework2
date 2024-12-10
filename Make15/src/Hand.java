/**
 * Created by abbyr on 06/12/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
import java.util.ArrayList;

public class Hand {
   private static ArrayList<Card> cards;

   public Hand(){
      cards = new ArrayList<>();
   }

   public void addCard(Card card){
      cards.add(card);
   }

   private static boolean inHand(Card card, Card[] hand){
      for (Card cardInHand : hand) {
         if (card.getSuit().equals(cardInHand.getSuit()) &&
               card.getRank().equals(cardInHand.getRank())) {
            return true;
         }
      }
      return false;
   }

}//class

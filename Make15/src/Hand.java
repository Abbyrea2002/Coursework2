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

   public ArrayList<Card> getCards(){
      return new ArrayList<>(cards);

   }

   public int getHandSize(){


      return cards.size();
   }

   public void addCard(Card card){

      cards.add(card);
   }

   public void remove(int index){
      if(index >= 0 && index < cards.size()){
         cards.remove(index);
      }
   }

   public void replace(int index, Card newCard){
      if (index >= 0 && index < cards.size()) { // Validate the index
         cards.set(index, newCard); // Replace the card
      } else {
         System.out.println("Error: Replace index out of bounds. Index: " + index);
      }

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

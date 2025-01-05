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

   public static ArrayList<Card> getCards(){
      return new ArrayList<>(cards);

   }

   public int getHandSize(){


      return cards.size();
   }

   public void addCard(Card card){

      cards.add(card);
   }

   public void replace(int index, Card newCard){
      if (index >= 0 && index < cards.size()) { // Validate the index
         cards.set(index, newCard); // Replace the card
      } else {
         System.out.println("Error: Replace index out of bounds. Index: " + index);
      }

   }

}//class

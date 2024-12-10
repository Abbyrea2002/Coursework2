/**
 * Created by abbyr on 10/12/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Make15
{
   private int score = 0;

   public static void main(String[] args){

      Deck deck = new Deck();
      Hand player = new Hand();
      Hand computer = new Hand();

      for(int i = 0; i < 5; i++){
         player.addCard(deck.deal());
      }

      do{
         System.out.println("Your hand is: " + player);
         System.out.println("Computer card: " + computer);


      }while(!deck.isEmpty());




   }

}//class

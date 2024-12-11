import java.util.Scanner;

/**
 * Created by abbyr on 10/12/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Make15
{
   private int score = 0;

   public static void main(String[] args){

      Scanner scanner = new Scanner(System.in);


      Deck deck = new Deck();
      Hand player = new Hand();
      Hand computer = new Hand();


      for(int i = 0; i < 5; i++){
         player.addCard(deck.deal());
      }

      while(true){
         computer.addCard(deck.deal());
         for(int i = 0; i < player.getHandSize(); i++){
            System.out.println("Your hand is: " + player.getCards().get(i));
         }

         System.out.println("Computer card: " + computer);



      }




   }

}//class

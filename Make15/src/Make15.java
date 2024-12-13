import java.util.Scanner;

/**
 * Created by abbyr on 10/12/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Make15
{
   private int score = 0;

   public static void main(String[] args){
      Make15 game = new Make15();
      Scanner scanner = new Scanner(System.in);


      Deck deck = new Deck();
      Hand player = new Hand();
      Hand computer = new Hand();


      for(int i = 0; i < 5; i++){
         player.addCard(deck.deal());
      }

      while(true){
         int choice = -1;

         System.out.println("Your hand is:");
         for(int i = 0; i < player.getHandSize(); i++){

            System.out.println((i + 1) + ". " + player.getCards().get(i));
         }
         computer.addCard(deck.deal());
         System.out.println("Computer card: " + computer.getCards());

         System.out.println("Enter the number of the card you would like to play: ");



         try{
            choice = Integer.parseInt(scanner.nextLine());
            if(choice < 1 || choice > player.getHandSize()){
               throw new IllegalArgumentException("Invalid, please enter a valid card number");
            }

         }catch(Exception e){
            System.out.println("Invalid input. Please enter a number between 1 and 5");
            continue;

         }





      }




   }

}//class

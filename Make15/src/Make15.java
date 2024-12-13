import java.util.Scanner;

/**
 * Created by abbyr on 10/12/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Make15
{


   public static void main(String[] args){
      Make15 game = new Make15();
      Scanner scanner = new Scanner(System.in);

      int score = 0;
      String input = "";
      int choice = -1;
      int choice2 = -1;

      Deck deck = new Deck();
      Hand player = new Hand();
      Hand computer = new Hand();


      for(int i = 0; i < 5; i++){
         player.addCard(deck.deal());
      }

      while(true){


         System.out.println("Your hand is:");
         for(int i = 0; i < player.getHandSize(); i++){

            System.out.println((i + 1) + ". " + player.getCards().get(i));
         }
         computer.addCard(deck.deal());
         System.out.println("Computer card: " + computer.getCards().get(computer.getHandSize() - 1));

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

         Card selectedCard = player.getCards().get(choice-1);

         if(selectedCard.getRankValue() + computer.getCards().get(1).getRankValue() == 15 ){
            Card newCard = deck.deal();
            player.replace(choice, newCard);
            score++;

            System.out.println("would you like to replace any picture cards in your hand?");
            input = scanner.nextLine().toLowerCase();

            if(input.equals("yes") || input.equals("y")){

               System.out.println("Which card would you like to select");
            }
            if(input.equals("no") || input.equals("n"))

         }
         if(){

         }





      }




   }

}//class

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

      Deck deck = new Deck();
      Hand player = new Hand();



      for(int i = 0; i < 5; i++){
         player.addCard(deck.deal());
      }

      while(!deck.isEmpty() || player.getHandSize() > 0){
         int score = 0;
         int choice = 0;
         int choice2 = 0;
         String input = "";


         System.out.println("Your hand is:");
         for(int i = 0; i < player.getHandSize(); i++){

            System.out.println((i + 1) + ". " + player.getCards().get(i));
         }
         Card computer = deck.deal();
         System.out.println("Computer card: " + computer);

         System.out.println("Enter the number of the card you would like to play: ");

         try{
            choice = Integer.parseInt(scanner.nextLine());
            if(choice - 1 < 0 || choice > player.getHandSize()){
               throw new IllegalArgumentException("Invalid, please enter a valid card number");
            }

         }catch(Exception e){
            System.out.println("Invalid input. Please enter a number between 1 and 5");
            continue;

         }
         System.out.println("Debug: Player's hand size: " + player.getHandSize());
         System.out.println("Debug: User-selected card (0-based index): " + (choice - 1));


         Card selectedCard = player.getCards().get(choice-1);

         int currentSum = selectedCard.getRankValue() + computer.getRankValue();
         System.out.println(currentSum);

         if(currentSum == 15 ){
            Card newCard = deck.deal();
            player.replace(choice-1, newCard);
            score++;

            while(true){
               System.out.println("would you like to replace any picture cards in your hand?");
               input = scanner.nextLine().toLowerCase();

               if(input.equals("yes") || input.equals("y")){
                  for(int i = 0; i < player.getHandSize(); i++){

                     System.out.println((i + 1) + ". " + player.getCards().get(i));
                  }
                  System.out.println("Which card would you like to select");
                  try{
                     choice2 = Integer.parseInt(scanner.nextLine());
                     if(choice2 -1 < 0|| choice2 > player.getHandSize()){
                        throw new IllegalArgumentException("Invalid, please enter a valid card number");
                     }

                  }catch(Exception e){
                     System.out.println("Invalid input. Please enter a number between 1 and 5");
                     continue;

                  }
                  Card newCard2 = deck.deal();
                  player.replace(choice2-1, newCard2);

               }
               else if(input.equals("no") || input.equals("n")){
                  break;
               }else{
                  System.out.println("invalid input. enter yes or no");
               }
            }
         }
         else if(selectedCard.getSuit().equals(computer.getSuit())){
            computer = deck.deal();
            player.replace(choice-1, deck.deal());

         }
         else if(currentSum != 15 && !selectedCard.getSuit().equals(computer.getSuit())){
            System.out.println("Score: " + score);
            break;
         }

      }




   }

}//class

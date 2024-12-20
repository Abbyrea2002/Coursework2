import java.util.Scanner;

/**
 * Created by abbyr on 10/12/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Make15
{
   public static void main(String[] args){
      HighScore.displayHighScores();
      Scanner scanner = new Scanner(System.in);
      boolean playAgain = true;

      while (playAgain) {
         Make15 game = new Make15();
         game.startGame();

         System.out.println("Would you like to play again? (yes/no): ");
         String input = scanner.nextLine().toLowerCase();

         if (input.equals("no") || input.equals("n")) {
            playAgain = false;
            System.out.println("Thank you for playing!");
         } else if (!input.equals("yes") && !input.equals("y")) {
            System.out.println("Invalid input, exiting the game.");
            playAgain = false;
         }
      }

      scanner.close();
   }
   public void startGame(){
      Scanner scanner = new Scanner(System.in);
      Deck deck = new Deck();
      Hand player = new Hand();
      boolean gameEnded = false;
      int score = 0;


      for(int i = 0; i < 5; i++){
         player.addCard(deck.deal());
      }

      while(!gameEnded){

         String input = "";
         if (deck.isEmpty() && player.getHandSize() == 0) {
            // No cards left in the deck or hand, end the game
            gameEnded = true;
            break;
         }


         System.out.println("Your hand is:");
         for(int i = 0; i < player.getHandSize(); i++){

            System.out.println((i + 1) + ". " + player.getCards().get(i));
         }
         Card computer = deck.deal();
         System.out.println("Computer card: " + computer);

         System.out.println("Enter the number of the card you would like to play: ");
         int choice = getPlayerChoice(scanner, player.getHandSize());

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
                  int choice2 = getPlayerChoice(scanner, player.getHandSize());

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
         else{
            gameEnded = true;
         }

      }
      System.out.println("\nGame over! Score: " + score);
      if (HighScore.isNewHighScore(score)) {
         System.out.print("Congratulations! You made a high score. Enter your name: ");
         String name = scanner.nextLine();
         HighScore.addHighScore(name, score);
         System.out.println("New high scores:");
         HighScore.displayHighScores();
      }

   }

   private static int getPlayerChoice(Scanner scanner, int handSize){
      while(true)
      {
         try
         {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice - 1 < 0 || choice > handSize)
            {
               throw new IllegalArgumentException("Invalid, please enter a valid card number");
            }
            return choice;
         } catch (Exception e)
         {
            System.out.println("Invalid input. Please enter a number between 1 and 5");
         }
      }
   }


}//class

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
      Hand computer = new Hand();


      for(int i = 0; i < 5; i++){
         player.addCard(deck.deal());
      }

      while(!deck.isEmpty() || player.getHandSize() > 0){
         int score = 0;
         int choice = -1;
         int choice2 = -1;
         String input = "";
         int currentSum = 0;

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

         currentSum += selectedCard.getRankValue();
         currentSum += computer.getCards().get(0).getRankValue();

         if(currentSum == 15 ){
            Card newCard = deck.deal();
            player.replace(choice, newCard);
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
                     if(choice2 < 1 || choice2 > player.getHandSize()){
                        throw new IllegalArgumentException("Invalid, please enter a valid card number");
                     }

                  }catch(Exception e){
                     System.out.println("Invalid input. Please enter a number between 1 and 5");
                     continue;

                  }
                  Card newCard2 = deck.deal();
                  player.replace(choice2, newCard2);

               }
               else if(input.equals("no") || input.equals("n")){
                  break;
               }else{
                  System.out.println("invalid input. enter yes or no");
               }
            }
         }
         else if(selectedCard.getSuit().equals(computer.getCards().get(computer.getHandSize() - 1).getSuit())){
            computer.replace(computer.getHandSize()-2, deck.deal());

         }
         else if(selectedCard.getRankValue() + computer.getCards().get(0).getRankValue() != 15 && !selectedCard.getSuit().equals(computer.getCards().get(1).getSuit())){
            break;
         }

      }




   }

}//class

import java.util.Random;

/**
 * Created by abbyr on 07/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Card implements Comparable<Card>
{
   private final int RANK, SUIT;




   private static final Random GENERATOR = new Random();
   private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
   private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
   //private static final String[] COLOURS = {"Red", "Black"};

   public Card(){
      RANK = GENERATOR.nextInt(RANKS.length);
      SUIT = GENERATOR.nextInt(SUITS.length);
      //COLOUR = (SUIT == 1 || SUIT == 2) ? 0 : 1;


   }
   public Card(int r, int s){
      RANK = r;
      SUIT = s;
   }

   public String getRank(){
      return RANKS[RANK];

   }

   public String getSuit(){
      return SUITS[SUIT];

   }

   //public String getColour(){
     // return COLOURS[COLOUR];
   //}

   public int getRankValue(){
      switch (getRank()) {
         case "2": return 2;
         case "3": return 3;
         case "4": return 4;
         case "5": return 5;
         case "6": return 6;
         case "7": return 7;
         case "8": return 8;
         case "9": return 9;
         case "10": return 10;
         case "Jack": return 11;
         case "Queen": return 11;
         case "King": return 11;
         case "Ace": return 12; // Change to 11 if required
         default: throw new IllegalStateException("Unexpected value: " + getRank());
      }
   }





   @Override
   public String toString(){
      return getRank() + " of " + getSuit();

   }

   @Override
   public int compareTo(Card otherCard){
      if(this.getRankValue() > otherCard.getRankValue()) return 1;
      else if(this.getRankValue() < otherCard.getRankValue()) return -1;
      else return 0;
   }
   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true; // Same reference
      if (obj == null || getClass() != obj.getClass()) return false; // Type check

      Card otherCard = (Card) obj; // Cast the object to Card
      return this.getSuit().equals(otherCard.getSuit()) && this.getRank().equals(otherCard.getRank());
   }
}//class

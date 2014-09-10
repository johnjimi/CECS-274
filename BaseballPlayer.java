//package baseballplayer;
import java.text.DecimalFormat;
import java.text.*;
/**
 * @author JIMI
 */
public class BaseballPlayer {
   /**
    * This intializing private member variables, a Player's First, Last, AtBat,
    * Single, Double, Triple, and Homerun
    */
   public String mPlayerFirstName;
   public String mPlayerLastName;
   private int mAtBat;
   private int mSingle;
   private int mDouble;
   private int mTriple;
   private int mHomerun;
   
   DecimalFormat DF = new DecimalFormat("0.000");
   
   /**
    * Creating a constructor, encapsulating 6 variables
    *
    * @param PlayerFirstName Player's FirstName
    * @param PlayerLastName Player's LastName
    * @param AtBat Player's AtBat hits
    * @param Single Player's Single hits
    * @param Triple Player's Triple hits
    * @param Homerun Player's HomeRuns hits
    */
   public BaseballPlayer(String PlayerFirstName, String PlayerLastName, int AtBat, int Single, int Double, int Triple, int Homerun) {
      mPlayerFirstName = PlayerFirstName;
      mPlayerLastName = PlayerLastName;
      mAtBat = AtBat;
      mSingle = Single;
      mDouble = Double;
      mTriple = Triple;
      mHomerun = Homerun;
   }//end constructor

   public String getFirstName() {
      return mPlayerFirstName;
   }//end getFirstName

   public String getLastName() {
      return mPlayerLastName;
   }//..

   public int getAtBat() {
      return mAtBat;    
   }

   public void setAtBat(int AtBat) {
      mAtBat = AtBat;
   }

   public int getHit(){
   return (mSingle + mDouble + mTriple + mHomerun);
   }
   public int getSingle() {
      return mSingle;
   }

   
   /**
    * Single must be greater than 0, but not less than -1
    * @param Single
    */
   public void setSingle(int Single) {
      mSingle = Single;
      if (Single >= 0) {
         throw new IllegalArgumentException("Must be greater than 0");
      }
   }

   public int getDouble() {
      return mDouble;
   }
   /**
    * Double must be greater than 0, but not less than -1
    * @param Double
    */
   public void setDouble(int Double) {
      mDouble = Double;
      if (Double >= 0) {
         throw new IllegalArgumentException("Must be greater than 0");
      }// end if
   }//end setDouble
   
   public int getTriple() {
      return mTriple;
   }//end getTriple

   /**
    * Triple can be greater than 0, but not less than -1
    * @param Triple
    */
   public void setTriple(int Triple) {
      mTriple = Triple;
      if (Triple >= 0) {
         throw new IllegalArgumentException("Must be greater than 0");
      }//end if
   }//end setTriple

   public int getHomerun() {
      return mHomerun;
   }

   public void setHomerun(int Homerun) {
      mHomerun = Homerun;
      if (Homerun >= 0) {
         throw new IllegalArgumentException("Must be greater than 0");
      }//end if
   }//end setHomerun
   
   /**
    * Typecasting the Average, Division of Total/AtBats
    */
   public double getAverage() {
      double average = (((double) (mSingle + mDouble + mTriple + mHomerun)) / ( mAtBat));
      return average;
   }
   
   /**
    * Concatenating the First and Last Name
    * @param FullName (First Last) in that order
    * @return Returns the variable FullName
    */
   public String getPlayerFullName() {
     return mPlayerFirstName + " " + mPlayerLastName;
   }
   
   /**
    * Output Player's full name, AtBats, Singles, Doubles, Triples, Home runs and Average
    * Average is formatted with 3 digits (#.###)
    */
   public String toString() {
      return mPlayerFirstName + " " + mPlayerLastName + ";" + " " + mAtBat + " AB; " + mSingle + " H; "
              + mDouble + " 2B; " + mTriple + " 3B; " + mHomerun + " HR; " + DF.format(getAverage()) + " AVG;";
   }//end toString method 
}//end class BaseballPlayer

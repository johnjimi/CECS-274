package sodamachine;
/*
Johnjimy K. Som
CECS 274, Section 1
Int: Neal Terrell
Spring 2014
*/
//Public class and private members
   public class SodaMachine {
   private String mNameOfBottle;
   private int mInventory;
   private double mCost;
   
   
   
   
//Starting the constructor for SodaMachine
   public SodaMachine(String SodaName, int SodaInventory, double CostOfSoda){
      mNameOfBottle = SodaName;
      mInventory = SodaInventory;
      mCost = CostOfSoda;     
   }//member variables
   //Creating a boolean method for Amount and Inventory
   public boolean canBuySoda(double amount) {
      if (amount >= mCost && mInventory >= 0) {//If have enough money and inventory  
         return true;
      }//end if
      else {//if have not enough money or inventory
         return false;
      }//end else
   }//end boolean method

  public double BuySoda(double amount){//important part
     // if user does have money to buy soda
     if (canBuySoda(amount)){
        mInventory--;
        return amount - mCost;
     }//end if
     //Else if the user does not have enough money.
     else {
        return Double.NEGATIVE_INFINITY;
     }//end else
  }//end double BuySoda
}//end Constructor

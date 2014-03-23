package sodamachine;
import java.util.Scanner;

public class SodaMachineTester {
   //Declaring Variables
   String mNameOfBottle; //Name of the bottle
   String mInventory; //Number of Inventory, this case we can set amount
   String mCost;// Cost of the Soda
   String mAmount;// Amount of money the USER has
  
   public static void main(String[] args) {
      //Member variables for scanner method
      String nameOfBottle; 
      String inventory;
      String cost;
      String amount;
      Scanner input = new Scanner(System.in);
      
      System.out.println("Name of Soda? ");//output question
      //String mNameOfBottle;
      //Storing the user's input and so forth for inventory.. etc.
      nameOfBottle = input.nextLine();
      System.out.println("Inventory Count? ");
      //String InventoryCount;
      inventory = input.nextLine();
      int Inventory = Integer.parseInt(inventory);
      System.out.println("Cost of Soda? ");
      //String CostOfSoda;
      cost = input.nextLine();//Easier to parseDouble
      double Cost = Double.parseDouble(cost);
      System.out.println("Want to buy " + nameOfBottle + "?" + " How much money do you have? ");
      //String Amount;
      amount = input.nextLine();
      double Amount = Double.parseDouble(amount);
  
      
      SodaMachine Soda = new SodaMachine(nameOfBottle, Inventory, Cost);
      //Needs a String, Int, Double for the constructor
      //Taking note of the SodaMachine class.
      
      //Calling the BuySoda method from SodaMachine
      while (Soda.BuySoda(Amount) >= Cost && Soda.canBuySoda(Inventory) == true) { 
         //System.out.println("You get " + "$"+ (Amount - Cost) + " change" +"\n");
         System.out.println("Received a bottle of " + nameOfBottle);
      }// If user has enough money
      if((Soda.BuySoda(Amount) >= Cost) && (Soda.canBuySoda(Inventory) == false)){   
         System.out.println("Out of " + nameOfBottle);
         //if no inventory
      }//end else if
      else if (Soda.canBuySoda(Inventory) != true){
         System.out.print("Sorry kid, the machine are all out of " + nameOfBottle + ".\n");
      }//end else if
      
      //if the user amount is less than the cost of Soda
      if (Soda.BuySoda(Amount) != Cost){
         System.out.println("ERROR " + Soda.BuySoda(Amount - Cost) + " $ needed");
         System.out.print("Your change $" + (Amount - Cost) + "  \n");
      }//end if
   }//end main
}// end class SodaMachineTester



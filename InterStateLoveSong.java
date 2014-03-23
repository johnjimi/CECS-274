package interstatelovesong;
import java.util.*;
/*
Johnjimy K. Som
CECS 274, Section 1
Int: Neal Terrell
Spring 2014
*/
public class InterStateLoveSong {
   public static void main(String args[]) {  
      //Declare members.
      String mInterstate; // User input, Scanner involved
      int m3DigitInterstate, mInterstateString, m2DigitModulus;
      int m3DivisionBy100, mRouteNumber;
      boolean exit;
     
      m3DigitInterstate = 3; //For 3 digit interstate e.g. 110, 405..
      mInterstateString = 11;//String count for Interstate
      m2DigitModulus = 5; //Divide by 5 finding the remainders
      m3DivisionBy100 = 100; //Divide any 100th interstate e.g 405,110, so forth
      //routeNumber translates the String.
      do {
         // Use the scanner method for user input.
         Scanner input = new Scanner(System.in);
         System.out.println("User, please enter a U.S. Interstate Highway Name");
         mInterstate = input.nextLine();
         
         {//**********************************************
            if (mInterstate.startsWith("Interstate")) {
               mRouteNumber = Integer.parseInt(mInterstate.substring(mInterstateString));
               System.out.println("Interstate " + mRouteNumber);
            }// end else if
            else if (mInterstate.startsWith("I-")) {
               mRouteNumber = Integer.parseInt(mInterstate.substring(2));
               System.out.println("Interstate " + mRouteNumber);
            }//end else if
            else if (mInterstate.startsWith("I")) {
               mRouteNumber = Integer.parseInt(mInterstate.substring(1));
               System.out.println("Interstate " + mRouteNumber);
            }//end else if
            else if (mInterstate.length() <= m3DigitInterstate) {
               mRouteNumber = Integer.parseInt(mInterstate.substring(0));
               System.out.println("Interstate " + mRouteNumber);
            } //end else if
            else { // if user do not input any above then,
               mRouteNumber = 0;
               System.exit(0); //Exits 
            }//end else
            //========
           
           if (String.valueOf(mRouteNumber).length() == m3DigitInterstate) {
               if (mRouteNumber / m3DivisionBy100 % 2 == 0) {
                  mRouteNumber = mRouteNumber % m3DivisionBy100;
                  System.out.println("This is a Circumferential Highway of highway " + mRouteNumber + ".");
               }//end if
               else {
                  mRouteNumber = mRouteNumber % m3DivisionBy100;
                  System.out.println("This is a Spur Highway of Highway " + mRouteNumber + ".");
               }//end else
            }//end if
           //=========
           
            if (String.valueOf(mRouteNumber).length() <= 2) {
               if (mRouteNumber % m2DigitModulus == 0) {
                  System.out.println("This is a Long Distance Arterial Highway.");
               }//end if
               if (mRouteNumber % 2 == 0) {
                  System.out.println("It is also an East-West Oriented Highway.");
               }//end if 
               else {
                  System.out.println("It is also North-South Oriented Highway.");
               }//end else
            }//end if
            
         }// ****************************************
      }//end do 
      while (!mInterstate.equals("exit"));// If User types "exit"
      //end while
   }//end main
}//end class InterStateluvSong

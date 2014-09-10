//import baseballplayer.RecordTree;

import java.util.Scanner;
import java.io.IOException;
//import java.util.*;

public class RecordProgram {

   /**
    * Main method, user selects eight options [1-8], each option execute
    * different functions BaseballPlayer; exceptions are added
    */
   public static void main(String[] args) {

      RecordTree myTree = new RecordTree();
      Scanner in = new Scanner(System.in);
      int choice;
      do {
         System.out.println("Main Menu: ");
         System.out.println("1. Load player file");
         System.out.println("2. Save player file");
         System.out.println("3. Show all player names");
         System.out.println("4. Show player details");
         System.out.println("5. Remove a player");
         System.out.println("6. Print tree structure");
         System.out.println("7. Print tree efficiency");
         System.out.println("8. Exit");
         System.out.println("Please enter a selection: ");
         choice = in.nextInt();
         if (choice == 1) {
            Scanner scan = new Scanner(System.in);
            int count = 0;
            System.out.println("Please enter the name of a player database "
             + "file: ");
            String fileName = scan.nextLine();
            try {
               PlayerLoader Loader = new PlayerLoader(fileName);
               BaseballPlayer player = Loader.nextPlayer();
               while (player != null) {
                  myTree.add(player);
                  player = Loader.nextPlayer();
                  count++;
               }//end while
               System.out.println("Loaded " + count + " players!\n");
            }//end try
            catch (IOException e) {
               System.out.println("Could not open the file " + fileName + "\n");
            }//end catch
         }//end if choice 1
         else if (choice == 2) {
            try {
               Scanner scan = new Scanner(System.in);
               System.out.println("Name your Save File: ");
               String fileName = scan.nextLine();
               myTree.saveToFile(fileName);
               System.out.println("File Saved: " + fileName);
            }//end try
            catch (Exception a) {
               System.out.println("File does not exist");
            }//end catch 
         }//end choice 2
         else if (choice == 3) {
            int i = 0;
            if (myTree.getCount() == 0) {
               System.out.println("The list is empty.");
            }//end if
            else {
               System.out.println("There are " + (myTree.getCount() + 1) + " players in the list.");
               myTree.printAll();
            }//end else
         }//end else choice 3

         else if (choice == 4) {
            String Name;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter player name: ");
            Name = input.nextLine();
            System.out.println("");
            System.out.println("Player: ");
            myTree.contains(Name);
            if (myTree != null) {
               System.out.println(myTree.getValue(Name));
            }//end if
            else {
               System.out.println("Could not find that name in this tree.");
            }//end else
         }//end else if choice 4
         else if (choice == 5) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter player you wish to delete: ");
            String player = keyboard.nextLine();
            if (myTree.contains(player) == true) {
               myTree.remove(player);
               System.out.println("Player removed.");
            }
            else {
               System.out.println("Player does not exist");
            }
         }//end choice 5
         else if (choice == 6) {
            myTree.printTreeStructure();
         }//end else if
         else if (choice == 7) {
            System.out.print("Efficiency: ");
            System.out.println(myTree.getCount() / Math.pow(2, myTree.getHeight() + 1));// Try add +1
            System.out.println(" ");
         }//end else if
         else if (choice == 8) {
            System.exit(0);
         }//end else if
      }//end do
      while (choice != 8);
   }//end while choice not equal to 8
}//end Record Program class

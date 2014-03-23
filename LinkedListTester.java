package linkedlist;

import linkedlist.LinkedList.Node;

public class LinkedListTester {
   public static void main(String[] args) {
      
      LinkedList myList = new LinkedList();
      // value of pi is 3.141592653 ...
      myList.addFirst(3);
      myList.addLast(1);
      myList.addLast(4);
      myList.addLast(1);
      myList.addLast(5);
      myList.addLast(9);
      myList.addLast(2);
      myList.addLast(6);
      myList.addLast(5);
      myList.addLast(3);

      myList.removeFirst();
      myList.removeLast();

      System.out.println("Data at Index [2]: " + myList.get(2));
      System.out.println("Print all ");
      myList.PrintAll();
      System.out.print("\n");
   }//end main
}//end class LinkedListTester


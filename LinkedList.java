package linkedlist;
//Packages
import java.util.List;

public class LinkedList {
   //Internal class called Node
   class Node {

      int mData;
      public Node mNext;
      public Node mPrev;
      //Get set methods goes here    

      public int getData() {
         return mData;
      }//end int get data
      
      public void setData(int data) {
         mData = data;
      }//end setData
      
      public void setNext(Node n) {
         mNext = n;
      }//end setNext
      
      public void setPrev(Node n) {
         mPrev = n;
      }//setPrev
      
  }//end class Node
   
   //need to access every data, by using the head we can.
   Node head;
   int Count;

   /*Creating our addFirst, addLast, removeFirst, RemoveLast
   int get, printAll
   */
   public void addFirst(int data) {
      Node n = new Node();
      n.setData(data);
      n.mNext = n;
      n.mPrev = n;
      head = n;
      Count++;
   }//end addFirst method

   
   //This one took me a while to figure out
   public void addLast(int data) {
      if (head == null){
         Node n = new Node();
         head = n;
         //Set the data, nodes
         n.setData(data);
         n.setNext(n);
         n.setPrev(n);
         Count++;
         //Add
      }
      else{
         //Similar to the if, set the data,
         //make the new Node 'n' point to next, prev
         Node n = new Node();
         n.setData(data);
         head.mPrev.mNext = n;
         n.mPrev = head.mPrev;
         n.mNext = head;
         head.mPrev = n;
         Count++;
      }//end else 
   }//end addLast

   public void removeFirst() {
      head.mNext.mPrev = head.mPrev;
      head.mPrev.mNext = head.mNext;
      head = head.mNext;
      Count--;
   }//end removeFirst

   public void removeLast() {
      head.mPrev = head.mPrev.mPrev;
      head.mPrev.mPrev.mNext = head;
      Count--;
   }//removeLast

   public int get(int index) {
      Node n = new Node();
      Count = 0;
      n = head;
      while (Count < index) {
         n = n.mNext;
         Count++;
      }//end while
      return n.getData();
   }//end get, return data;

   public void PrintAll() {
      Node n = new Node();
      n = head;
      while (n.mNext != head) {
         Count++;
         System.out.print(n.getData() + " ");
         n = n.mNext;
         //node to the next
      }//end while loop
      System.out.print(n.mData);
   }//end PrintAll
}//end class LinkedList
//ALT + Shift + F = FORMAT


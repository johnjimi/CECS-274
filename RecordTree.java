//package baseballplayer;

import java.util.*;

public class RecordTree {

   public Node root;
   public int mCount = 0;

   public class Node {

      //should've used mLeft, mRight... for member variables
      public BaseballPlayer Data;
      public Node Left, Right, Parent;
      public String key; //basically is the Name of the player

      Node(String Name, BaseballPlayer data, Node right, Node left, Node parent) {
         key = Name;
         Data = data;
         Left = left;
         Right = right;
         Parent = parent;
      }//end node constructor

      public void setLeft(Node newLeft) {
         Left = newLeft;
      }//end setLeft

      public void setRight(Node newRight) {
         Right = newRight;
      }//end public setRight

      public void setParent(Node ParentNode) {
         Parent = ParentNode;
      }//end public setParent
   }//end Node class

   public BaseballPlayer getValue(String Name) {
      if (find(Name, root) == null) {
         return null;
      }
      return find(Name, root).Data;
   }//end getValue

   public int getCount() {
      return mCount;
   }//end public getCount

   public boolean contains(String name) {
      Node n = find(name, root);
      if (n == null) {
         return false;
      }//end if n is null
      else {
         return true;
      }//end else statement
   }//end public boolean contains

   private Node find(String Name, Node n) {
      if (n != null) {
         if (Name.compareToIgnoreCase(n.key) == 0) {
            return n;
         }//end if n == null
         if (Name.compareToIgnoreCase(n.key) > 0) {
            return find(Name, n.Right);
         }//end if compare is greater than 0 than it goes to the right
         else {
            return find(Name, n.Left);
         }
      }//end else
      return null;
   }//end Node find

   public void add(BaseballPlayer player) {
      // add(player, root);       
      if (root == null) {
         Node newNode = new Node(player.getPlayerFullName(), player, null, null, null);
         root = newNode;
      }
      else {
         add(player, root);
      }
      // Searching the player, start from the root
   }//end public add

   private void add(BaseballPlayer player, Node n) {
      if (n.key.compareTo(player.getPlayerFullName()) < 0) {
         if (n.Right == null) {
            Node newNode = new Node(player.getPlayerFullName(), player, null, null, null);
            n.setRight(newNode);
            newNode.setParent(n);
            mCount++;
         }//end if n.Right
         else {
            add(player, n.Right);
         }//end else
      }//end if n.key.compareto is less than 0
      else {
         if (n.Left == null) {
            Node newNode = new Node(player.getPlayerFullName(), player, null, null, null);
            n.setLeft(newNode);
            newNode.setParent(n);
            mCount++;
         }//similar if it goes to the left
         else {
            add(player, n.Left);
         }//end else
      }//end else
   }//end private add

   public Node findSmallest(Node n) {
      if (n.Left == null) {
         return n;
      }
      return findSmallest(n.Left);
   }// I had this to n.Right  which is wrong

   public void remove(String Name) {
      mCount--;
      Node n = find(Name, root);
      if (n == null) {
         System.out.println("Node does not exist!");
      }//end if n==null
      else if (n.Right == null && n.Left == null) {
         if(n.Parent.Left == null){
            n.Parent.setRight(null);
            n.setParent(null);
         }//end if right and left child are null,
         else if(n.Parent.Right == null) {
            n.Parent.setLeft(null);
            n.setParent(n.Parent);
         }//end else
      }//end left and right child null case, Case 1
      //Case 2, begins below
      else if (n.Right == null || n.Left == null) {
         if (n.key.compareToIgnoreCase(n.Parent.key) > 0) {
            //greater than 0, right
            if (n.Left == null) {
               //need to check parent
               if (n.Parent == null) {        
                  root = n.Right;
                  //n.Right.setParent(null);
                  mCount--;
               }//end if **check
               n.Right.setParent(n.Parent);
               n.Parent.setRight(n.Right);
            }//re-link ^^^
         }//end if, key greater than 0
         else if (n.Right == null) {
            //check if the parent again!
            if (n.Parent == null) {
               root = n.Left;
               //n.Left.setParent(null);
               mCount--;
            }//end if
            n.Left.setParent(n.Parent);
            n.Parent.setLeft(n.Left);
         }//end else if right left cases, case 2
      }//end else if
      else {
         Node s = findSmallest(n.Right);
         remove(s.key);
         n.key = s.key;
         n.Data = s.Data;
      }//end else, case 3, both left and right child
   }//end public remove

   public int getHeight() {
      return getHeight(root);
   }//end int getHeight

   private int getHeight(Node n) {
      //Counting of left and right nodes
      int NumberOfLeft, NumberOfRight;
      if (n == null) {
         return -1;
      }//end if
      else {
         NumberOfLeft = getHeight(n.Left);
      }//end else
      NumberOfRight = getHeight(n.Right);
      return Math.max(NumberOfLeft, NumberOfRight) + 1;
   }//end private getHeight

   public void printAll() {
      inOrderPrint(root);
   }//end public printAll

   private void inOrderPrint(Node n) {
      if (n.Left != null) {
         inOrderPrint(n.Left);
      }//end if
      System.out.println(n.key);
      if (n.Right != null) {
         inOrderPrint(n.Right);
      }//end if
   }//end public inOrderPrint 

   public void preOrderSave(Node n, PlayerWriter w) {
      if (n != null) {
         w.writePlayer(n.Data);
         preOrderSave(n.Left, w);
         preOrderSave(n.Right, w);
         //recalling, preorder
      }//end if
   }//end preOrderSave

   public void saveToFile(String fileName) throws Exception {
      PlayerWriter writer = new PlayerWriter(fileName);
      preOrderSave(root, writer);
      writer.close();
      //Remember to lose the writer
   }//end public saveTo file

   public void printTreeStructure() {
      LinkedList<Node> players = new LinkedList(); //object
      LinkedList<Integer> numberPlayers = new LinkedList();
      int place = 0;
      numberPlayers.push(place);
      //number of objects of players
      players.push(root);
      while (!players.isEmpty()) {
         if (numberPlayers.size() == 0) {
            break;
         }//end if
         else {
            place = numberPlayers.pop();
            numberPlayers.push(place);
            for (int i = numberPlayers.pop(); i > 0; i--) {
               System.out.print("   ");
            }//end for
            //Creating a temp node
            Node temp = players.pop();
            System.out.print(temp.key + "\n");
            if (temp.Right != null) {
               place++;
               players.push(temp.Right);
               numberPlayers.push(place);
               if (temp.Left != null) {
                  players.push(temp.Left);
                  numberPlayers.push(place);
               }//end if
            }//end if
            else if (temp.Left != null) {
               place++;
               players.push(temp.Left);
               numberPlayers.push(place);
            }//end else if
            else {
            }//end else
         }//end if(numberplayers)== 0
      }//end while
   }//end printTreeStructure
}//end Node class

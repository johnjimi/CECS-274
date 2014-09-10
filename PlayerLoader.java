//import baseballplayer.BaseballPlayer;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class PlayerLoader {
   private Scanner mScanner;
   
   public PlayerLoader(String fileName) throws IOException {
      mScanner = new Scanner(new FileReader(fileName));
   }

   public BaseballPlayer nextPlayer() {
      if (mScanner.hasNext())
         return parseBaseballPlayer(mScanner.nextLine());
      return null;
   }
   
   private static BaseballPlayer parseBaseballPlayer(String line) {
      String[] split = line.split(",");
      String[] name = split[0].split(" ");
      int atBats = Integer.parseInt(split[2]);
      int singles = Integer.parseInt(split[4]);
      int doubles = Integer.parseInt(split[5]);
      int triples = Integer.parseInt(split[6]);
      int homeRuns = Integer.parseInt(split[7]);
//      int rbi = Integer.parseInt(split[8]);
//      int walks = Integer.parseInt(split[9]);
      return new BaseballPlayer(name[0], name[1], atBats, singles, doubles,
       triples, homeRuns);
   }//end private BaseballPlayer
}//end PlayerLoader class 

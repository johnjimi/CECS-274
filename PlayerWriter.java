//package baseballplayer;
import java.io.*;

public class PlayerWriter {
  private PrintStream mWriter;

   public PlayerWriter(String fileName) throws IOException {
      mWriter = new PrintStream(fileName, "UTF-8");
   }

   public void writePlayer(BaseballPlayer player) {
      mWriter.println(player.getPlayerFullName() + ",0," +
       player.getAtBat() + "," + player.getHit() + "," + player.getSingle() + "," +
       player.getDouble() + "," + player.getTriple() + "," + player.getHomerun()
       );   
   }

   public void close() {
      mWriter.close();
   }
}

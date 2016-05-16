// Import core package
import core.*;

/**
 * Main BotTrust Class which contains Main Method
 */
class BotTrust {
  public static void main(String[] args) throws Exception {
    Gui     gui = new Gui();        // create gui object
    CodeJam BT  = new CodeJam(gui); // create CodeJam object and pass gui object
    // start the CodeJam in Thread
    Thread t1   = new Thread(new Runnable() {
      public void run() {
        BT.start();
      }
    });
    t1.start();
  }
}

import core.*;

// 1st line is Test case we want to do
// each line after 1st line are test case data
// 1st char in every line is how many case we going to do
// 2nd char is color of button
// 3rd is button color going to push

class BotTrust {
  public static void main(String[] args) throws Exception {
    Gui     gui = new Gui();
    CodeJam BT  = new CodeJam(gui);
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        BT.start();
      }
    });
    t1.start();
  }
}

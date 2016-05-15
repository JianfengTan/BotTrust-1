package core;

/**
 * import Java Libraries
 */
import java.util.*;
import java.lang.Math.*;

/**
 * Code Jem class
 */
public class CodeJam{

  /**
   * Private dataset
   */
  private Bot    B    = new Bot("Blue");
  private Bot    O    = new Bot("Orange");
  private int    move = 0;
  private String bot  = "";
  private Gui    gui;

  /**
   * CodeJam construct
   * @param  g  Gui class
   */
  public CodeJam(Gui g){
    this.gui = g;
  }

  /**
   * Start Code Jam
   * @return void
   */
  public void start(){
    // display gui
    this.gui.display();
    // read the file that's passed
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    // loop
    for (int caseNum = 1; caseNum <= T; caseNum++) {
      int N = input.nextInt();
      B.reset();
      O.reset();
      // inner loop
      for (int i = 0; i < N; i++) {
        String bot = input.next();
        int    btn = input.nextInt();
        if(bot.equals("O")){
          this.calculate(O, B, btn);
        }else{
          this.calculate(B, O, btn);
        }
        this.gui.changeValue(bot, btn);
        try {
          Thread.sleep(1000 / this.gui.getSpeed());
        } catch (InterruptedException e) {
          // We don't care.
        }
      }
      this.printCase(caseNum, Math.max(B.getTime(), O.getTime()));
    }
  }

  /**
   * [calculate description]
   * @param int current current bot object
   * @param int other   other bot object
   * @param int button  button current bot need to move
   * @return void
   */
  public void calculate(Bot current, Bot other, int button){
    // time took to press the button
    int moveTime = Math.abs(current.getLocation() - button) + current.getTime();
    // get bigger time from bot
    int time = Math.max(moveTime, other.getTime()) + 1;
    // set the time and location of the Orange Bot
    try{
      current.setTime(time);
      current.setLocation(button);
    } catch (Exception e){
      System.out.println("Exception thrown  :" + e);
    }
  }

  /**
   * Print the outout or the current case
   * @param int x case number
   * @param int y minimum number of seconds required for the robots to push the given buttons
   * @return void
   */
  public void printCase(int x, int y){
    String output = String.format("Case %d: %d\n", x, y);
    System.out.format(output);
    this.gui.displayCase(output);
  }
}

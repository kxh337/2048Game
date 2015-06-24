import javax.swing.JFrame;

/**
 * The BoardManager class is responsible for placing tiles on the board and
 * deciding where to put the next tile(s).  The BoardManager will combine 
 * Tiles whhen needed and set the tiles to the proper value.
 */
public class BoardManager{

  public void makeGUI(){
    JFrame frame = new JFrame("2048 Game");
    frame.setVisible(true);
  }

}
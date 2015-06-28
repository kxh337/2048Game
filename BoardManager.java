import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 * The BoardManager class is responsible for placing tiles on the board and
 * deciding where to put the next tile(s).  The BoardManager will combine 
 * Tiles whhen needed and set the tiles to the proper value.
 */
public class BoardManager{
  
  public static void main(String args[]){
    BoardManager game = new BoardManager();
    JFrame frame = game.makeGUI(750, 650);
    game.createTiles(4,4, frame);
  }
  
 public JFrame makeGUI(int input1, int input2){
    JFrame frame = new JFrame("2048 Game");
    frame.setSize(input1, input2);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    return frame;
  }
  
  public void createTiles(int input1, int input2, JFrame frame){
    frame.setLayout(new GridLayout(input1 , input2));
    JButton[][] grid = new JButton[input1][input2];
    for(int i = 0; i < input1; i = i + 1){
      for(int j = 0; j < input2; j = j + 1){
        grid[i][j] = new JButton();
        frame.add(grid[i][j]);
      }
    }
    frame.setVisible(true);
  }
}
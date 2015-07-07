import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.util.Random;

/**
 * The BoardManager class is responsible for placing tiles on the board and
 * deciding where to put the next tile(s).  The BoardManager will combine 
 * Tiles whhen needed and set the tiles to the proper value.
 */
public class BoardManager{

  private Tile[][] grid;
  private Random rand = new Random();
  private int tileCount;

  /**
   * Creates the board for the game
   */
  public BoardManager(){
    JFrame frame = this.makeGUI(750, 650);
    this.createTiles(4,4, frame);
  }
  
  /**
   * Sets the size of the GUI frame and label of the frame
   * @param width - the width of the JFrame in pixels
   * @param hieght - the hieght of the Jframe in pixels
   */
  public JFrame makeGUI(int width, int height){
    JFrame frame = new JFrame("2048 Game");
    frame.setSize(width, height);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    return frame;
  }
  
  /**
   * Initializer that lays out the tiles on the board in specified JFrame
   * @param gridRow - the Tile row count in the Grid
   * @param gridCol - the Tile column count in the Grid
   */
  public void createTiles(int gridRow, int gridCol, JFrame frame){
    frame.setLayout(new GridLayout(gridRow , gridCol));
    grid = new Tile[gridRow][gridCol];
    for(int i = 0; i < gridRow; i = i + 1){
      for(int j = 0; j < gridCol; j = j + 1){
        grid[i][j] = new Tile();
        frame.add(grid[i][j].getButton());
      }
    }
    frame.setVisible(true);
    //randomly add 2-4 tiles to begin with
    int startTileCount = randomNumberGenerator(2,4);
    for(int i = 0;i < startTileCount; i++){
      randomAddTile(grid);
    }
  }

  /**
   * Generates a random number between the min and max values
   * @param min - the minimum value the random number can be
   * @param max - the maximum value the random number can be
   */
  public int randomNumberGenerator(int min, int max){
    int number = rand.nextInt((max - min) + 1) + min;
    return number;
  }


  /**
   * This adds tiles randomly to the board
   * @param array - two dimensional array of the tiles
   */
  public void randomAddTile(Tile[][] array){
    if(tileCount<16){
        int x = randomNumberGenerator(0, 3);
        int y = randomNumberGenerator(0, 3);

      while(array[x][y].getValue() != 0){
        x = randomNumberGenerator(0, 3);
        y = randomNumberGenerator(0, 3);
      }

      array[x][y].setValue(2);
      tileCount++;
    }
    else{
      System.err.println("No more tiles can be added");
    }
  }

}
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
    frame.addKeyListener(new ArrowKeyEvent());
    frame.setFocusable(true);
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
   * This method checks if the game is over. In other words if 2048
   * is a value on any of the tiles
   */
  public boolean checkGameOver(){
    boolean gameOver = false;
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[i].length; j++){
        if(grid[i][j].getValue() == 2048){
          gameOver = true;
        }
      }
    }
    //Check if nothing can be combined
    if(tileCount == 16 && checkNoMergableTiles()){
    	
	}	
	return gameOver;
  }

  /**
   * This method checks to see if there are any tiles left that can 
   * be merged. 
   * @return result - is true if there are no tiles left to be merged
   */
  public boolean checkNoMergableTiles(){
    boolean result  = true;
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[i].length; j++){
        //check each tile and make sure it can't merge with a neighboring tile

      }
    }
    return result;
  }

  /**
   * This adds tiles randomly to the board
   * @param array - two dimensional array of the tiles
   */
  public void randomAddTile(Tile[][] array){
    if(tileCount < 16){
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


  /**
   * Called by the main method to slide the Tiles based
   * on the users arrow key input. This will call the horizontal
   * and veritcal slide to easily handle all directions of slides.
   */
  public void slideTiles(int dir){
    switch(dir){
      case  ArrowKeyEvent.UP:
        mergeUp();
        slideUp();
        break;
      case ArrowKeyEvent.DOWN:
        mergeDown();
        slideDown();
        break;
      case ArrowKeyEvent.RIGHT:
        mergeRight();
        slideRight();
        break;
      case ArrowKeyEvent.LEFT:
        mergeLeft();
        slideLeft();
        break;
      default:
        System.err.println("Bad Key was pressed");
        break;
    }
    randomAddTile(grid);
  }

  private void mergeUp(){
    for(int i = 0; i < grid.length - 1; i++){
      for(int j = 0; j < grid[0].length; j++){
        if(grid[i][j].getValue() != 0){
          int k = i + 1;
          while(grid[k][j].getValue() == 0 && k < grid[0].length - 1){
            k++;
          }
          if(grid[i][j].getValue() == grid[k][j].getValue()){
            grid[i][j].mergeTile(grid[k][j]);
            tileCount--;
          }
        }
      }
    }
  }

  private void mergeDown(){
    for(int j = 0; j < grid[0].length; j++){
      for(int i = grid.length - 1; i > 1; i--){
        if(grid[i][j].getValue() != 0){
          int k = i - 1;
          while(grid[k][j].getValue() == 0 && k > 0){
            k--;
          }
          if(grid[i][j].getValue() == grid[k][j].getValue()){
            grid[i][j].mergeTile(grid[k][j]);
            tileCount--;
          }
        }
      }
    }
  }

  private void mergeRight(){
    for(int i = 0; i < grid.length; i++){
      for(int j = grid[0].length - 1; j > 0 ; j--){
        if(grid[i][j].getValue() != 0){
          int k = j - 1;
          while(grid[i][k].getValue() == 0 && k > 0){
            k--;
          }
          if(grid[i][j].getValue() == grid[i][k].getValue()){
            grid[i][j].mergeTile(grid[i][k]);
            tileCount--;
          }
        }
      }
    }
  }

  private void mergeLeft(){
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length - 1; j++){
        if(grid[i][j].getValue() != 0){
          int k = j + 1;
          while(grid[i][k].getValue() == 0 && k < grid[0].length - 1){
            k++;
          }
          if(grid[i][j].getValue() == grid[i][k].getValue()){
            grid[i][j].mergeTile(grid[i][k]);
            tileCount--;
          }
        }
      }
    }
  }

  /**
   * Slides the tiles up
   */
  private void slideUp(){
    for(int i = 1; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
        //finds which tiles are not 0
        if(grid[i][j].getValue() != 0){
          int k = i - 1;
          //finds the last non-0 tile in upwards
          while(grid[k][j].getValue() == 0 && k > 0){
            k--;
          }
          //moves it to the tile if it has a value of 0
          if(grid[k][j].getValue() == 0){
            grid[i][j].swap(grid[k][j]);
          }
          //moves it to the last zero in the upwards direction
          else{
            grid[i][j].swap(grid[k + 1][j]);
          }
        }
      }
    }
  }

  /**
   * Slides the tiles down
   */
  private void slideDown(){
    for(int i = grid.length - 2; i >= 0 ; i--){
      for(int j = 0; j< grid[0].length; j++){
        //finds which tiles are not 0
        if(grid[i][j].getValue() != 0){
          int k = i + 1;
          //finds the last non-0 tile in the downwards
          while(grid[k][j].getValue() == 0 && k < grid[0].length-1){
            k++;
          }
          //moves it to the tile if it has a value of 0
          if(grid[k][j].getValue() == 0){
            grid[i][j].swap(grid[k][j]);
          }
          //moves it to the last zero in the downwards direction
          else{
            grid[i][j].swap(grid[k - 1][j]);
          }
        }
      }
    }
  }

  /**
   * Slides the tiles right
   */
  private void slideRight(){
    for(int i = 0; i < grid.length; i++){
      for(int j = grid[0].length-2; j >= 0; j--){
        //finds which tiles are not 0
        if(grid[i][j].getValue() != 0){
          int k = j + 1;
          //finds the last non-0 tile in the right direction
          while(grid[i][k].getValue() == 0 && k < grid[0].length-1){
            k++;
          }
          //moves it to the tile if it has a value of 0
          if(grid[i][k].getValue() == 0){
            grid[i][j].swap(grid[i][k]);
          }
          //moves it to the last zero in the right direction
          else{
            grid[i][j].swap(grid[i][k - 1]);
          }
        }
      }
    }
  }

  /**
   * Slides the tiles left
   */
  private void slideLeft(){
    //goes through each tile
    for(int i = 0; i < grid.length; i++){
      for(int j = 1; j < grid[i].length; j++){
        //finds which tiles are not 0
        if(grid[i][j].getValue() != 0){
          int k = j - 1;
          //finds the last non-0 tile in the left direction
          while(grid[i][k].getValue() == 0 && k > 0){
            k--;
          }
          //moves it to the tile if it has a value of 0
          if(grid[i][k].getValue() == 0){
            grid[i][j].swap(grid[i][k]);
          }
          //moves it to the last zero in the left direction
          else{
            grid[i][j].swap(grid[i][k + 1]);
          }
        }
      }
    }
  }
  

}
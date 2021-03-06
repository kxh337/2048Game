/** 
 * Main class 2048game  
 * This is the 2048 game where the user will input a direction: up, down, left, right.
 * Tiles on the board will move in the user's inputted direction and if the values are
 * the same the tiles merge and add their values.  Each turn the game will randomly 
 * place a tile of value 2 adjacent to a pre-exsisting tile.  The game will start with 2 tiles and 
 * will end if there is a tile of a value of 2048.
 */
public class TwentyFourtyEight{
	
	/**
	 * Main method that starts the game
	 */
  public static void main(String args[]){
    BoardManager board = new BoardManager();
    while(!(board.checkGameOver())){
      //sleeps the loop a bit so it doesn't hog your processor
      try
      {
          Thread.sleep(300);
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }

    	if(ArrowKeyEvent.dir != ArrowKeyEvent.NONE){
        board.slideTiles(ArrowKeyEvent.dir);
        ArrowKeyEvent.dir = ArrowKeyEvent.NONE;
      }
    }
    System.out.println("Game Over");
  }
  

}
/**
 * The Tile class represents each tile on the board and will carry
 * a value that is a power of 2 the lowest being 2 and highest being 2048
 */
import java.util.Random;

public class Tile{
  
  public Integer[][] makeArray(int input1, int input2){
    Integer[][] array = new Integer[input1][input2];
    return array;
  }
  
  public int randomNumberGenerator(int min, int max){
    Random rand = new Random();
    int number = rand.nextInt((max - min) + 1) + min;
    return number;
  } 
  
  public void randomAdd(Integer[][] array){
    int x = randomNumberGenerator(0, 3);
    int y = randomNumberGenerator(0, 3);
    while(array[x][y] == null){
      array[x][y] = 2;
      x = randomNumberGenerator(0, 3);
      y = randomNumberGenerator(0, 3);
    }
  }
  
}
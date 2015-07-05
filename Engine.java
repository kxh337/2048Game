/* Will hold the four methods that are used for sliding left, right, up or down for the game */

public class Engine{

  public void slideLeft(Integer[][] array, int row){
    for(int i = 0; i <= 3; i = i + 1){
      if(array[row][i] != 0){
        if(array[row][i] == array[row][i + 1]){
          array[row][i] = array[row][i] + array[row][i + 1];
          array[row][i + 1] = 0;
        }
        else if (array[row][i] != array[row][i + 1]){
          
        }
      }
    }
  }

}
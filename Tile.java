import javax.swing.JButton;

/**
 * The Tile class represents each tile on the board and will carry
 * a value that is a power of 2 the lowest being 2 and highest being 2048
 */

public class Tile{
  /*private fields*/
  private int value;
  private JButton button;


  public Tile(){
    button = new JButton();
  }

  public JButton getButton(){
    return this.button;
  }

  /**
   * Sets the value of this tile and updates the button
   * @param value - the value the tile will be set to
   */
  public void setValue(int value){
    this.value = value;
    updateButton();
  }

  /**
   * Returns the value of this tile
   */
  public int getValue(){
    return this.value;
  }

  /**
   * Updates the value shown on the button.  If the value is 0
   * then nothing will be shown on the button.
   */
  public void updateButton(){
    if(this.value == 0){
      //show nothing
    }
    else{
      //show value
    }
  }
}
import java.awt.event.*;

/**
 * This class will detect user input of the 
 * arrow keys and will treat them as events. 
 * The BoardManager will use these events to 
 * to move the Tiles accordingly
 */
public class ArrowKeyEvent implements KeyListener{
	
	/** Global variables to represent directions as int*/
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int RIGHT = 2;
	public static final int LEFT = 3;
	public static final int  NONE = 4;

	/** the direction of the pressed key is stored here*/
	public static int dir = NONE;	

	/**
	 * This method will set the direction respective
	 * to the arrow key direction pressed.
	 * @param e - Keyevent 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
		    case KeyEvent.VK_UP:
		        // handle up 
		    	dir = UP;
		        break;
		    case KeyEvent.VK_DOWN:
		        // handle down 
		    	dir = DOWN;
		        break;
		    case KeyEvent.VK_LEFT:
		        // handle left
		    	dir = LEFT;
		        break;
		    case KeyEvent.VK_RIGHT :
		        // handle right
		    	dir = RIGHT;
		        break;
		    default:
		    	dir = NONE;
		    break;
		 	}
 	}

 	/**
 	 * This method is required to be overrided but not needed for this app
 	 */
 	@Override
 	public void keyReleased(KeyEvent e){}

	/**
 	 * This method is required to be overrided but not needed for this app
 	 */
 	@Override
 	public void keyTyped(KeyEvent e){}
}
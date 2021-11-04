import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JFrame implements KeyListener{
    
    int dx = 100;
    int dy = 100;

    public Board(JFrame frame){
        
    }

    public void paint(Graphics g){

    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
    
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }
    
        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }
    
        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }
    
        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}

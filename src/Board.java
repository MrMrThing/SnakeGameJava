import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Board extends JPanel implements KeyListener{
    
    int dx = 100;
    int dy = 100;
    JFrame frame;

    

    public Board(JFrame frame){

        this.frame = frame;
        frame.addKeyListener(this);
    }

 

    
    public void paint(Graphics g){

        g.fillRect(dx, dy, 50, 50);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        switch(e.getKeyCode()){

          case KeyEvent.VK_LEFT:
            dx = dx - 50;
            break;
          case KeyEvent.VK_RIGHT:
            dx = dx + 50;
            break;
          case KeyEvent.VK_DOWN:
            dy = dy + 50;
            break;
          case KeyEvent.VK_UP:
            dy = dy - 50;
            break;


        }
        
        frame.repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

  
}

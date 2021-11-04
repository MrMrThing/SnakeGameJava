import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Board extends JPanel implements KeyListener{
    
    int dx = 300;
    int dy = 300;
    JFrame frame;
    int size = 25;
    
    public ArrayList<Integer> tail = new ArrayList<>();

    this.tail.add(2,5);

    public Board(JFrame frame){

        this.frame = frame;
        frame.addKeyListener(this);
    }

 

    
    public void paint(Graphics g){

        tail[2] = [2][5];

        g.fillRect(dx, dy, size, size);

        for(int i = 0; i < tail.length; i++){
            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        switch(e.getKeyCode()){

          case KeyEvent.VK_LEFT:
            dx = dx - size;
            break;
          case KeyEvent.VK_RIGHT:
            dx = dx + size;
            break;
          case KeyEvent.VK_DOWN:
            dy = dy + size;
            break;
          case KeyEvent.VK_UP:
            dy = dy - size;
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

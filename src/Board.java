import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;



public class Board extends JPanel implements KeyListener{
    
    int dx[] = new int[200];
    int dy[] =  new int[200];
    JFrame frame;
    int size = 25;

    int tail = 20;
    int temp1x;
    int temp1y;
    int temp2x;
    int temp2y;

    
      

    public Board(JFrame frame){

        this.frame = frame;
        frame.addKeyListener(this);
        dx[0] = 300;
        dy[0] = 300;
        
    }

 

    
    public void paint(Graphics g){


        for(int i = 0; i < tail; i++){

          if(i == 0){
            g.fillRect(dx[0], dy[0], size - 5, size - 5);   
          } else{

            temp2x = dx[i];
            temp2y = dy[i];
            System.out.println("Temp2 " + temp2x);

            dx[i] = temp1x;
            dy[i] = temp1y;

            System.out.println("Temp1 " + temp1x);
            temp1x = temp2x;
            temp1y = temp2y;

            g.fillRect(dx[i], dy[i], size - 5, size - 5);
            
            
          }

          
          

        }
            
    }

    @Override
    public void keyPressed(KeyEvent e) {

        temp1x = dx[0];
        temp1y = dy[0];

        switch(e.getKeyCode()){

          case KeyEvent.VK_LEFT:
            dx[0] = dx[0] - size;
            break;
          case KeyEvent.VK_RIGHT:
            dx[0] = dx[0] + size;
            break;
          case KeyEvent.VK_DOWN:
            dy[0] = dy[0] + size;
            break;
          case KeyEvent.VK_UP:
            dy[0] = dy[0] - size;
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

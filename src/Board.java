import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;



public class Board extends JPanel implements ActionListener, KeyListener{
    
    Random ran = new Random();

    int dx[] = new int[200];
    int dy[] =  new int[200];
    JFrame frame;
    int size = 25;

    int tail = 5;
    int temp1x;
    int temp1y;
    int temp2x;
    int temp2y;

    int appleX = 300;
    int appleY = 300;

    double test = Math.random()*(600-1);

    int Delay = 200;
      
    Timer timer;

    char direction;
    char oldDirection;



    public Board(JFrame frame){

        this.frame = frame;
        frame.addKeyListener(this);
        dx[0] = 300;
        dy[0] = 300;

        timer = new Timer(Delay, (ActionListener) this);
		    timer.start();
        
    }

 

    
    public void paint(Graphics g){

      g.setColor(Color.RED);
      g.fillRect(appleX, appleY, size - 5, size - 5);

      g.setColor(Color.GREEN);
      g.fillRect(dx[0], dy[0], size - 5, size - 5);

      for(int i = 0; i < tail; i++){
        g.fillRect(dx[i], dy[i], size - 5, size - 5);
      }
          
            
    }


    public void move(){

      System.out.println(appleX);

      temp1x = dx[0];
      temp1y = dy[0];

      switch(direction){

        case 'L':
          dx[0] = dx[0] - size;
          break;
        case 'R':
          dx[0] = dx[0] + size;
          break;
        case 'D':
          dy[0] = dy[0] + size;
          break;
        case 'U':
          dy[0] = dy[0] - size;
          break;

      }
      

      for(int i = 0; i < tail; i++){

        if(i != 0){
          temp2x = dx[i];
          temp2y = dy[i];


          dx[i] = temp1x;
          dy[i] = temp1y;


          temp1x = temp2x;
          temp1y = temp2y;
        }
      }
    }

    public void checkApple(){

      if(dx[0] == appleX && dy[0] == appleY){
        tail = tail + 3;
        appleX = ran.nextInt(24);
        appleX = appleX * size;
        appleY = ran.nextInt(24);
        appleY = appleY * size;
      }

    }

    @Override
    public void keyPressed(KeyEvent e) {

      oldDirection = direction;



      if(e.getKeyCode() == KeyEvent.VK_LEFT && oldDirection != 'R'){
        direction = 'L';
      }
      if(e.getKeyCode() == KeyEvent.VK_RIGHT && oldDirection != 'L'){
        direction = 'R';
      }
      if(e.getKeyCode() == KeyEvent.VK_DOWN && oldDirection != 'U'){
        direction = 'D';
      }
      if(e.getKeyCode() == KeyEvent.VK_UP && oldDirection != 'D'){
        direction = 'U';
      }
        
    }


    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    public void actionPerformed(ActionEvent e){
      
      move();
      checkApple();
      frame.repaint();

    }
  
}

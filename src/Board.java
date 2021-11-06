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
    
  //variables

    Random ran = new Random();
    JFrame frame;

  //Arrays for the snake positions
    int dx[] = new int[200];
    int dy[] =  new int[200];

  //The size of the snake and length
    int size = 25;
    int tail = 5;

  //variables used to draw the snake
    int temp1x;
    int temp1y;
    int temp2x;
    int temp2y;

    int appleX = 300;
    int appleY = 300;

  //Delay is how long in miliseconds, for every time the game is updated
    int Delay = 200;
    Timer timer;

  //variables to control the direction of the snake :)
    char direction;
    char oldDirection;

  //----------------------------------------------

  //Contructor, getting a JFrame, from where ever it is called
    public Board(JFrame frame){

        this.frame = frame;
        frame.addKeyListener(this);

        //Setting the start position for the snakes head
        dx[0] = 300;
        dy[0] = 300;

        //Setting the timer with the delay, and sending it to ActionPerformed()
        //When ever the time have been reached
        timer = new Timer(Delay, (ActionListener) this);
		    timer.start();
        
    }

 
    //Here we draw the snake and the apple
    public void paint(Graphics g){

      //Apple
      g.setColor(Color.RED);
      g.fillRect(appleX, appleY, size - 5, size - 5);

      //Snakes head
      g.setColor(Color.GREEN);
      g.fillRect(dx[0], dy[0], size - 5, size - 5);

      //Snakes tail
      for(int i = 0; i < tail; i++){
        g.fillRect(dx[i], dy[i], size - 5, size - 5);
      }
          
            
    }

    //Here we control how the snake move around
    public void move(){

      //Setting temp to snakes head, so that we can use it's last position
      temp1x = dx[0];
      temp1y = dy[0];

      //Asking to find out what direction the snakes is going
      //And then move it
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
      
      //Drawing the snakes tail
      for(int i = 0; i < tail; i++){

        //using and if, so that we dont draw the head twice
        //there is 100% a better way of doing this
        if(i != 0){

          //Saving the position, so that we can use it for the next tail piece
          temp2x = dx[i];
          temp2y = dy[i];

          //setting this piece to be the last ones place
          dx[i] = temp1x;
          dy[i] = temp1y;

          //then update the temps, so that the next piece can do the same
          temp1x = temp2x;
          temp1y = temp2y;
        }
      }
    }

    //function for seeing if the head is touching the apple
    public void checkApple(){

      //if x and y, is the same place as appleX and y
      if(dx[0] == appleX && dy[0] == appleY){
        //making the tail longer
        tail = tail + 3;

        //Setting a new random place for the apple
        appleX = ran.nextInt(24);
        appleX = appleX * size;
        appleY = ran.nextInt(24);
        appleY = appleY * size;
      }

    }

    //Here keyPressed is run
    @Override
    public void keyPressed(KeyEvent e) {

      //Saving the old direction, so that we can't go the opposed way
      oldDirection = direction;

      //Checking to see if the player has pressed 4 specific buttons
      //LEFT, RIGHT, DOWN, UP
      //And then set the direction

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

    //Needed for the KeyListener
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    //Needed for the KeyListener
    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    //This code is run whenever the timer runs out (Delay)
    public void actionPerformed(ActionEvent e){
      
      //Calling the fuctions
      move();
      checkApple();

      //run the graphics in JFrame 
      frame.repaint();

    }
  
}

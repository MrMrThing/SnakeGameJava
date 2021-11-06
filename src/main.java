import javax.swing.JFrame;
import java.awt.*;

public class main{

    //The starting fuction
    public static void main(String[] args){

        //Making the Frame
        JFrame frame = new JFrame();
        
        //Setting up the window
        frame.setSize(650,650);
        frame.getContentPane().add(new Board(frame));
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //Calling Board class, and sending the frame
        Board Board = new Board(frame);
    }

}

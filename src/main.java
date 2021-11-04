import javax.swing.JFrame;
import java.awt.*;

public class main{

    public static void main(String[] args){

        JFrame frame = new JFrame();
        
        frame.setSize(650,650);
        frame.getContentPane().add(new Board(frame));
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Board Board = new Board(frame);
    }

}

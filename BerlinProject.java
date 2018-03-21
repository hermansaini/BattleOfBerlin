import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BerlinProject extends JFrame{

     JFrame frame; //variables

     public BerlinProject(){
          frame = new JFrame("BerlinProject");
     }

     public static void main(String[] args){
          BerlinProject bp = new BerlinProject();
          bp.run();

     }

     public void run(){
          frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

          MainPanel mainP = new MainPanel(); //making instances of the 3 other panels in the game
          mainP.run();
          frame.add(mainP, "Main");

          frame.setSize(1200, 750);
          frame.setResizable(false);
          frame.setVisible(true);
     }

     class MainPanel extends JPanel implements ActionListener{
          private Image image;
          private String imageName;

          public MainPanel(){
               imageName = "BattleOfBerlin.jpg"; //background of the panel
          }

          public void run()
          {
            getMyImage();
          }

          public void getMyImage()
          {
            try
            { //try catch block to load the image, catch exceptions
              image = ImageIO.read(new File(imageName));
            }
            catch(IOException e)
            {
              System.err.println("\n\n" + imageName + "can't be found.");
              e.printStackTrace();
            }
          }

          public void actionPerformed(ActionEvent e){


          }

          public void paintComponent(Graphics g){
               super.paintComponent(g); //drawing the image
               g.drawImage(image, 300, 0, 150, 150, this);
          }
     }

}

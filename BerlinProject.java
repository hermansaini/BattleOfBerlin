import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BerlinProject extends JFrame{

     JFrame frame; //variables
     JPanel test;
     CardLayout cards;

     public BerlinProject(){
          frame = new JFrame("BerlinProject");
     }

     public static void main(String[] args){
          BerlinProject bp = new BerlinProject();
          bp.run();

     }

     public void run(){
          frame.setSize(1200, 750);
          cards = new CardLayout();

          frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

          test = new JPanel(cards);

          MainPanel mainP = new MainPanel(); //making instances of the 3 other panels in the game
          mainP.run();

          test.add(mainP, "Main");

          frame.add(test);

          frame.setResizable(false);
          frame.setVisible(true);
     }

     class MainPanel extends JPanel implements ActionListener{
          private Image image;
          private String imageName;

          public MainPanel(){
               //setLayout(new GridLayout(1, 1)); //setting layout to a grid layout
               imageName = "BattleOfBerlin.jpg"; //background of the panel
          }

          public void run()
          {
               getMyImage();
               repaint();
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
               g.drawImage(image, 0, 0, this);
          }
     }

}

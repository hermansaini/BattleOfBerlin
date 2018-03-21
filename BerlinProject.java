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

          MainPanel mainPanel = new MainPanel(); //making instances of the 3 other panels in the game
          mainPanel.run();

          // Airstirkes asPanel = new Airstirkes();
          //
          // Life lPanel = new Life();
          //
          // GroundInvasion giPanel = new GroundInvasion();
          //
          // Aftermath amPanel = new Aftermath();

           test.add(mainPanel, "Main");
          // test.add(asPanel, "Airstikes");
          // test.add(lPanel, "Life During the Battle");
          // test.add(giPanel, "Ground Invasion");
          // test.add(amPanel, "Aftermath");

          frame.add(test);

          frame.setResizable(false);
          frame.setVisible(true);

     }

     class MainPanel extends JPanel implements ActionListener{
          private Image image;
          private String imageName;

          JButton giButton;
          JButton amButton;
          JButton asButton;
          JButton lButton;

          public MainPanel(){
               imageName = "BattleOfBerlin.jpg";

               JLabel instructions = new JLabel("Click on one of the buttons below to start.", JLabel.CENTER);
               instructions.setForeground(Color.BLACK);
               Font instructionsFont = new Font("Serif", Font.PLAIN, 55);
               instructions.setFont(instructionsFont);
               add(instructions);
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

     // class Airstikes extends JPanel implements ActionListener{
     //
     // }
     //
     // class Aftermath extends JPanel implements ActionListener{
     //
     //
     // }
     //
     // class GroundInvasion extends JPanel implements ActionListener{
     //
     //
     // }
     //
     // class Life extends JPanel implements ActionListener{
     //
     //
     // }
}

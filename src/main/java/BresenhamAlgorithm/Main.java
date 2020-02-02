package BresenhamAlgorithm;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Implementation of Bresenham Algorithm.
 * 
 * @author stivenramireza
 * @version 1.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int exercise = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter 1. Class challenge, 2. Homework challenge"));
      JFrame frame = new JFrame("Bresenham Algorithm");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      if(exercise == 1 | exercise == 2) {
        frame.add(new Bresenham(exercise));
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      } else {
        JOptionPane.showMessageDialog(null, "Execute the program again!", "Error!", JOptionPane.ERROR_MESSAGE);
      }
    }
    
}

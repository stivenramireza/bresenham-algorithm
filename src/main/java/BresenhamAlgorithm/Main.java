package BresenhamAlgorithm;

import javax.swing.JFrame;

/**
 * Implementation of Bresenham Algorithm
 * @author stivenramireza
 * @version 1.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      JFrame frame = new JFrame("Bresenham Algorithm");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(new Bresenham());
      frame.setSize(400, 400);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
  }
    
}

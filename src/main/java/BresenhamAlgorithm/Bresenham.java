package BresenhamAlgorithm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.JPanel;

/**
 *
 * Implementation of Bresenham Algorithm
 * @author stivenramireza
 * @version 1.0
 */
public class Bresenham extends JPanel {
    
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.blue);

    Dimension size = getSize();
    Insets insets = getInsets();

    int w =  size.width - insets.left - insets.right;
    int h =  size.height - insets.top - insets.bottom;

    paintLine(g2d, w, h);
  }
  
  public void paintLine(Graphics g2d, int w, int h) {
    int x1 = 50;
    int y1 = 50;
    int x2 = 150;
    int y2 = 100;
    int dx = Math.abs(x2 - x1);
    int dy = Math.abs(y2 - y1);

    g2d.drawLine(0, (h / 2), w, (h / 2));
    g2d.drawLine((w / 2), 0, (w / 2), h);

    int incE = 2 * dy;
    int incNE = 2 * dy - 2 * dx;
    int d = 2 * dy - dx;
    int y = y1;  
      
    for (int x = x1; x <= x2; x++) {
        int xp = x + w / 2;
        int yp = h / 2 - y;
        g2d.drawLine(xp, yp, xp, yp);
        if (d <= 0) {
           d += incE;
        } else {
           d += incNE;
           y += 1;
        }
    }
  }
}
package BresenhamAlgorithm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;

/**
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

    // paint1(g2d, w, h);
    paint2(g2d, w, h);
  }
  
  public void paint1(Graphics g2d, int w, int h) {
    Point p0 = new Point(50, 50);
    Point p1 = new Point(150, 100);

    g2d.drawLine(0, (h / 2), w, (h / 2));
    g2d.drawLine((w / 2), 0, (w / 2), h);
    
    List<Point> points = applyBresenham(p0, p1);
    for (Point p : points) {
      int xp = p.getX() + w / 2;
      int yp = h / 2 - p.getY();
      g2d.drawLine(xp, yp, xp, yp);
    }
  }
  
  public void paint2(Graphics g2d, int w, int h) {
      for(int dx = 0; dx < w; dx += 10) {
          paintLines(g2d, dx, 0, w, dx, w, h);
          paintLines(g2d, w, dx, w - dx, h, w, h);
          paintLines(g2d, w - dx, h, 0, h - dx, w, h);
          paintLines(g2d, 0, h - dx, dx, 0, w, h);
      }
  }
  
  public void paintLines(Graphics g2d, int x0, int y0, int x1, int y1, int w, int h) {
      Point p0 = new Point(x0, y0);
      Point p1 = new Point(x1, y1);
      List<Point> points = applyBresenham(p0, p1);
      for (Point p : points) {
        int xp = p.getX();
        int yp = h - p.getY();
        g2d.drawLine(xp, yp, xp, yp);
      }
  }
  
  public List<Point> applyBresenham(Point p1, Point p2) {
    int x1 = p1.getX();
    int y1 = p1.getY();
    int x2 = p2.getX();
    int y2 = p2.getY();
    List<Point> points = new ArrayList<>();
    int dy = Math.abs(y2 - y1);
    int dx = Math.abs(x2 - x1);
     
    int incE = 2 * dy;
    int incNE = 2 * dy - 2 * dx;
    int d = 2 * dy - dx;
    int y = y1;  
      
    for (int x = x1; x <= x2; x++) {
        int xp = x;
        int yp = y;
        points.add(new Point(xp, yp));
        if (d <= 0) {
           d += incE;
        } else {
           d += incNE;
           y += 1;
        }
    }
    return points;
  }
  
}
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
 * Implementation of Bresenham Algorithm.
 * 
 * @author stivenramireza
 * @version 1.0
 * @date 01/02/2020
 */
public class Bresenham extends JPanel {
    private int exercise;
    
   public Bresenham(int exercise) {
       this.exercise = exercise;
   }
  
  /**
   * Paint window.
   * 
   * @param g Graphics 2D
   */  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.blue);

    Dimension size = getSize();
    Insets insets = getInsets();

    int w =  size.width - insets.left - insets.right;
    int h =  size.height - insets.top - insets.bottom;
    
    if(exercise == 1) {
        paint1(g2d, w, h);
    }else if(exercise == 2) {
        paint2(g2d, w, h);
    }
  }
  
  /**
   * Execute class challenge.
   * 
   * @param g2d Graphics 2D
   * @param w Window width
   * @param h Window height
   */
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
  
  /**
   * Execute homework challenge.
   * 
   * @param g2d Graphics 2D
   * @param w Window width
   * @param h Window height
   */
  public void paint2(Graphics g2d, int w, int h) {
      for(int dx = 0; dx < w; dx += 10) {
          paintLines(g2d, dx, 0, w, dx, h);
          paintLines(g2d, w, dx, w - dx, h, h);
          paintLines(g2d, w - dx, h, 0, h - dx, h);
          paintLines(g2d, 0, h - dx, dx, 0, h);
      }
  }
  
  /**
   * Paint lines based on Bresenham algorithm.
   * 
   * @param g2d Graphics 2D
   * @param x0 coordinate
   * @param y0 coordinate
   * @param x1 coordinate
   * @param y1 coordinate
   * @param h Window height
   */
  public void paintLines(Graphics g2d, int x0, int y0, int x1, int y1, int h) {
      Point p0 = new Point(x0, y0);
      Point p1 = new Point(x1, y1);
      List<Point> points = applyBresenham(p0, p1);
      for (Point p : points) {
        int xp = p.getX();
        int yp = h - p.getY();
        g2d.drawLine(xp, yp, xp, yp);
      }
  }
  
  /**
   * Source: https://rosettacode.org/wiki/Bitmap/Bresenham%27s_line_algorithm#Java
   * 
   * @param p1 Point 1
   * @param p2 Point 2
   * @return List of points to paint
   */
  public List<Point> applyBresenham(Point p1, Point p2) {
    int x1 = p1.getX();
    int y1 = p1.getY();
    int x2 = p2.getX();
    int y2 = p2.getY();
    List<Point> points = new ArrayList<>();
    int dy = y2 - y1;
    int dx = x2 - x1;
    int incYi, incXi, incXf, incYf;
    if (dy >= 0) {
        incYi = 1;
    } else {
        dy = -dy;
        incYi = -1;
    }
    if (dx >= 0) {
        incXi = 1;
    } else {
        dx = -dx;
        incXi = -1;
    }
    if (dx >= dy) {
        incYf = 0;
        incXf = incXi;
    } else {
        incXf = 0;
        incYf = incYi;
        dx ^= dy;
        dy ^= dx;
        dx ^= dy;
    }
    int x = x1;
    int y = y1;
    int incE = 2 * dy;
    int d = incE - dx;
    int incNE = d - dx;
    while(x != x2){
        int xp = x;
        int yp = y;
        points.add(new Point(xp, yp));
        if (d <= 0) {
            x += incXf;
            y += incYf;
            d += incE;
        } else {
            x += incXi;
            y += incYi;
            d += incNE;
        }
    }
    return points;    
  }
  
}
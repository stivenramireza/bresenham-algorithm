package BresenhamAlgorithm;

/**
 * Implementation of Bresenham Algorithm.
 * 
 * @author stivenramireza
 * @version 1.0
 */
public class Point {
    
    private int x;
    private int y;
    
    /**
     * Constructor Point Class.
     * 
     * @param x Coordinate X
     * @param y Coordinate Y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Get the value of x.
     * 
     * @return x coordinate
     */
    public int getX() {
        return x;
    }
    
    /**
     * Change the value of x.
     * 
     * @param x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Get the value of y.
     * 
     * @return y coordinate
     */
    public int getY() {
        return y;
    }
    
    /**
     * Change the value of y.
     * 
     * @param y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }
    
}
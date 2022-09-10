
// ----------------------------------------------------------
/**
 * Rectangle Class
 * Description: Object class that creates a Rectangle object when evoked
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * 
 */
public class Rectangle {

    private int x;
    private int y;
    private int width;
    private int height;

    // ----------------------------------------------------------
    /**
     * Rectangle Constructor
     * 
     * @param x
     *            Takes in the specified x coordinate for rectangle placement
     * @param y
     *            Takes in the specified y coordinate for rectangle placement
     * @param width
     *            Takes in the specified width for rectangle size
     * @param height
     *            Takes in the specified height for rectangle size
     */
    public Rectangle(int x, int y, int width, int height) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }


    /**
     * Description: Checks if object passed in is equal to this Rectangle object
     * 
     * @return Returns true if the the same and false otherwise
     * 
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }
        else if (this.getClass().equals(other.getClass())) {
            Rectangle otherRect = (Rectangle)other;
            if (this.getX() != otherRect.getX() || this.getY() != otherRect
                .getY() || this.getWidth() != otherRect.getWidth() || this
                    .getHeight() != otherRect.getHeight()) {
                return false;
            }
            return true;
        }
        return false;
    }


    /**
     * Description: Checks if rectangle passed in is intersecting this rectangle
     * 
     * @return Returns true if the the same and false otherwise
     * 
     */
    public boolean isIntersecting(Rectangle input) {
        if ((withinBounds(this.x, this.width, input.x, input.width)
            && (withinBounds(this.y, this.height, input.y, input.height)))) {
            return true;
        }

        return false;
    }


    /**
     * Description: Returns the x coordinate
     * 
     * @return the x
     * 
     */
    public int getX() {
        return x;
    }


    /**
     * Description: Set the x coordinate value
     * 
     * @param x
     *            the x to set
     */
    public void setX(int x) {
        this.x = x;
    }


    /**
     * Description: Returns the y coordinate
     * 
     * @return the y
     * 
     */
    public int getY() {
        return y;
    }


    /**
     * Description: Set the y coordinate value
     * 
     * @param y
     *            the y to set
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * Description: Returns the width of rectangle
     * 
     * @return the width
     * 
     */
    public int getWidth() {
        return width;
    }


    /**
     * Description: Set the width of the rectangle
     * 
     * @param width
     *            the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }


    /**
     * Description: Returns the height of rectangle
     * 
     * @return the height
     * 
     */
    public int getHeight() {
        return height;
    }


    /**
     * Description: Set the height of the rectangle
     * 
     * @param height
     *            the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }


    /**
     * Description: Returns the string representation of Rectangle information
     * 
     * @return string of rectangle
     * 
     */
    public String toString() {

        return x + ", " + y + ", " + width + ", " + height;

    }


    /**
     * Description: Checks of coordinates are within bounds
     * 
     * @return true if it is within bounds else false if otherwise
     * 
     */
    private boolean withinBounds(int aCoord, int aDim, int bCoord, int bDim) {
        if (bCoord >= aCoord && bCoord < aCoord + aDim) {
            return true;
        }
        if (aCoord >= bCoord && aCoord < bCoord + bDim) {
            return true;
        }
        return false;
    }
}

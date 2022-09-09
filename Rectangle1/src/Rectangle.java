public class Rectangle {

    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }


    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
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


    // returns true if both rectangles overlap somewhere
    // Figure out every case for Deep
    // NOTE: do we need to worry about negatives? nulls not necessary but maybe
    // VERY IMPORTANT: stacked the double ifs into one if to make coverage easier (or is it harder?) and logic easier
    // need for webcat?
    // are certain cases impossible to test due to double iffing???
    public boolean isIntersecting(Rectangle input) {
        if ((this.x >= input.x && this.x < input.x + input.width) && (this.y >= input.y && this.y < input.y + input.height)) {
            
            return true;
        }
        if ((this.x >= input.x && this.x < input.x + input.width) && (input.y >= this.y && input.y < this.y + this.height)) {
            
            return true;
        }
        
        if ((input.x >= this.x && input.x < this.x + this.width)) {
            if (input.y >= this.y && input.y < this.y + this.height) {
                return true;
            }
            if (this.y >= input.y && this.y < input.y + input.height) {
                return true;
            }
        }
        return false;
    }


    /**
     * @return the x
     */
    public int getX() {
        return x;
    }


    /**
     * @param x
     *            the x to set
     */
    public void setX(int x) {
        this.x = x;
    }


    /**
     * @return the y
     */
    public int getY() {
        return y;
    }


    /**
     * @param y
     *            the y to set
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }


    /**
     * @param width
     *            the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }


    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }


    /**
     * @param height
     *            the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }


    public String toString() {

        return x + ", " + y + ", " + width + ", " + height;

    }
}

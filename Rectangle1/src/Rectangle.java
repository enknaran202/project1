public class Rectangle
{

    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height)
    {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }


    public boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }

        if (other == null)
        {
            return false;
        }
        if (this.getClass().equals(other.getClass()))
        {
            Rectangle otherRect = (Rectangle)other;
            if (this.getX() != otherRect.getX() || this.getY() != otherRect
                .getY() || this.getWidth() != otherRect.getWidth() || this
                    .getHeight() != otherRect.getHeight())
            {
                return false;
            }
            return true;
        }
        return false;
    }


    // !QUESTION!
    // How do I pass in a SkipList? Is <?,?> ok?
    // should this return string or can it be a SkipList?
    //
    // Report all rectangles in database that intersect with the given region
    // Pre: Width and Height MUST both be greater than zero
    // Must OVERLAP not just touch
    public String regionSearch(SkipList<?, ?> list, int x, int y, int w, int h)
    {
        // list.
        return "";
    }


    // returns true if both rectangles overlap somewhere
    // Figure out every case for Deep
    public boolean isIntersecting(Rectangle input)
    {
        if (this.x >= input.x && this.x < input.x + input.width)
        {
            if (this.y >= input.y && this.y < input.y + input.height)
            {
                return true;
            }
            if (input.y >= this.y && input.y < this.y + this.height)
            {
                return true;
            }
        }
        if ((input.x >= this.x && input.x < this.x + this.width))
        {
            if (input.y >= this.y && input.y < this.y + this.height)
            {
                return true;
            }
            if (this.y >= input.y && this.y < input.y + input.height)
            {
                return true;
            }
        }
        return false;
    }


    /**
     * @return the x
     */
    public int getX()
    {
        return x;
    }


    /**
     * @param x
     *            the x to set
     */
    public void setX(int x)
    {
        this.x = x;
    }


    /**
     * @return the y
     */
    public int getY()
    {
        return y;
    }


    /**
     * @param y
     *            the y to set
     */
    public void setY(int y)
    {
        this.y = y;
    }


    /**
     * @return the width
     */
    public int getWidth()
    {
        return width;
    }


    /**
     * @param width
     *            the width to set
     */
    public void setWidth(int width)
    {
        this.width = width;
    }


    /**
     * @return the height
     */
    public int getHeight()
    {
        return height;
    }


    /**
     * @param height
     *            the height to set
     */
    public void setHeight(int height)
    {
        this.height = height;
    }


    public String toString()
    {

        return "(" + x + ", " + y + ", " + width + ", " + height + ")";

    }
}

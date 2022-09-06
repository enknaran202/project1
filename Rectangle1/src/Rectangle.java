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
    
    public static boolean equals(int x, int y, int w, int h, Rectangle rect)
    {
        return (rect.x == x && rect.y == y && rect.width == w && rect.height == h);
    }

    // !QUESTION!
    // How do I pass in a SkipList? Is <?,?> ok?
    // should this return string or boolean?
    // 
    // Report all rectangles in database that intersect with the given region
    // Pre: Width and Height MUST both be greater than zero
    // Must OVERLAP not just touch
    public String regionSearch(SkipList<?, ?> list, int x, int y, int w, int h)
    {
        //list.
        return "";
    }
    public boolean isIntersecting(Rectangle input)
    {
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

        return x + ", " + y + ", " + width + ", " + height;

    }
}

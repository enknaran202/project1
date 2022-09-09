
/**
 * 
 */
import student.TestCase;

/**
 * @author Deep Datta, (name here)
 *         Note: make sure to write comments and concerns later
 */
public class RectangleTest extends TestCase
{

    private Rectangle rect;

    public void setUp()
    {

        rect = new Rectangle(1, 1, 1, 1);

    }


    public void testEquals()
    {

        assertTrue(rect.equals(rect));
        assertFalse(rect.equals(null));
        Object obj = new Object();
        assertFalse(rect.equals(obj));
        Rectangle same = new Rectangle(1, 1, 1, 1);
        assertTrue(rect.equals(same));
        Rectangle ret1 = new Rectangle(2, 1, 1, 1);
        assertFalse(rect.equals(ret1));
        Rectangle ret2 = new Rectangle(1, 2, 1, 1);
        assertFalse(rect.equals(ret2));
        Rectangle ret3 = new Rectangle(1, 1, 2, 1);
        assertFalse(rect.equals(ret3));
        Rectangle ret4 = new Rectangle(1, 1, 1, 2);
        assertFalse(rect.equals(ret4));
        Rectangle ret5 = new Rectangle(2, 2, 1, 1);
        assertFalse(rect.equals(ret5));
        Rectangle ret6 = new Rectangle(2, 1, 2, 1);
        assertFalse(rect.equals(ret6));
        Rectangle ret7 = new Rectangle(2, 1, 1, 2);
        assertFalse(rect.equals(ret7));
        Rectangle ret8 = new Rectangle(1, 2, 2, 1);
        assertFalse(rect.equals(ret8));
        Rectangle ret9 = new Rectangle(1, 2, 1, 2);
        assertFalse(rect.equals(ret9));
        Rectangle ret10 = new Rectangle(1, 1, 2, 2);
        assertFalse(rect.equals(ret10));
        Rectangle ret11 = new Rectangle(2, 2, 1, 2);
        assertFalse(rect.equals(ret11));
        Rectangle ret12 = new Rectangle(2, 1, 2, 2);
        assertFalse(rect.equals(ret12));
        Rectangle ret13 = new Rectangle(1, 2, 2, 2);
        assertFalse(rect.equals(ret13));
        Rectangle ret14 = new Rectangle(2, 2, 2, 1);
        assertFalse(rect.equals(ret14));
        Rectangle ret15 = new Rectangle(2, 2, 2, 2);
        assertFalse(rect.equals(ret15));
    }


    public void testIsIntesecting()
    {
        Rectangle test = new Rectangle(5, 5, 5, 5);
        assertTrue(test.isIntersecting(new Rectangle(5,5,4,4)));
        assertFalse(test.isIntersecting(new Rectangle(5,1,1,1)));
        assertFalse(test.isIntersecting(new Rectangle(1,5,1,1)));
        assertFalse(test.isIntersecting(new Rectangle(11,1,1,1)));
        assertFalse(test.isIntersecting(new Rectangle(1,11,1,1)));
        assertTrue(test.isIntersecting(new Rectangle(4,4,4,4)));
    }


    public void testGetX()
    {

        assertEquals(1, rect.getX());
        assertNotSame(2, rect.getX());

    }


    public void testSetX()
    {

        assertEquals(1, rect.getX());
        rect.setX(0);
        assertEquals(0, rect.getX());
        rect.setX(1);
        assertEquals(1, rect.getX());
    }


    public void testGetY()
    {

        assertEquals(1, rect.getY());
        assertNotSame(2, rect.getY());

    }


    public void testSetY()
    {

        assertEquals(1, rect.getY());
        rect.setY(0);
        assertEquals(0, rect.getY());
        rect.setY(3);
        rect.setY(1);
        assertEquals(1, rect.getY());
    }


    public void testGetWidth()
    {

        assertEquals(1, rect.getWidth());
        assertNotSame(2, rect.getWidth());

    }


    public void testSetWidth()
    {

        assertEquals(1, rect.getWidth());
        rect.setWidth(0);
        assertEquals(0, rect.getWidth());
        rect.setWidth(3);
        rect.setWidth(1);
        assertEquals(1, rect.getWidth());

    }


    public void testGetHeight()
    {

        assertEquals(1, rect.getHeight());
        assertNotSame(2, rect.getHeight());

    }


    public void testSetHeight()
    {

        assertEquals(1, rect.getHeight());
        rect.setHeight(0);
        assertEquals(0, rect.getHeight());
        rect.setHeight(3);
        rect.setHeight(1);
        assertEquals(1, rect.getHeight());

    }


    public void testToString()
    {

        assertEquals("1, 1, 1, 1", rect.toString());
        Rectangle rect = new Rectangle(2, 2, 10, 10);
        assertEquals("2, 2, 10, 10", rect.toString());

    }

}

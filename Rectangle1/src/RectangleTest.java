/**
 * 
 */
import student.TestCase;
/**
 @author Deep Datta, (name here)
 * Note: make sure to write comments and concerns later
 */
public class RectangleTest extends TestCase{
    
    private Rectangle rect;
    
    public void setUp() {
        
        rect = new Rectangle(1,1,1,1);
        
    }
    
    // NEED TO CHANGE
    // rect.equals(testRec);
    public void testEquals() {
        
        assertTrue(Rectangle.equals(1,1,1,1,rect));
        assertFalse(Rectangle.equals(0,1,1,1, rect));
        assertFalse(Rectangle.equals(1,0,1,1, rect));
        assertFalse(Rectangle.equals(1,1,0,1, rect));
        assertFalse(Rectangle.equals(1,1,1,0, rect));
        assertFalse(Rectangle.equals(0,0,1,1, rect));
        assertFalse(Rectangle.equals(0,1,0,1, rect));
        assertFalse(Rectangle.equals(1,0,0,1, rect));
        assertFalse(Rectangle.equals(0,1,1,0, rect));
        assertFalse(Rectangle.equals(1,0,1,0, rect));
        assertFalse(Rectangle.equals(1,1,0,0, rect));
        
    } 
   
    public void testIsIntesecting() {
        
        // Note: not sure if needed 
        
    }
    
    public void testGetX() {
        
        assertEquals(1, rect.getX());
        assertNotSame(2, rect.getX());
        
        
    }
    
    public void testSetX() {
        
        assertEquals(1, rect.getX());
        rect.setX(0);
        assertEquals(0, rect.getX());
        rect.setX(1);
        assertEquals(1, rect.getX());
    }
    
    public void testGetY() {
        
        assertEquals(1, rect.getY());
        assertNotSame(2, rect.getY());
        
    }
    
    public void testSetY() {
        
        assertEquals(1, rect.getY());
        rect.setY(0);
        assertEquals(0, rect.getY());
        rect.setY(3);
        rect.setY(1);
        assertEquals(1, rect.getY());
    }
    
    public void testGetWidth() {
        
        assertEquals(1, rect.getWidth());
        assertNotSame(2, rect.getWidth());
        
    }
    
    public void testSetWidth() {
        
        assertEquals(1, rect.getWidth());
        rect.setWidth(0);
        assertEquals(0, rect.getWidth());
        rect.setWidth(3);
        rect.setWidth(1);
        assertEquals(1, rect.getWidth());
        
    }
    
    public void testGetHeight() {
        
        assertEquals(1, rect.getHeight());
        assertNotSame(2, rect.getHeight());
        
    }
    
    public void testSetHeight() {
        
        assertEquals(1, rect.getHeight());
        rect.setHeight(0);
        assertEquals(0, rect.getHeight());
        rect.setHeight(3);
        rect.setHeight(1);
        assertEquals(1, rect.getHeight());
        
    }
    
    public void testToString() {
        
        assertEquals("1, 1, 1, 1", rect.toString());
        Rectangle rect = new Rectangle(2,2,10,10);
        assertEquals("2, 2, 10, 10", rect.toString());
        
        
    }

}
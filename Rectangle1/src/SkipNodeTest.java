/**
 * 
 */
import student.TestCase;
import java.lang.reflect.Array;
/**
 * @author Deep Datta, (name here)
 * Note: make sure to write comments and concerns later
 */
public class SkipNodeTest extends TestCase{
    
    private SkipNode<String, String> skip;
    
    
    public void setUp() {
        
        skip = new SkipNode<String, String>("test", "test", 1);
        
    }
    
    public void testGetElement() {
        
        assertEquals("test", skip.element());
        SkipNode<String, String> skip = new SkipNode<String, String>("test", "hi", 1);
        assertEquals("hi", skip.element());
        SkipNode<String, String> skip2 = new SkipNode<String, String>("test", null, 1);
        assertNull(skip2.element());
        assertNotNull(skip.element());
        SkipNode<String, String> skip3 = new SkipNode<String, String>("test", "", 2);
        assertEquals("", skip3.element());
        
        
    }
    
    public void testGetKey() {
        
        assertEquals("test", skip.key());
        SkipNode<String, String> skip = new SkipNode<String, String>("hi", "test", 1);
        assertEquals("hi", skip.key());
        SkipNode<String, String> skip2 = new SkipNode<String, String>(null, "test", 1);
        assertNull(skip2.key());
        assertNotNull(skip.key());
        SkipNode<String, String> skip3 = new SkipNode<String, String>("", "skip", 2);
        assertEquals("", skip3.key());
        
        
    }
    
    public void testGetPair() {
        
        assertEquals("(test, test)",skip.pair().toString());
        SkipNode<String, String> skip = new SkipNode<String, String>("hi", "test", 1);
        assertEquals("(hi, test)", skip.pair().toString());
        SkipNode<String, String> skip2 = new SkipNode<String, String>(null, "test", 1);
        assertNull(skip2.pair().key());
        assertNotNull(skip.pair().key());
        SkipNode<String, String> skip3 = new SkipNode<String, String>("", "skip", 2);
        assertEquals("(, skip)", skip3.pair().toString());
        
        
    }
    
    public void testToString() {
        
        assertEquals("(test, test)",skip.toString());
        SkipNode<String, String> skip = new SkipNode<String, String>("hi", "test", 1);
        assertEquals("(hi, test)", skip.toString());    
        SkipNode<String, String> skip3 = new SkipNode<String, String>("", "skip", 2);
        assertEquals("(, skip)", skip3.toString());
        
    }
    
    public void testGetForward() {
       
        //SkipNode<String, String>[] array = {new SkipNode<String, String>("test", "test", 1)};
        assertEquals("", skip.getForward().);
        
    }
    
    public void testSetForward() {
        
        
    }

}

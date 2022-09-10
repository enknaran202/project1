
/**
 * 
 */
import student.TestCase;
import java.lang.reflect.Array;

// ----------------------------------------------------------
/**
 * SkipNodeTest Class
 * Description: Test class for SkipNodeTest object
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * 
 */
public class SkipNodeTest extends TestCase {

    private SkipNode<String, String> skip;

    // ----------------------------------------------------------
    /**
     * 
     * Description: Sets up test objects to be used
     * 
     */
    public void setUp() {

        skip = new SkipNode<String, String>("test", "test", 1);
        KVPair<String, String> pair = new KVPair<String, String>("test",
            "test");
        @SuppressWarnings("unused")
        SkipNode<String, String> construct = new SkipNode<String, String>(
            "test", "test", 1);

    }


    // ----------------------------------------------------------
    /**
     * 
     * Description: Tests the getter method to get the element from the SkipNode
     * 
     */
    public void testGetElement() {

        assertEquals("test", skip.element());
        SkipNode<String, String> skip = new SkipNode<String, String>("test",
            "hi", 1);
        assertEquals("hi", skip.element());
        SkipNode<String, String> skip2 = new SkipNode<String, String>("test",
            null, 1);
        assertNull(skip2.element());
        assertNotNull(skip.element());
        SkipNode<String, String> skip3 = new SkipNode<String, String>("test",
            "", 2);
        assertEquals("", skip3.element());

    }


    // ----------------------------------------------------------
    /**
     * 
     * Description: Tests the getter method to get the key element from the
     * SkipNode
     * 
     */
    public void testGetKey() {

        assertEquals("test", skip.key());
        SkipNode<String, String> skip = new SkipNode<String, String>("hi",
            "test", 1);
        assertEquals("hi", skip.key());
        SkipNode<String, String> skip2 = new SkipNode<String, String>(null,
            "test", 1);
        assertNull(skip2.key());
        assertNotNull(skip.key());
        SkipNode<String, String> skip3 = new SkipNode<String, String>("",
            "skip", 2);
        assertEquals("", skip3.key());

    }


    // ----------------------------------------------------------
    /**
     * 
     * Description: Tests the getter method to get the key-value pair from
     * SkipNode
     * 
     */
    public void testGetPair() {

        assertEquals("test, test", skip.pair().toString());
        SkipNode<String, String> skip = new SkipNode<String, String>("hi",
            "test", 1);
        assertEquals("hi, test", skip.pair().toString());
        SkipNode<String, String> skip2 = new SkipNode<String, String>(null,
            "test", 1);
        assertNull(skip2.pair().key());
        assertNotNull(skip.pair().key());
        SkipNode<String, String> skip3 = new SkipNode<String, String>("",
            "skip", 2);
        assertEquals(", skip", skip3.pair().toString());

    }


    // ----------------------------------------------------------
    /**
     * 
     * Description: Tests the toString method to see if it is SkipNode is
     * represented correctly
     * 
     */
    public void testToString() {

        assertEquals("test, test", skip.toString());
        SkipNode<String, String> skip = new SkipNode<String, String>("hi",
            "test", 1);
        assertEquals("hi, test", skip.toString());
        SkipNode<String, String> skip3 = new SkipNode<String, String>("",
            "skip", 2);
        assertEquals(", skip", skip3.toString());

    }


    // ----------------------------------------------------------
    /**
     * 
     * Description: Tests the method goes forward through the array of SkipNodes
     * stored
     * 
     */
    @SuppressWarnings("unchecked")
    public void testGetForward() {

        skip.setForward(new SkipNode[5]);
        for (int i = 0; i < 5; i++) {

            skip.getForward()[i] = new SkipNode<String, String>("test", "test",
                1);
            assertEquals("test", skip.getForward()[i].key());
            assertEquals("test", skip.getForward()[i].element());

        }

    }


    // ----------------------------------------------------------
    /**
     * 
     * Description: Tests the method that sets the next SkipNode in the array
     * 
     */
    @SuppressWarnings("unchecked")
    public void testSetForward() {

        skip.setForward(new SkipNode[5]);
        for (int i = 0; i < 5; i++) {

            skip.getForward()[i] = new SkipNode<String, String>("test", "test",
                1);
            assertEquals("test", skip.getForward()[i].key());
            assertEquals("test", skip.getForward()[i].element());

        }
    }

}

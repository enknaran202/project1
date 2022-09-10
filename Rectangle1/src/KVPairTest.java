
/**
 * 
 */
import student.TestCase;

// ----------------------------------------------------------
/**
 * KVPairTest Class
 * Description: Test class for KVPairTest object
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * 
 */

public class KVPairTest extends TestCase {

    private KVPair<String, Rectangle> pair;

    // ----------------------------------------------------------
    /**
     * 
     * Description: Sets up test object to be used
     * 
     */
    public void setUp() {

        pair = new KVPair<String, Rectangle>("start", new Rectangle(1, 2, 5,
            5));

    }


    // ----------------------------------------------------------
    /**
     * 
     * Description: Tests the compareTo KVPair version method used in the KVPair
     * class
     * 
     */
    public void testCompareToKVPair() {

        assertEquals(0, pair.compareTo(pair));
        KVPair<String, Rectangle> pair2 = new KVPair<String, Rectangle>(
            "middle", new Rectangle(5, 5, 5, 5));
        assertEquals(6, pair.compareTo(pair2));
        assertEquals(-6, pair2.compareTo(pair));
        KVPair<String, Rectangle> pair3 = new KVPair<String, Rectangle>(
            "zzzzzz", new Rectangle(-100, -100, -100, -100));
        assertEquals(-7, pair.compareTo(pair3));
        KVPair<String, Rectangle> pairSame = new KVPair<String, Rectangle>(
            "start", new Rectangle(1, 2, 5, 5));
        assertEquals(0, pair.compareTo(pairSame));

    }


    // ----------------------------------------------------------
    /**
     * 
     * Description: Tests the compareTo key version method used in the KVPair
     * class
     * 
     */
    public void testCompareToKey() {

        assertEquals(0, pair.compareTo("start"));
        KVPair<String, Rectangle> pair2 = new KVPair<String, Rectangle>(
            "middle", new Rectangle(5, 5, 5, 5));
        assertEquals(6, pair.compareTo(pair2.key()));
        assertEquals(-6, pair2.compareTo(pair.key()));
        KVPair<String, Rectangle> pair3 = new KVPair<String, Rectangle>(
            "zzzzzz", new Rectangle(-100, -100, -100, -100));
        assertEquals(-7, pair.compareTo(pair3.key()));
        KVPair<String, Rectangle> pairSame = new KVPair<String, Rectangle>(
            "start", new Rectangle(1, 2, 5, 5));
        assertEquals(0, pair.compareTo(pairSame.key()));

    }


    // ----------------------------------------------------------
    /**
     * 
     * Description: Tests the getter key method used in the KVPair class
     * 
     */
    public void testKey() {

        assertEquals("start", pair.key());
        KVPair<String, Rectangle> pair2 = new KVPair<String, Rectangle>(
            "middle", new Rectangle(5, 5, 5, 5));
        assertEquals("middle", pair2.key());
        KVPair<String, Rectangle> pair3 = new KVPair<String, Rectangle>(null,
            new Rectangle(5, 5, 5, 5));
        assertNull(pair3.key());
        KVPair<String, Rectangle> pair4 = new KVPair<String, Rectangle>("",
            new Rectangle(5, 5, 5, 5));
        assertEquals("", pair4.key());

    }


    // ----------------------------------------------------------
    /**
     * 
     * Description: Tests the getter value method used in the KVPair class
     * 
     */
    public void testValue() {

        Rectangle same = pair.value();
        assertEquals(same, pair.value());
        KVPair<String, Rectangle> pair2 = new KVPair<String, Rectangle>(
            "middle", new Rectangle(5, 5, 5, 5));
        Rectangle same2 = pair2.value();
        assertEquals(same2, pair2.value());
        KVPair<String, Rectangle> pair3 = new KVPair<String, Rectangle>("null",
            null);
        assertNull(pair3.value());

    }


    // ----------------------------------------------------------
    /**
     * 
     * Description: Tests the toString method for right input used in the KVPair
     * class
     * 
     */
    public void testToString() {

        assertEquals("start, 1, 2, 5, 5", pair.toString());
        KVPair<String, Rectangle> pair2 = new KVPair<String, Rectangle>(
            "middle", new Rectangle(5, 5, 5, 5));
        assertEquals("middle, 5, 5, 5, 5", pair2.toString());
        KVPair<String, Rectangle> pair4 = new KVPair<String, Rectangle>("",
            new Rectangle(5, 5, 5, 5));
        assertEquals(", 5, 5, 5, 5", pair4.toString());

    }

}

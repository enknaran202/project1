
/**
 * 
 */
import student.TestCase;

/**
 * @author Deep Datta, Enk Naran
 *         Note: make sure to write comments and concerns later
 * 
 */
public class KVPairTest extends TestCase
{

    private KVPair<String, Rectangle> pair;

    public void setUp()
    {

        pair = new KVPair<String, Rectangle>("start", new Rectangle(1, 2, 5,
            5));

    }


    public void testCompareToKVPair()
    {

        assertEquals(0, pair.compareTo(pair));
        KVPair<String, Rectangle> pair2 = new KVPair<String, Rectangle>(
            "middle", new Rectangle(5, 5, 5, 5));
        assertTrue(pair.compareTo(pair2) >= 1);
        assertFalse(pair.compareTo(pair2) < 1);
        KVPair<String, Rectangle> pair3 = new KVPair<String, Rectangle>(
            "zzzzzz", new Rectangle(-100, -100, -100, -100));
        assertTrue(pair.compareTo(pair3) < 1);

    }


    public void testCompareToKey()
    {

        assertEquals(0, pair.compareTo("start"));
        KVPair<String, Rectangle> pair2 = new KVPair<String, Rectangle>(
            "middle", new Rectangle(5, 5, 5, 5));
        assertTrue(pair.compareTo(pair2.key()) >= 1);
        assertFalse(pair.compareTo(pair2.key()) < 1);
        KVPair<String, Rectangle> pair3 = new KVPair<String, Rectangle>(
            "zzzzzz", new Rectangle(-100, -100, -100, -100));
        assertTrue(pair.compareTo(pair3.key()) < 1);

    }


    public void testKey()
    {

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


    public void testValue()
    {

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


    public void testToString()
    {

        assertEquals("(start, 1, 2, 5, 5)", pair.toString());
        KVPair<String, Rectangle> pair2 = new KVPair<String, Rectangle>(
            "middle", new Rectangle(5, 5, 5, 5));
        assertEquals("(middle, 5, 5, 5, 5)", pair2.toString());
        KVPair<String, Rectangle> pair4 = new KVPair<String, Rectangle>("",
            new Rectangle(5, 5, 5, 5));
        assertEquals("(, 5, 5, 5, 5)", pair4.toString());

    }

}

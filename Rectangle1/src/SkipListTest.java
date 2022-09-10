import student.TestCase;
import java.lang.reflect.Array;
import java.util.Random;
import student.TestableRandom;

/**
 * @author Deep Datta, (name here)
 *         Note: make sure to write comments and concerns later
 * @param <K>
 * @param <E>
 */
public class SkipListTest<K extends Comparable<K>, E> extends TestCase
{

    private SkipList<K, E> list;
    private SkipList<K, E> list2;

    private KVPair<K, E> pair1;
    private KVPair<K, E> pair2;
    private KVPair<K, E> pair3;

    private Rectangle rec1;
    private Rectangle rec2;
    private Rectangle rec3;

    @SuppressWarnings(
    { "unchecked", "rawtypes" })
    public void setUp()
    {

        list = new SkipList<K, E>();
        rec1 = new Rectangle(1, 0, 0, 0);
        rec2 = new Rectangle(2, 0, 0, 0);
        rec3 = new Rectangle(3, 0, 0, 0);
        pair1 = new KVPair("a", rec1);
        pair2 = new KVPair("b", rec2);
        pair3 = new KVPair("c", rec3);

        assertTrue(list.insert(pair1));
        assertTrue(list.insert(pair1));
        assertTrue(list.insert(pair2));

        // Make SkipNodes and populate them with KCPair objects and then
        // Rectangle in each pair
        // Also need a way to test Random
        // Were private methods inadvertently tested or no? (since can't access
        // unless from other methods)

    }


    public void testRandomLevel()
    {
        TestableRandom.setNextBooleans(true, true, true, false);
        assertEquals(3, list.randomLevel());
    }


    public void testInsert()
    {
        TestableRandom.setNextBooleans(true, false);

        assertTrue(list.insert(pair1));
        assertTrue(list.insert(pair1));
        assertTrue(list.insert(pair2));
    }


    public void testSearch()
    {
        assertEquals("Rectangles found:\n(a, 1, 0, 0, 0)\n(a, 1, 0, 0, 0)", list
            .search(pair1.theKey));
        assertEquals("Rectangles found:\n(b, 2, 0, 0, 0)", list.search(
            pair2.theKey));
        assertEquals("Rectangle not found: (c)", list.search(pair3.theKey));
    }


    public void testDump()
    {
        list2 = new SkipList<K, E>();

        TestableRandom.setNextBooleans(true, false);
        list2.insert(pair1);
        TestableRandom.setNextBooleans(true, false);
        list2.insert(pair1);
        TestableRandom.setNextBooleans(true, true, true, false);
        list2.insert(pair2);

        assertEquals("SkipList dump:\n" + "Node has depth 4, Value (null)\n"
            + "Node has a depth 2, Value (a, 1, 0, 0, 0)\n"
            + "Node has a depth 2, Value (a, 1, 0, 0, 0)\n"
            + "Node has a depth 4, Value (b, 2, 0, 0, 0)\n"
            + "SkipList size is: 3", list2.dump());
    }


    public void testRemoveByKey()
    {
        assertEquals(pair1, list.removeByKey(pair1.theKey));
    }


    public void testRemoveByValue()
    {

    }


    public void testRemoveByRectangle()
    {

    }


    public void testRegionSearch()
    {

    }


    public void testIntersections()
    {

    }

}

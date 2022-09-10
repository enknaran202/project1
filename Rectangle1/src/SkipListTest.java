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
    private KVPair<K, E> pair4;

    private Rectangle rec1;
    private Rectangle rec2;
    private Rectangle rec3;
    private Rectangle rec4;

    @SuppressWarnings(
    { "unchecked", "rawtypes" })
    public void setUp()
    {

        list = new SkipList<K, E>();
        rec1 = new Rectangle(1, 0, 0, 0);
        rec2 = new Rectangle(2, 0, 0, 0);
        rec3 = new Rectangle(3, 0, 0, 0);
        rec4 = new Rectangle(3, 0, 0, 0);
        pair1 = new KVPair("1", rec1);
        pair2 = new KVPair("2", rec2);
        pair3 = new KVPair("3", rec3);
        pair4 = new KVPair("4", rec4);

        TestableRandom.setNextBooleans(true, false);
        list.insert(pair1);
        TestableRandom.setNextBooleans(false);
        list.insert(pair2);
        TestableRandom.setNextBooleans(true, true, false);
        list.insert(pair3);
        TestableRandom.setNextBooleans(true, true, true, false);
        list.insert(pair4);

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
        list.insert(pair1);
        assertEquals("Rectangles found:\n(1, 1, 0, 0, 0)\n(1, 1, 0, 0, 0)", list
            .search(pair1.theKey));
        assertEquals("Rectangles found:\n(2, 2, 0, 0, 0)", list.search(
            pair2.theKey));
        KVPair<K, E> notInList = new KVPair("notInList", null);
        assertEquals("Rectangle not found: (notInList)", list.search(
            notInList.theKey));
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
            + "Node has a depth 2, Value (1, 1, 0, 0, 0)\n"
            + "Node has a depth 2, Value (1, 1, 0, 0, 0)\n"
            + "Node has a depth 4, Value (2, 2, 0, 0, 0)\n"
            + "SkipList size is: 3", list2.dump());
    }

// ISSUE WHEN REMOVING LAST NODE
    public void testRemoveByKey()
    {
        KVPair<K, E> notInList = new KVPair("notInList", rec3);
        assertEquals(pair1.toString(), list.removeByKey(pair1.theKey)
            .toString());
        assertEquals("SkipList dump:\n" + "Node has depth 4, Value (null)\n"
            + "Node has a depth 1, Value (2, 2, 0, 0, 0)\n"
            + "Node has a depth 3, Value (3, 3, 0, 0, 0)\n"
            + "Node has a depth 4, Value (4, 3, 0, 0, 0)\n"
            + "SkipList size is: 4", list.dump());
// TestableRandom.setNextBooleans(true, true, true, false);
        assertEquals(pair4.toString(), list.removeByKey(pair4.theKey)
            .toString());
        list.insert(pair4);
        // assertEquals(pair4, list.removeByKey(pair4.theKey));
        assertEquals(pair2.toString(), list.removeByKey(pair2.theKey)
            .toString());

        assertEquals(pair3.toString(), list.removeByKey(pair3.theKey)
            .toString());
        assertEquals(null, list.removeByKey(pair3.theKey));
        assertEquals(null, list.removeByKey(notInList.theKey));
        assertEquals(pair4.toString(), list.removeByKey(pair4.theKey)
            .toString());
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

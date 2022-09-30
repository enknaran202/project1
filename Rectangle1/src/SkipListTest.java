import student.TestCase;
import java.lang.reflect.Array;
import java.util.Random;
import student.TestableRandom;

/**
 * Straightforward test for SkipList
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * @version 9/11/2022
 * @param <K>
 *            Key
 * @param <E>
 *            Element
 */
public class SkipListTest<K extends Comparable<K>, E> extends TestCase
{

    private SkipList<String, Rectangle> list;
    private SkipList<String, Rectangle> listRect;
    private SkipList<String, Rectangle> listRNDM;

    private KVPair<String, Rectangle> pair1;
    private KVPair<String, Rectangle> pair2;
    private KVPair<String, Rectangle> pair3;
    private KVPair<String, Rectangle> pair4;

    private KVPair<String, Rectangle> intersect0;
    private KVPair<String, Rectangle> intersect5;
    private KVPair<String, Rectangle> intersect1;
    private KVPair<String, Rectangle> intersect2;
    private KVPair<String, Rectangle> intersect3;
    private KVPair<String, Rectangle> intersect4;

    private Rectangle rec1;
    private Rectangle rec2;
    private Rectangle rec3;
    private Rectangle rec4;
    private Rectangle rec5;
    private KVPair<String, Rectangle> notInList;

    /**
     * Set up test
     * 
     */
    public void setUp()
    {

        list = new SkipList<String, Rectangle>();
        listRNDM = new SkipList<String, Rectangle>();
        listRect = new SkipList<String, Rectangle>();

        rec1 = new Rectangle(1, 0, 0, 0);
        rec2 = new Rectangle(2, 0, 0, 0);
        rec3 = new Rectangle(3, 0, 0, 0);
        rec4 = new Rectangle(4, 0, 0, 0);

        pair1 = new KVPair<String, Rectangle>("1", rec1);
        pair2 = new KVPair<String, Rectangle>("2", rec2);
        pair3 = new KVPair<String, Rectangle>("3", rec3);
        pair4 = new KVPair<String, Rectangle>("4", rec4);
        notInList = new KVPair<String, Rectangle>("notInList", new Rectangle(9,
            9, 9, 9));

        intersect0 = new KVPair<String, Rectangle>("a", new Rectangle(5, 5, 4,
            4));
        intersect5 = new KVPair<String, Rectangle>("b", new Rectangle(4, 4, 4,
            4));
        intersect1 = new KVPair<String, Rectangle>("c", new Rectangle(5, 1, 1,
            1));
        intersect2 = new KVPair<String, Rectangle>("d", new Rectangle(1, 5, 1,
            1));
        intersect3 = new KVPair<String, Rectangle>("e", new Rectangle(11, 1, 1,
            1));
        intersect4 = new KVPair<String, Rectangle>("f", new Rectangle(1, 11, 1,
            1));

        TestableRandom.setNextBooleans(true, false);
        list.insert(pair1);
        TestableRandom.setNextBooleans(false);
        list.insert(pair2);
        TestableRandom.setNextBooleans(true, true, false);
        list.insert(pair3);
        TestableRandom.setNextBooleans(true, true, true, false);
        list.insert(pair4);

        listRNDM.insert(pair1);
        listRNDM.insert(pair2);
        listRNDM.insert(pair3);
        listRNDM.insert(pair4);

        // Make SkipNodes and populate them with KCPair objects and then
        // Rectangle in each pair
        // Also need a way to test Random
        // Were private methods inadvertently tested or no? (since can't access
        // unless from other methods)

    }


    /**
     * Test random level
     * 
     */
    public void testRandomLevel()
    {
        TestableRandom.setNextBooleans(true, true, true, false);
        assertEquals(3, list.randomLevel());
    }


    /**
     * Test Insert
     * 
     */
    public void testInsert()
    {
        TestableRandom.setNextBooleans(true, false);

        assertTrue(list.insert(pair1));
        assertTrue(list.insert(pair1));
        assertTrue(list.insert(pair2));
    }


    /**
     * Test search
     * 
     */
    public void testSearch()
    {
        list.insert(pair1);
        assertEquals("\n" + "(1, 1, 0, 0, 0)\n" + "(1, 1, 0, 0, 0)", list
            .search(pair1.theKey));
        assertEquals("\n" + "(2, 2, 0, 0, 0)", list.search(pair2.theKey));
        assertEquals(null, list.search(notInList.theKey));
    }


    /**
     * Test dump
     * 
     */
    public void testDump()
    {
        listRect = new SkipList<String, Rectangle>();

        TestableRandom.setNextBooleans(true, false);

        listRect.insert(pair1);
        TestableRandom.setNextBooleans(true, false);
        listRect.insert(pair1);
        TestableRandom.setNextBooleans(true, true, true, false);
        listRect.insert(pair2);

        assertEquals("SkipList dump:\n" + "Node has depth 4, Value (null)\n"
            + "Node has depth 2, Value (1, 1, 0, 0, 0)\n"
            + "Node has depth 2, Value (1, 1, 0, 0, 0)\n"
            + "Node has depth 4, Value (2, 2, 0, 0, 0)\n"
            + "SkipList size is: 3", listRect.dump());
    }


    /**
     * Test RBK
     * 
     */
    public void testRemoveByKey()
    {

        // tests removing the last, deepest node
        assertEquals(pair4.toString(), list.removeByKey(pair4.theKey)
            .toString());
        assertEquals(pair2.toString(), list.removeByKey(pair2.theKey)
            .toString());

        assertEquals(pair3.toString(), list.removeByKey(pair3.theKey)
            .toString());
        assertEquals(null, list.removeByKey(pair3.theKey));
        assertEquals(null, list.removeByKey(notInList.theKey));
        assertEquals(null, list.removeByKey(pair4.theKey));
        assertEquals("SkipList dump:\n" + "Node has depth 2, Value (null)\n"
            + "Node has depth 2, Value (1, 1, 0, 0, 0)\n"
            + "SkipList size is: 1", list.dump());

        assertEquals(pair4.toString(), listRNDM.removeByKey(pair4.theKey)
            .toString());
        assertEquals(pair2.toString(), listRNDM.removeByKey(pair2.theKey)
            .toString());

        assertEquals(pair3.toString(), listRNDM.removeByKey(pair3.theKey)
            .toString());
        assertEquals(null, listRNDM.removeByKey(pair3.theKey));
        assertEquals(null, listRNDM.removeByKey(notInList.theKey));
        assertEquals(null, listRNDM.removeByKey(pair4.theKey));
    }


    /**
     * test RBV
     * 
     */
    public void testRemoveByValue()
    {
        // tests removing the last, deepest node
        // assertEquals("", list.dump());
        assertEquals(pair4.theVal.toString(), list.removeByValue(
            pair4.theVal).theVal.toString());
        assertEquals("SkipList dump:\n" + "Node has depth 3, Value (null)\n"
            + "Node has depth 2, Value (1, 1, 0, 0, 0)\n"
            + "Node has depth 1, Value (2, 2, 0, 0, 0)\n"
            + "Node has depth 3, Value (3, 3, 0, 0, 0)\n"
            + "SkipList size is: 3", list.dump());
        assertEquals(null, list.removeByValue(notInList.theVal));
        assertEquals(pair2.theVal.toString(), list.removeByValue(
            pair2.theVal).theVal.toString());
        assertEquals("SkipList dump:\n" + "Node has depth 3, Value (null)\n"
            + "Node has depth 2, Value (1, 1, 0, 0, 0)\n"
            + "Node has depth 3, Value (3, 3, 0, 0, 0)\n"
            + "SkipList size is: 2", list.dump());

        assertEquals(pair3.theVal.toString(), list.removeByValue(
            pair3.theVal).theVal.toString());

        assertEquals(null, list.removeByValue(pair3.theVal));

        assertEquals(null, list.removeByValue(pair4.theVal));

        assertEquals(null, listRNDM.removeByKey(notInList.theKey));
        assertEquals(pair4.toString(), listRNDM.removeByKey(pair4.theKey)
            .toString());
        assertEquals(pair2.toString(), listRNDM.removeByKey(pair2.theKey)
            .toString());

        assertEquals(pair3.toString(), listRNDM.removeByKey(pair3.theKey)
            .toString());
        assertEquals(null, listRNDM.removeByKey(pair3.theKey));

        assertEquals(null, listRNDM.removeByKey(pair4.theKey));

    }


    /**
     * Test Region Search
     */
    public void testRegionSearch()
    {
        KVPair<String, Rectangle> notSecting0 = new KVPair<String, Rectangle>(
            "a", new Rectangle(400, 400, 1, 1));
        listRect.insert(intersect0);
        listRect.insert(intersect1);
        listRect.insert(intersect2);
        listRect.insert(intersect3);
        listRect.insert(intersect4);
        listRect.insert(intersect5);
        listRect.insert(notSecting0);

        assertEquals("\n" + "(400, 400, 1, 1)\n" + "(5, 5, 4, 4)\n"
            + "(4, 4, 4, 4)\n" + "(5, 1, 1, 1)\n" + "(1, 5, 1, 1)\n"
            + "(11, 1, 1, 1)\n" + "(1, 11, 1, 1)", listRect.regionSearch(
                new Rectangle(0, 0, 2000, 2000)));

        assertEquals("\n" + "(5, 5, 4, 4)\n" + "(4, 4, 4, 4)\n"
            + "(5, 1, 1, 1)\n" + "(1, 5, 1, 1)\n" + "(11, 1, 1, 1)\n"
            + "(1, 11, 1, 1)", listRect.regionSearch(new Rectangle(0, 0, 300,
                300)));
    }


    /**
     * test Intersections
     */
    public void testIntersections()
    {

        KVPair<String, Rectangle> notSecting0 = new KVPair<String, Rectangle>(
            "a", new Rectangle(400, 400, 1, 1));
        assertEquals("Intersections pairs:", listRect.intersections());
        listRect.insert(intersect0);
        assertEquals("Intersections pairs:", listRect.intersections());
        listRect.insert(intersect1);
        assertEquals("Intersections pairs:" + "", listRect.intersections());
        listRect.insert(intersect2);
        listRect.insert(intersect3);
        listRect.insert(intersect4);
        listRect.insert(intersect5);
        listRect.insert(notSecting0);

        assertEquals("Intersections pairs:"
            + "\n(a, 5, 5, 4, 4 | b, 4, 4, 4, 4)"
            + "\n(b, 4, 4, 4, 4 | a, 5, 5, 4, 4)" + "", listRect
                .intersections());
    }

}

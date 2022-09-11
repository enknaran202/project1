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

    private SkipList<String, Rectangle> list;
    private SkipList<String, Rectangle> list2;
    private SkipList<String, Rectangle> listRNDM;

    private KVPair<String, Rectangle> pair1;
    private KVPair<String, Rectangle> pair2;
    private KVPair<String, Rectangle> pair3;
    private KVPair<String, Rectangle> pair4;

    private Rectangle rec1;
    private Rectangle rec2;
    private Rectangle rec3;
    private Rectangle rec4;
    private Rectangle rec5;
    KVPair<String, Rectangle> notInList;
    
    @SuppressWarnings(
    { "unchecked", "rawtypes" })
    public void setUp()
    {

        list = new SkipList<String, Rectangle>();
        listRNDM = new SkipList<String, Rectangle>();
        rec1 = new Rectangle(1, 0, 0, 0);
        rec2 = new Rectangle(2, 0, 0, 0);
        rec3 = new Rectangle(3, 0, 0, 0);
        rec4 = new Rectangle(4, 0, 0, 0);
        
        pair1 = new KVPair<String, Rectangle>("1", rec1);
        pair2 = new KVPair<String, Rectangle>("2", rec2);
        pair3 = new KVPair<String, Rectangle>("3", rec3);
        pair4 = new KVPair<String, Rectangle>("4", rec4);
        notInList = new KVPair<String, Rectangle>("notInList", new Rectangle(9,9,9,9));


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
        assertEquals("Rectangle not found: (notInList)", list.search(
            notInList.theKey));
    }


    public void testDump()
    {
        list2 = new SkipList<String, Rectangle>();

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
        assertEquals("SkipList dump:\n"
            + "Node has depth 4, Value (null)\n"
            + "Node has a depth 2, Value (1, 1, 0, 0, 0)\n"
            + "SkipList size is: 4", list.dump());
        
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


    public void testRemoveByValue()
    {
        // tests removing the last, deepest node
        //assertEquals("", list.dump());
        assertEquals(pair4.theVal.toString(), list.removeByValue(pair4.theVal).theVal
            .toString());
        assertEquals(pair2.theVal.toString(), list.removeByValue(pair2.theVal).theVal
            .toString());

        assertEquals(pair3.theVal.toString(), list.removeByValue(pair3.theVal).theVal
            .toString());
        
        assertEquals(null, list.removeByValue(pair3.theVal));
        assertEquals(null, list.removeByValue(notInList.theVal));
        assertEquals(null, list.removeByValue(pair4.theVal));
        
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

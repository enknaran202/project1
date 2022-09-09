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
    
    private KVPair<K, E> pair1;
    private KVPair<String, Rectangle> pair2;
    private KVPair<String, Rectangle> pair3;
   
    private Rectangle rec1;
    private Rectangle rec2;
    private Rectangle rec3;

    public void setUp()
    {

        list =
            new SkipList<K, E>();
        rec1 = new Rectangle(0,0,0,0); 
        pair1 = new KVPair("a", rec1);
        
        
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
        assertTrue(list.insert(pair1));
    }


    public void testSearch()
    {

    }


    public void testDump()
    {

    }


    public void testRemoveByName()
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

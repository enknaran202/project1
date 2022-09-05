/**
 * 
 */
import student.TestCase;
import java.lang.reflect.Array;
import java.util.Random;
import student.TestableRandom;

/**
 * @author Deep Datta, (name here)
 * Note: make sure to write comments and concerns later
 */
public class SkipListTest extends TestCase{

    private SkipList<String, SkipNode<String, KVPair<String, Rectangle>>> list;
    
    public void setUp() {
        
        list = new SkipList<String, SkipNode<String, KVPair<String, Rectangle>>>();
        // Make SkipNodes and populate them with KCPair objects and then Rectangle in each pair
        // Also need a way to test Random
        // Were private methods inadvertently tested or no? (since can't access unless from other methods)
        
    }
    
    public void testRandomLevel() {
        
        
    }
    
    public void testInsert() {
        
        
    }
    
    public void testSearch() {
        
        
    }
    
    public void testDump() {
        
        
    }
    
    public void testRemoveByName() {
        
        
    }
    
    public void testRemoveByRectangle() {
        
        
    }
    
    public void testRegionSearch() {
        
        
    }
    
    public void testIntersections() {
        
        
    }
    
    
}

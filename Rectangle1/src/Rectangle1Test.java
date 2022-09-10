
/**
 * 
 */
import student.TestCase;
import student.testingsupport.PrintStreamWithHistory;
import java.util.NoSuchElementException;

/**
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * Note: make sure to write comments and concerns later
 */
public class Rectangle1Test extends TestCase{

    // use systemOut().getHistory()
    // look up "test main" in Piazza and find related posts on how to test main
    // Note: need to do sysoout.clearHistory() to clear it
    private Rectangle1 mian;
    
    public void setUp() {
        
        mian = new Rectangle1();
        mian.toString();
        
        
    }
    
    public void testParse() {
        
        String testInput = "test.txt";
        mian.parse(testInput);
        assertTrue(systemOut().getHistory().equals(""));
        
    }
}

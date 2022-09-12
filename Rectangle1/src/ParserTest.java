
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
public class ParserTest extends TestCase{

    // use systemOut().getHistory()
    // look up "test main" in Piazza and find related posts on how to test main
    // Note: need to do sysoout.clearHistory() to clear it
    private Parser main;
    
    public void setUp() {
        
        main = new Parser();
       
       
        
    }
    
    public void testParse() {
        
        String testInput = "commandFile";
        PrintStreamWithHistory sysout = systemOut();
        main.parseFile(testInput);
        assertEquals("Rectangle rejected: (r_r, -1, -20, 3, 4)\r\n"
            + "Rectangle rejected: (rec, 7, -8, 1, 3)\r\n"
            + "Rectangle rejected: (virtual_rec0, 1, 1, 0, 0)\r\n"
            + "Rectangle rejected: (virtual_REC0, 0, 0, 11, 0)\r\n"
            + "Rectangle rejected: (inExistRec_0, 1, 1, -1, -2)\r\n"
            + "Rectangle rejected: (11, 11, 0, 0)\r\n"
            + "Intersections pairs:\r\n"
            + "SkipList dump:\r\n"
            + "Node has depth 1, Value (null)\r\n"
            + "SkipList size is: 0\r\n"
            + "Rectangle not found: (r_r)\r\n"
            + "Rectangle not removed: (r_r)\r\n"
            + "Rectangle rejected: (1, 1, 0, 0)\r\n"
            + "Rectangles intersecting region (-5, -5, 20, 20): \r\n"
            + "Rectangle rejected: (5, 5, 0, 0)\r\n"
            + "Rectangle inserted: (goodRect, 5, 3, 56, 56)\r\n"
            + "Rectangle inserted: (goodRect2, 111, 400, 20, 20)\r\n"
            + "Rectangle inserted: (goodRect3, 25, 3, 6, 6)\r\n"
            + "SkipList dump:\r\n"
            + "Node has depth 1, Value (null)\r\n"
            + "Node has depth 1, Value (goodRect, 5, 3, 56, 56)\r\n"
            + "Node has depth 0, Value (goodRect2, 111, 400, 20, 20)\r\n"
            + "Node has depth 1, Value (goodRect3, 25, 3, 6, 6)\r\n"
            + "SkipList size is: 3\r\n"
            + "Rectangle removed: (goodRect2, 111, 400, 20, 20)\r\n"
            + "Intersections pairs:\r\n"
            + "(goodRect, 5, 3, 56, 56 | goodRect3, 25, 3, 6, 6)\r\n"
            + "(goodRect3, 25, 3, 6, 6 | goodRect, 5, 3, 56, 56)\r\n"
            + "Rectangles found:\r\n"
            + "(goodRect3, 25, 3, 6, 6)\r\n"
            + "Rectangle rejected: (-900, 5, 0, 5000)\r\n"
            + "",sysout.getHistory());
        sysout.clearHistory();
        
    }
}

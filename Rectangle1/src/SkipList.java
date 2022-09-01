import java.lang.reflect.Array;
import java.util.Random;
import student.TestableRandom;

public class SkipList<K extends Comparable<K>, E>
{
// Make this a private data member of the SkipList object
    private Random rnd; // Random number generator

    private SkipNode head;
    private int level;
    private int size;
    static private Random ran = new Random(); // Hold the Random class object

    public SkipList()
    {
        head = new SkipNode(null, null, 0);
        level = -1;
        size = 0;
        rnd = new TestableRandom();
    }


    /** Insert a KVPair into the skiplist */
    public boolean insert(KVPair<K, E> it)
    {
        int newLevel = randomLevel();
        Comparable<K> k = it.key();
        if (level < newLevel)
            adjustHead(newLevel);
        @SuppressWarnings("unchecked") // Generic array allocation
        SkipNode[] update = (SkipNode[])Array.newInstance(
            SkipList.SkipNode.class, level + 1);
        SkipNode x = head; // Start at header node
        for (int i = level; i >= 0; i--)
        { // Find insert position
            while ((x.forward[i] != null) && (k.compareTo((x.forward[i])
                .element().key()) > 0))
                x = x.forward[i];
            update[i] = x; // Track end at level i
        }
        x = new SkipNode(it, newLevel);
        for (int i = 0; i <= newLevel; i++)
        { // Splice into list
            x.forward[i] = update[i].forward[i]; // Who x points to
            update[i].forward[i] = x; // Who y points to
        }
        size++; // Increment dictionary size
        return true;
    }

    // CLASS: Dump
    // Param: None
    // CLASS:
    // CLASS: REMOVE


    private void adjustHead(int newLevel)
    {
        // TODO Auto-generated method stub

    }


    // Return the (first) matching matching element if one exists, null
    // otherwise
    public KVPair<K, E> search(Comparable<K> key)
    {
        boolean found = false;
        SkipNode x = head; // Dummy header node
        for (int i = level; i >= 0; i--) // For each level...
            while ((x.forward[i] != null) && (key.compareTo(x.forward[i]
                .element().key()) > 0)) // go forward
                x = x.forward[i]; // Go one last step
        x = x.forward[0]; // Move to actual record, if it exists
        if ((x != null) && (key.compareTo(x.element().key()) == 0))
            return x.element();
        else
            return null;
    }


    int randomLevel()
    {
        int lev;
        for (lev = 0; Math.abs(ran.nextInt()) % 2 == 0; lev++)
        { // ran is random generator
            ; // Do nothing
        }
        return lev;
    }

}

import java.lang.reflect.Array;
import java.util.Random;
import student.TestableRandom;

public class SkipList<K extends Comparable<K>, E> {

    // Make this a private data member of the SkipList object
    private Random rnd; // Random number generator

    private int level;
    private SkipNode<K, E> head;

    // Put this in the SkipList constructor
    // TestableRandom allows tests to be consistent instead of random. See
    // setNextBooleans()
    public SkipList() {

        rnd = new TestableRandom();
        level = 0;
        head = null;

    }


    /** Pick a level using a geometric distribution */
    public int randomLevel() {
        int lev;
        for (lev = 0; rnd.nextBoolean(); lev++) {
            // advance level
        }

        return lev;
    }


    /** Insert a KVPair into the skiplist */
    public boolean insert(KVPair<K, E> it) {
        int newLevel = randomLevel();
        int size = 0;
        Comparable<K> k = it.key();
        if (level < newLevel)
            adjustHead(newLevel);
        @SuppressWarnings("unchecked") // Generic array allocation
        SkipNode<K,E>[] update = (SkipNode[])Array.newInstance(
           SkipNode.class, level + 1);
        SkipNode<K, E> x = head; // Start at header node
        for (int i = level; i >= 0; i--) { // Find insert position
            while ((x.getForward()[i] != null) && (k.compareTo((x.getForward()[i])
                .element().key()) > 0))
                x = x.getForward()[i];
            update[i] = x; // Track end at level i
        }
        x = new SkipNode(it, newLevel);
        for (int i = 0; i <= newLevel; i++) { // Splice into list
            x.getForward()[i] = update[i].getForward()[i]; // Who x points to
            update[i].getForward()[i] = x; // Who y points to
        }
        size++; // Increment dictionary size
        return true;
    }


    // Return the (first) matching matching element if one exists, null
    // otherwise
    public KVPair<K, E> search(Comparable<K> key) {
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


    public void dump() {

        int size = 0;
        int depth = 1;
        int startLvl = 0;
        SkipNode<K,E> temp = head;
        
        System.out.println("SkipList dump:");
        
        if (temp == null) {

            System.out.println("Node has depth " + depth + ", Value ("
                + temp.toString());
        }
        
        while (temp != null) {
            
            depth = temp.getForward().length;
            temp = temp.getForward()[startLvl];
            System.out.println("Node has a depth " + depth + ", Value (" + temp.toString() + ")");
            size++;
        }
        
        System.out.println("SkipList size is: " + size);
        
        

    }


    // Should we keep print statements for outputs or string return for testing
    public String removeByName(SkipNode<K, E> in) {

        return null;

    }


    public String removeByCoords(SkipNode<K, E> inp) {

        return null;
    }


    public String regionSearch() {

        return null;

    }


    public void intersections() {

    }


    private void adjustHead(int newLevel) {

        SkipNode<K, E> temp = head;
        head = new SkipNode<K, E>(null, null, newLevel);
        for (int i = 0; i <= level; i++)
            head.getForward()[i] = temp.getForward()[i];
        level = newLevel;

    }

}

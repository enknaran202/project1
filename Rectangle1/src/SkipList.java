import java.lang.reflect.Array;
import java.util.Random;
import student.TestableRandom;

public class SkipList<K extends Comparable<K>, E>
{
    // Make this a private data member of the SkipList object
    private Random rnd; // Random number generator
    private int level;
    private int size;
    private SkipNode<K, E> head;
    // Put this in the SkipList constructor
    // TestableRandom allows tests to be consistent instead of random. See
    // setNextBooleans()

    public SkipList()
    {
        rnd = new TestableRandom();
        level = 0;
        size = 0;
        head = null;
    }


    /** Pick a level using a geometric distribution */
    public int randomLevel()
    {
        int lev;
        for (lev = 0; rnd.nextBoolean(); lev++)
        {
            // advance level no code in here
        }
        return lev;
    }


    /** Insert a KVPair into the skiplist */
    public boolean insert(KVPair<K, E> it)
    {
        int newLevel = randomLevel();
        Comparable<K> k = it.key();
        if (level < newLevel)
        { // If current level is not as deep go to deeper change head to be
          // deeper
            adjustHead(newLevel);
        }
        @SuppressWarnings("unchecked")
        SkipNode<K, E>[] update = (SkipNode[])Array.newInstance(SkipNode.class,
            level + 1);
        SkipNode<K, E> x = head; // Start at header node

        for (int i = level; i >= 0; i--)
        { // Find insert position
            while ((x.getForward()[i] != null) && (k.compareTo((x
                .getForward()[i]).key()) > 0))
            {
                x = x.getForward()[i];
            }
            update[i] = x; // Track end at level i
        }
        x = new SkipNode<K, E>(it.key(), it.value(), newLevel);
        for (int i = 0; i <= newLevel; i++)
        { // Splice into list
            x.getForward()[i] = update[i].getForward()[i]; // Who x points to
            update[i].getForward()[i] = x; // Who y points to
        }
        size++;
        return true;
    }


    // Return all matching the key
    public String search(KVPair<K, E> key)
    { // how does it know to start at the top level???????
        SkipNode<K, E> x = head; // Dummy header node
        String toReturn = "Rectangles found:";
        boolean found = false;
        // for loop can be improved. Need an exit system
        for (int i = level; i >= 0; i--)
        { // For each level...
            while ((x.getForward()[i] != null) && (key.compareTo(x
                .getForward()[i].key()) > 0))
            { // go forward

                x = x.getForward()[i]; // Go one last step
            }
            if (key.compareTo(x.getForward()[i].key()) == 0)
            {
                found = true;
                x = x.getForward()[0];
                toReturn = toReturn + "\n" + "(" + x.toString() + ")";
            }

        }
        if (found)
        {
            return toReturn;
        }
        // TEST
        // What does key print out?
        return "Rectangle not found: (" + key + ")";

    }


    public void dump()
    {

        int size = 0;
        int depth = 1;
        int startLvl = 0;
        SkipNode<K, E> temp = head;

        System.out.println("SkipList dump:");

        if (temp == null)
        {
            System.out.println("Node has depth " + depth + ", Value (" + temp
                .toString());
        }
        while (temp != null)
        {
            depth = temp.getForward().length;
            temp = temp.getForward()[startLvl];
            System.out.println("Node has a depth " + depth + ", Value (" + temp
                .toString() + ")");
            size++;
        }
        System.out.println("SkipList size is: " + size);
    }


    // Should we keep print statements for outputs or string return for testing
    public String removeByName(K key)
    {
        // !QUESTION!
        // How do we make yellow line disappear?
        SkipNode<K, E>[] update = (SkipNode[])Array.newInstance(SkipNode.class,
            level + 1);
        SkipNode<K, E> x = head; // Dummy header node

        for (int i = level; i >= 0; i--)
        { // For each level...
            while ((x.getForward()[i] != null) && (key.compareTo(x
                .getForward()[i].key()) > 0))
            { // go forward

                x = x.getForward()[i]; // Go one last step

            }
            if (key.compareTo(x.getForward()[i].key()) == 0)
            {
                x.setForward(x.getForward()[i]);
                return "success";
            }
        }
        return "failure";

        // -------------------------------------
        int level = 0;
        adjustHead(level);
        @SuppressWarnings("unchecked")
        SkipNode<K, E>[] update = (SkipNode[])Array.newInstance(SkipNode.class,
            level + 1);
        SkipNode<K, E> x = head;
        return "Rectangle removed: (" + k.toString() + ")";
    }


    public String removeByRectangle(int x, int y, int w, int h)
    {
        return "Rectangle not removed: (" + k.toString() + ")";
        return "Rectangle removed: (" + k.toString() + ")";
    }


    public String regionSearch()
    {
        return null;
    }


    public void intersections()
    {

    }


    private void adjustHead(int newLevel)
    {
        SkipNode<K, E> temp = head;
        head = new SkipNode<K, E>(null, null, newLevel);
        for (int i = 0; i <= level; i++)
            head.getForward()[i] = temp.getForward()[i];
        level = newLevel;
    }


    private KVPair<K, E> findFirst(Comparable<K> key)
    {
        SkipNode<K, E> x = head; // Dummy header node

        for (int i = level; i >= 0; i--)
        { // For each level...
            while ((x.getForward()[i] != null) && (key.compareTo(x
                .getForward()[i].key()) > 0))
            { // go forward

                x = x.getForward()[i]; // Go one last step

            }
            if (key.compareTo(x.getForward()[i].key()) == 0)
            {
                x = x.getForward()[0];
                return x.pair();
            }
        }
        return null;

    }

    // TESTING FETCH/MERGE
}

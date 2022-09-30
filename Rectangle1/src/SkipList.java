import java.lang.reflect.Array;
import java.util.Random;
import student.TestableRandom;

/**
 * Basic SkipList implementation. As generic as possible
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * @version 9/11/2022
 * 
 * @param <K>
 *            Key
 * @param <E>
 *            Element
 */
public class SkipList<K extends Comparable<K>, E>
{
    private Random rnd = new TestableRandom(); // Random number generator
    private int level;
    private int size;
    private SkipNode<K, E> head;
    // TestableRandom allows tests to be consistent instead of random. See
    // setNextBooleans()

    /**
     * SkipList constructor
     * 
     */
    public SkipList()
    {
        level = 0;
        size = 0;
        head = new SkipNode<K, E>(null, null, 0);
    }


    /**
     * Pick a level using a geometric distribution
     * 
     * @return int
     *         the number of levels for the new node's forward array length
     */
    public int randomLevel()
    {
        int lev;
        for (lev = 0; rnd.nextBoolean(); lev++)
        {
            // advance level no code in here
        }
        return lev;
    }


    /**
     * Insert a KVPair into the skiplist
     * 
     * @param it
     *            The KVPair being inserted
     * @return boolean
     *         If the insert was a success or failure
     * 
     */
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
        x = new SkipNode<K, E>(it.key(), it.theVal, newLevel);

        for (int i = 0; i <= newLevel; i++)
        { // Splice into list
            x.getForward()[i] = update[i].getForward()[i]; // Who x points to
            update[i].getForward()[i] = x; // Who y points to
        }
        size++;
        return true;
    }


    /**
     * Finding a node by a given key
     * 
     * @param key
     *            the key used to find the node
     * @return String
     *         either the toString of the found node or null when not found
     * 
     */
    public String search(K key)
    {
        String toReturn = "";
        SkipNode<K, E> x = head; // Dummy header node
        int tempLevel = level;
        boolean found = false;

        for (int i = tempLevel; i >= 0; i--)
        { // For each level...
            while ((x.getForward()[i] != null) && (key.compareTo(x
                .getForward()[i].key()) > 0))
            {// go forward
                x = x.getForward()[i];
            } // Go one last step
        }
        x = x.getForward()[0];
        while ((x != null) && (key.compareTo(x.key()) == 0))
        {
            found = true;
            toReturn = toReturn + "\n(" + x.toString() + ")";
            x = x.getForward()[0];
        }

        if (found)
        {
            return toReturn;
        }
        return null;

    }


    /**
     * A dump of all contents of the list
     * 
     * @return string
     *         the resulting dump
     * 
     */
    public String dump()
    {
        int depth = 0;
        int startLvl = 0;
        String toReturn = "SkipList dump:\n";
        SkipNode<K, E> temp = head;
        toReturn += "Node has depth " + head.getForward().length
            + ", Value (null)";

        while (temp.getForward()[startLvl] != null)
        {
            temp = temp.getForward()[startLvl];
            depth = temp.getForward().length;
            toReturn += "\nNode has depth " + depth + ", Value (" + temp
                .toString() + ")";
        }
        toReturn += "\nSkipList size is: " + size;

        return toReturn;
    }


    /**
     * Removing a node containing the given key
     * 
     * @param key
     *            the key to look for and remove
     * 
     * @return KVPair
     *         the KVPair from the removed node
     * 
     */
    // ISSUE: WHere do i put updateHead?
    public KVPair<K, E> removeByKey(K key)
    {
        boolean found = false;
        SkipNode<K, E> x = head; // Start at header node
        @SuppressWarnings("unchecked")
        SkipNode<K, E>[] update = (SkipNode[])Array.newInstance(SkipNode.class,
            level + 1);

        for (int i = level; i >= 0; i--)
        {
            while ((x.getForward()[i] != null) && (key.compareTo(x
                .getForward()[i].key()) > 0))
            {// go forward
                x = x.getForward()[i];

            } // Go one last step
            update[i] = x;
        }
        x = x.getForward()[0]; // should go to the node we're looking for
        // MISSING: One of the 4 cases
        if ((x != null) && (key.compareTo(x.key()) == 0))
        {
            found = true;
            for (int i = 0; i <= level; i++)
            {
                if (update[i].getForward()[i] != x)
                {
                    size--;
                    return x.pair();
                }
                update[i].getForward()[i] = x.getForward()[i];
            }
        }
        if (found == true)
        {
            int j = 0;
            int nonNulLevels = 0;
            while (j < head.getForward().length && head.getForward()[j] != null)
            {
                j++;
                nonNulLevels++;
            }
            adjustHead(nonNulLevels - 1);
            size--;
            return x.pair();
        }
        return null;
    }


    /**
     * Remove by given value
     * 
     * @param value
     *            value to remove
     * @return KVPair
     *         kvpair of removed node
     * 
     */
    public KVPair<K, E> removeByValue(E value)
    {
        SkipNode<K, E> x = head;
        SkipNode<K, E> toRemove = head;
        Boolean found = false;
        int countArray = 0;
        // ISSUE: .equals should call the rectangle .equals
        // How do i use rectangle to equals?
        while (toRemove.getForward()[0] != null && !value.equals(toRemove
            .getForward()[0].pair().theVal))
        {
            toRemove = toRemove.getForward()[0];
        }
        // possibly the correct node
        toRemove = toRemove.getForward()[0];
        // if we found the node we want to remove
        // ISSUE 1/4 covered
        if (toRemove != null && value.equals(toRemove.pair().theVal))
        {
            found = true;
            for (int i = 0; i <= toRemove.getForward().length - 1; i++)
            {
                x = head;
                // ISSUE 1/4 missed
                while (x.getForward()[i] != null && x
                    .getForward()[i] != toRemove)
                {
                    x = x.getForward()[i];
                }
                // ISSUE 2/4 missed
                if (x.getForward()[i] != null && x.getForward()[i] == toRemove)
                {
                    x.getForward()[i] = toRemove.getForward()[i];
                }
            }
        }
        if (found == true)
        {
            int j = 0;
            int nonNulLevels = 0;
            while (j < head.getForward().length && head.getForward()[j] != null)
            {
                j++;
                nonNulLevels++;
            }
            adjustHead(nonNulLevels - 1);
            size--;
            return toRemove.pair();
        }
        return null;
    }


    /**
     * Finding all rectangles that intersect with given region
     * 
     * @param rect
     *            region to search
     * @return String
     *         a string of all rectangles intersecting given region
     * 
     */

    public String regionSearch(Rectangle rect)
    {
        SkipNode<K, E> cur = this.head; // tracker pointer
        String saved = "";

        while (cur.getForward()[0] != null)
        {
            if (((Rectangle)cur.getForward()[0].pair().theVal).isIntersecting(
                rect))
            {
                saved += "\n(" + cur.getForward()[0].pair().theVal.toString()
                    + ")";
            }
            cur = cur.getForward()[0];
        }
        return saved;
    }


    /**
     * Finding all rectangles that intersect
     * 
     * 
     * @return String
     *         a string of all rectangles intersecting
     * 
     */
    public String intersections()
    {
        String toReturn = "Intersections pairs:";
        @SuppressWarnings("unchecked")
        SkipNode<String, Rectangle> pointerA =
            (SkipNode<String, Rectangle>)this.head;
        // if empty
        if (pointerA.getForward()[0] == null)
        {
            return toReturn;
        }
        SkipNode<String, Rectangle> pointerB = null;
        while (pointerA.getForward()[0] != null)
        {
            pointerB = pointerA.getForward()[0];
            while (pointerB.getForward()[0] != null)
            {
                if (pointerA.getForward()[0].pair().theVal.isIntersecting(
                    pointerB.getForward()[0].pair().theVal))
                {
                    // Ensure correct print outs
                    toReturn += "\n(" + pointerA.getForward()[0].pair()
                        .toString() + " | " + pointerB.getForward()[0].pair()
                            .toString() + ")";
                    toReturn += "\n(" + pointerB.getForward()[0].pair()
                        .toString() + " | " + pointerA.getForward()[0].pair()
                            .toString() + ")";
                }
                pointerB = pointerB.getForward()[0];
            }
            pointerA = pointerA.getForward()[0];
        }
        return toReturn;
    }


    /**
     * Finding all rectangles that intersect with given region
     * 
     * @param newLevel
     *            correct level for head
     * 
     */
    private void adjustHead(int newLevel)
    {
        SkipNode<K, E> temp = head;
        head = new SkipNode<K, E>(null, null, newLevel);
        if (newLevel > level)
        {
            for (int i = 0; i <= level; i++)
                head.getForward()[i] = temp.getForward()[i];
            level = newLevel;
        }
        else
        {
            for (int i = 0; i <= newLevel; i++)
            {
                head.getForward()[i] = temp.getForward()[i];
                level = newLevel;
            }
        }
    }
}

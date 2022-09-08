import java.lang.reflect.Array;
import java.util.Random;
import student.TestableRandom;

public class SkipList<K extends Comparable<K>, E>
{
    private Random rnd; // Random number generator
    private int level;
    private int size;
    private SkipNode<K, E> head;
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


    // Can I make it return an array
    public String search(KVPair<K, E> key)
    {
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

        return "(" + key.key() + ")";
    }
    // IMPLEMENT
    // regionsearch

    // IMPLEMENT
    // intersections


    public void dump()
    {
        int size = 0;
        int depth = 1;
        int startLvl = 0;
        SkipNode<K, E> temp = head;

        System.out.println("SkipList dump:");

        if (temp == null)
        {
            System.out.println("Node has depth " + depth + ", Value (null)");
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


    // !NOTE!
    // Ensure it stops at the first and saves that
    // Double Check
    public KVPair<K, E> removeByKey(K key)
    {
        KVPair<K, E> removed = null; // tracks if the node has been found
        boolean found = false;
        int headLevelsToRemove = 0;

        SkipNode<K, E> x = head; // tracker pointer
        for (int i = level; i >= 0; i--)
        { // For each level...
            while ((x.getForward()[i] != null) && (key.compareTo(x
                .getForward()[i].key()) > 0))
            { // go forward
                x = x.getForward()[i]; // Go one last step
            }
            if (((x.getForward()[i] != null) && key.compareTo(x.getForward()[i]
                .key()) == 0))
            { // checks to see if we have found it
                found = true;
                x.getForward()[i] = x.getForward()[i].getForward()[i];
                if (x == head && x.getForward()[i] == null) // check to see if
                                                            // this covers all
                                                            // the problems
                {
                    headLevelsToRemove--;
                }
            }
        }
        if (found)
        {
            if (headLevelsToRemove > 0)
            {
                adjustHead(headLevelsToRemove);
            }
            size--;
        }
        return removed;
    }


    // !NOTE!
    // Needs to be in main
    // remove by value
    public KVPair<K, E> removeByValue(E value)
    {
        KVPair<K, E> removed = null;
        boolean found = false;
        int numOfNulls = 0;

        @SuppressWarnings("unchecked")
        SkipNode<K, E>[] update = (SkipNode[])Array.newInstance(SkipNode.class,
            level + 1);
        SkipNode<K, E> curr = head; // tracker pointer

        for (int i = level; i >= 0; i--)
        { // For each level...

            while ((curr.getForward()[i] != null) && !value.equals(curr
                .getForward()[i].pair().theVal))
            { // go forward
                curr = curr.getForward()[i]; // Go one last step
            }
            if (value.equals(curr.getForward()[i].pair().theVal))
            {
                update[i] = curr;
                found = true;
            }
            else
            {
                update[i] = curr;
            }
        }
        for (int j = level; j >= 0; j--)
        {
            // if the cur level == a level in the node that we want to remove
            // then we do curr.setForward[curLevel]
            if (update[j].getForward() != null && value.equals(curr
                .getForward()[j].pair().theVal))
            {
                // keeps track of how many null values in head
                if (update[j].equals(head))
                {
                    numOfNulls++;
                }
                update[j].getForward()[j] = update[j].getForward()[j]
                    .getForward()[j];
            }
        }

        if (found) // If we found the node to remove
        {
            adjustHead(level - numOfNulls); // Change head array to remove all
                                            // nulls
            size--; // Decrement size of list
        }
        return removed;
    }


    public String regionSearch(Rectangle rect)
    {
        SkipNode<K, E> cur = this.head; // tracker pointer
        String saved = "";

        while (cur.getForward()[0] != null)
        {
            if (cur.getForward()[0].pair().theVal.equals(rect))
            {
                saved = saved + cur.getForward()[0].pair().theVal.toString()
                    + "\n";
            }
        }

        System.out.println("Rectangles intersecting region:" + rect.toString()
            + ": \n");
        return saved;
    }


    public String intersections(SkipList<?, ?> list)
    {

        return null;

    }


    private void adjustHead(int newLevel)
    {
        SkipNode<K, E> temp = head;

        head = new SkipNode<K, E>(null, null, newLevel);
        for (int i = 0; i <= level; i++)
            head.getForward()[i] = temp.getForward()[i];
        level = newLevel;
    }
}

import java.lang.reflect.Array;
import java.util.Random;
import student.TestableRandom;

public class SkipList<K extends Comparable<K>, E>
{
    private Random rnd = new TestableRandom(); // Random number generator
    private int level;
    private int size;
    private SkipNode<K, E> head;
    // TestableRandom allows tests to be consistent instead of random. See
    // setNextBooleans()

    public SkipList()
    {
        level = 0;
        size = 0;
        head = new SkipNode<K, E>(null, null, 0);
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
        x = new SkipNode<K, E>(it.theKey, it.theVal, newLevel);

        for (int i = 0; i <= newLevel; i++)
        { // Splice into list
            x.getForward()[i] = update[i].getForward()[i]; // Who x points to
            update[i].getForward()[i] = x; // Who y points to
        }
        size++;
        return true;
    }


    public String search(K key)
    {
        String toReturn = "Rectangles found:";
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
            toReturn = toReturn + "\n" + "(" + x.toString() + ")";
            x = x.getForward()[0];
        }

        if (found)
        {
            return toReturn;
        }
        return "Rectangle not found: (" + key + ")";

    }


    public String dump()
    {
        int depth = 0;
        int startLvl = 0;
        String toReturn = "SkipList dump:\n";
        SkipNode<K, E> temp = head;
        toReturn += "Node has depth " + head.getForward().length
            + ", Value (null)\n";

        while (temp.getForward()[startLvl] != null)
        {
            temp = temp.getForward()[startLvl];
            depth = temp.getForward().length;
            toReturn += "Node has a depth " + depth + ", Value (" + temp
                .toString() + ")\n";
        }
        toReturn += "SkipList size is: " + size;

        return toReturn;
    }


    // ISSUE: WHere do i put updateHead?
    // ISSUE: Can't remove last node effectively
    public KVPair<K, E> removeByKey(K key)
    {
        Object toReturn = null;
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
        if ((x != null) && (key.compareTo(x.key()) == 0))
        {
            found = true;
            for (int i = 0; i <= level; i++)
            {
                if (update[i].getForward()[i] != x)
                {
                    return x.pair();
                }
                update[i].getForward()[i] = x.getForward()[i];
            }
        }
        if (found == true)
        {
            return x.pair();
        }
        return null;
    }


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
            if (((Rectangle)cur.getForward()[0].pair().theVal).isIntersecting(
                rect))
            {
                saved += cur.getForward()[0].pair().theVal.toString() + "\n";
            }
        }
        System.out.println("Rectangles intersecting region:" + rect.toString()
            + ": \n");
        return saved;
    }


    public String intersections()
    {
        String toReturn = "Intersection pairs: \n";
        SkipNode<K, E> pointerA = this.head;
        // if empty
        if (pointerA.getForward()[0] == null)
        {
            return toReturn;
        }
        SkipNode<K, E> pointerB = pointerA.getForward()[0];
        while (pointerA.getForward()[0] != null)
        {
            while (pointerB.getForward()[0] != null)
            {
                if (pointerA.getForward()[0].pair().theVal.equals(pointerB
                    .getForward()[0].pair().theVal))
                    ;
                {
                    // Ensure correct print outs
                    toReturn += "(" + pointerA.getForward()[0].pair().toString()
                        + " | " + pointerB.getForward()[0].pair().toString()
                        + ") \n";
                }
                pointerB = pointerB.getForward()[0];
            }
            pointerA = pointerA.getForward()[0];
        }
        return toReturn;
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

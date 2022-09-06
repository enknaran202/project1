import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Random;
import student.TestableRandom;

public class SkipList<K extends Comparable<K>, E>
    implements Iterable<KVPair<K, E>>
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
        // !QUESTION!
        // Is this correct? Why not new SkipNode[level + 1]?
        SkipNode<K, E>[] update = (SkipNode[])Array.newInstance(SkipNode.class,
            level + 1);
        SkipNode<K, E> x = head; // Start at header node

        for (int i = level; i >= 0; i--)
        {   // Find insert position
            while ((x.getForward()[i] != null) && (k.compareTo((x
                .getForward()[i]).key()) > 0))
            {
                x = x.getForward()[i];
            }
            update[i] = x; // Track end at level i
        }
        x = new SkipNode<K, E>(it.key(), it.value(), newLevel);
        for (int i = 0; i <= newLevel; i++)
        {   // Splice into list
            x.getForward()[i] = update[i].getForward()[i]; // Who x points to
            update[i].getForward()[i] = x; // Who y points to
        }
        size++;
        return true;
    }

    // !QUESTION! 
    // Should output be kvpair instead? 
    // Will we be struck down for this?
    // Try outputting KVPair
    // Return all matching the key
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
        // !QUESTION!
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


    // !QUESTION!
    // I want to return the KVPair that was removed. Where should I save it?
    public KVPair<K, E> removeByName(K key)
    {
        KVPair<K, E> removed = null; // tracks if the node has been found
        boolean found = false;
        int numOfNulls = 0; // counts the number of nulls in the head array

        @SuppressWarnings("unchecked")
        SkipNode<K, E>[] update = (SkipNode[])Array.newInstance(SkipNode.class,
            level + 1);
        SkipNode<K, E> x = head; // tracker pointer
        for (int i = level; i >= 0; i--)
        { // For each level...
            while ((x.getForward()[i] != null) && (key.compareTo(x
                .getForward()[i].key()) > 0))
            { // go forward
                x = x.getForward()[i]; // Go one last step
            }
            if ((key.compareTo(x.getForward()[i].key()) == 0))
            {
                // !QUESTION!
                // would this implementation work? Why do we use update for
                // remove?
                // x.getForward()[i] = x.getForward()[i].getForward()[i]
                // size--;
                // found = true;
                update[i] = x;
                found = true;
            }
            else
            {
                update[i] = x;
            }
        }
        for (int j = level; j >= 0; j--)
        {
            // if the cur level == a level in the node that we want to remove
            // then we do curr.setForward[curLevel]
            if (update[j].getForward() != null && key.compareTo(x
                .getForward()[j].key()) == 0)
            {
                if (update[j].equals(head))
                {
                    numOfNulls++;
                }
                update[j].getForward()[j] = update[j].getForward()[j]
                    .getForward()[j];
            }
        }
        //
        if (found) // If we found the node to remove
        {
            adjustHead(level - numOfNulls); // Change head array to remove all
                                            // nulls
            size--; // Decrement size of list
        }
        return removed;
    }

    // !QUESTION!
    // Why do we need update for both removes?
    // Can we use this code instead?
    // x.getForward()[i] = x.getForward()[i].getForward()[i]
    // found = true;
    public KVPair<K, E> removeByRectangle(int x, int y, int w, int h)
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
            while ((curr.getForward()[i] != null) && Rectangle.equals(x, y, w,
                h, (Rectangle)curr.getForward()[i].pair().theVal))
            { // go forward
                curr = curr.getForward()[i]; // Go one last step
            }
            if (Rectangle.equals(x, y, w, h, (Rectangle)curr.getForward()[i]
                .pair().theVal))
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
            if (update[j].getForward() != null && Rectangle.equals(x, y, w, h,
                (Rectangle)curr.getForward()[j].pair().theVal))
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
        // why can't I do
        // if(removed != null) 

        if (found) // If we found the node to remove
        {
            adjustHead(level - numOfNulls); // Change head array to remove all
                                            // nulls
            size--; // Decrement size of list
        }
        return removed;
    }


    private void adjustHead(int newLevel)
    {
        SkipNode<K, E> temp = head;

        head = new SkipNode<K, E>(null, null, newLevel);
        for (int i = 0; i <= level; i++)
            head.getForward()[i] = temp.getForward()[i];
        level = newLevel;
    }

    // !QUESTION!
    // Do we need this one?
    // Can we delete?
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

    // !QUESTION!
    // How do I implement this?
    // Are the generics correctly labeled?
    class SkipListIterator<K extends Comparable<K>, E> implements Iterator<KVPair<K, E>>
    {
        private SkipNode<K, E> cur;
        
        public SkipListIterator(SkipList<K, E> list)
        {
            cur = list.head;
        }
        
        public KVPair<K, E> next()
        {
            if (cur.pair() !=  null) 
            {
                return null;
            }
            KVPair<K, E> toReturn = cur.pair();
            cur = cur.getForward()[0];
            return toReturn;
        }

        @Override
        public boolean hasNext()
        {
            // TODO Auto-generated method stub
            return cur.getForward()[0] != null;
        }
    }
    public Iterator<KVPair<K, E>> iterator()
    {
        return new SkipListIterator<K, E>(this);
    }

}

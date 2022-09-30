
// ----------------------------------------------------------
/**
 * KVPair Class
 * Description: Object class that creates a KVPair object when evoked
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * @param K
 * @param E
 */
public class KVPair<K extends Comparable<K>, E>
    implements Comparable<KVPair<K, E>>
{
    K theKey;
    E theVal;

    // ----------------------------------------------------------
    /**
     * KVPair Constructor
     * 
     * @param k
     *            Takes in a generic key value of type generic K
     * @param v
     *            Takes in a generic value of type generic E
     * 
     */
    public KVPair(K k, E v)
    {
        theKey = k;
        theVal = v;
    }


    /**
     * Description: Compares to KVPairs to check if same or different
     * 
     * @return Returns 1 if first is greater, -1 if the second is greater, and 0
     *         if it is the same
     * @param K
     * @param E
     * 
     */
    public int compareTo(KVPair<K, E> it)
    {
        return theKey.compareTo(it.key());
    }


    /**
     * Description: Compares to keys to check if same or different
     * 
     * @return Returns 1 if first is greater, -1 if the second is greater, and 0
     *         if it is the same
     * 
     * @param K
     */
    public int compareTo(K it)
    {
        return theKey.compareTo(it);
    }


    /**
     * Description: Getter the returns the key of KVPair object
     * 
     * @return Returns the generic key
     * 
     */
    public K key()
    {
        return theKey;
    }


    /**
     * Description: Setter the returns the value of KVPair object
     * 
     * @return Returns the generic value
     * 
     */
    public E value()
    {
        return theVal;
    }


    /**
     * Description: Returns the string representation of KVPair information
     * 
     * @return string of the KVPair object and displayed information
     * 
     */
    public String toString()
    {
        return theKey.toString() + ", " + theVal.toString();
    }
}

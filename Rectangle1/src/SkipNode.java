// ----------------------------------------------------------
/**
 * SkipNode Class
 * Description: Object class that creates a SkipNode object when evoked
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * 
 */
public class SkipNode<K extends Comparable<K>, E> {

    private KVPair<K, E> rec;
    private SkipNode<K, E>[] forward;

    /**
     * Description: Get the value of the element stored in SkipNode
     * 
     * @return element data
     * 
     */
    public E element() {

        return rec.value();

    }


    /**
     * Description: Get the key value of the SkipNode
     * 
     * @return the key
     * 
     */
    public K key() {

        return rec.key();

    }


    /**
     * Description: Gets the key-value pair from SkipNode
     * 
     * @return the KVPair object
     * 
     */
    public KVPair<K, E> pair() {

        return rec;

    }


    // ----------------------------------------------------------
    /**
     * SkipNode Constructor
     * 
     * @param key
     *            Takes in a generic key value of type generic K
     * @param elem
     *            Takes in a generic value of type generic E
     * @param level
     *            Gets the level of the SkipNode
     * 
     *            Description: Constructor is used to pre-setup the SkipNode
     *            array
     * 
     */
    @SuppressWarnings("unchecked")
    public SkipNode(K key, E elem, int level) {

        rec = new KVPair<K, E>(key, elem);
        setForward(new SkipNode[level + 1]); // can instantiate differently, not
                                             // sure if it causes errors

        for (int i = 0; i < level; i++) {

            getForward()[i] = null;

        }
    }


    /**
     * Description: Returns the string representation of the record information
     * 
     * @return string of the KVPair object and displayed record information
     * 
     */
    public String toString() {
        return rec.toString();
    }


    /**
     * Description: Allows to move forward through the SkipNode array
     * 
     * @return the SkipNode array to move forward
     * 
     */
    public SkipNode<K, E>[] getForward() {
        return forward;
    }


    /**
     * Description: Sets the SkipNode array
     * 
     */
    public void setForward(SkipNode<K, E>[] forward) {
        this.forward = forward;
    }
}

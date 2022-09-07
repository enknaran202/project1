public class SkipNode<K extends Comparable<K>, E>
{

    private KVPair<K, E> rec;
    private SkipNode<K, E>[] forward;

    public E element()
    {

        return rec.value();

    }


    public K key()
    {

        return rec.key();

    }


    public KVPair<K, E> pair()
    {

        return rec;

    }


    @SuppressWarnings("unchecked")
    public SkipNode(K key, E elem, int level)
    {

        rec = new KVPair<K, E>(key, elem);
        setForward(new SkipNode[level + 1]); // can instantiate differently, not
                                             // sure if it causes errors

        for (int i = 0; i < level; i++)
        {

            getForward()[i] = null;

        }
    }

    /*
     * public SkipNode(KVPair<K, E> it, int newLevel) { //can be tested with a
     * premade KV pair
     * // TODO Auto-generated constructor stub
     * }
     */


    public String toString()
    {
        return rec.toString();
    }


    public SkipNode<K, E>[] getForward()
    {
        return forward;
    }


    public void setForward(SkipNode<K, E>[] forward)
    {
        this.forward = forward;
    }
}

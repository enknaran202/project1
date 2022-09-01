 class SkipNode<K extends Comparable<K>, E> {
    private KVPair rec;
    private SkipNode<K, E>[] forward;

    public Object element() {
      return rec.value();
    }

    public Comparable key() {
      return rec.key();
    }

    public SkipNode(Comparable key, Object elem, int level) {
      rec = new KVPair(key, elem);
      setForward(new SkipNode[level + 1]);
      for (int i = 0; i < level; i++) {
        getForward()[i] = null;
      }
    }

    public SkipNode(KVPair<K, E> it, int newLevel)
    {
        // TODO Auto-generated constructor stub
    }

    public String toString() {
      return rec.toString();
    }

    public SkipNode[] getForward()
    {
        return forward;
    }

    public void setForward(SkipNode[] forward)
    {
        this.forward = forward;
    }
  }
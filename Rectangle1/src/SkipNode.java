 class SkipNode {
    private KVPair rec;
    private SkipNode[] forward;

    public Object element() {
      return rec.value();
    }

    public Comparable key() {
      return rec.key();
    }

    public SkipNode(Comparable key, Object elem, int level) {
      rec = new KVPair(key, elem);
      forward = new SkipNode[level + 1];
      for (int i = 0; i < level; i++) {
        forward[i] = null;
      }
    }

    public SkipNode(KVPair<K, E> it, int newLevel)
    {
        // TODO Auto-generated constructor stub
    }

    public String toString() {
      return rec.toString();
    }
  }
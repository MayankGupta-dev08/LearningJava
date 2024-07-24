package dev.mayankg.ds_algo_patterns.dataStructures.unionFind;

/**
 * Eager approach to Union Find data structure aka QuickFindUF
 */
@SuppressWarnings({"unused"})
class EagerUnionFind implements UF<Integer> {
    private int[] ids;
    private int capacity;
    private int count;

    public EagerUnionFind(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.ids = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            ids[i] = i;
        }
    }

    @Override
    public void union(Integer p, Integer q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        for (int i = 0; i < capacity; i++) {
            if (ids[i] == pId) ids[i] = qId;
        }
        count--;
    }

    @Override
    public boolean isConnected(Integer p, Integer q) {
        return find(p) == find(q);
    }

    @Override
    public int find(Integer element) {
        return ids[element];
    }

    @Override
    public int count() {
        return count;
    }
}

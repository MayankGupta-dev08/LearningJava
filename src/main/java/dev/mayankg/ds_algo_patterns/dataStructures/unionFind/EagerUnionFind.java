package dev.mayankg.ds_algo_patterns.dataStructures.unionFind;

/**
 * Eager approach to Union Find data structure aka QuickFindUF <br>
 * Time complexity: O(n) for union and O(1) for find <br>
 * Space complexity: O(n) <br>
 * Drawback:
 * - Union is too expensive (It takes N^2 array accesses to process a sequence of N union commands on N objects.)
 * - Trees are flat, but too expensive to keep them flat.
 */
@SuppressWarnings({"unused"})
class EagerUnionFind implements UF<Integer> {
    private int[] ids;
    private int N;

    /**
     * @param capacity : [0, 1, ..., N-1]
     */
    public EagerUnionFind(int capacity) {
        this.N = capacity;
        this.ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i; // Each element is its own parent (initially)
        }
    }

    @Override
    public void union(Integer p, Integer q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        // Merge components by changing all entries with id pId to qId
        for (int i = 0; i < N; i++) {
            if (ids[i] == pId) ids[i] = qId;
        }
    }

    @Override
    public boolean isConnected(Integer p, Integer q) {
        return find(p) == find(q);
    }

    @Override
    public int find(Integer element) {
        return ids[element];
    }
}
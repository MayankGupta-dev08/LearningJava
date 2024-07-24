package dev.mayankg.ds_algo_patterns.dataStructures.unionFind;

/**
 * Lazy approach to Union Find data structure aka QuickUnionUF <br>
 * ids[i] is the parent of i, & using chain or parents we can reach the root (ultimate prent of i) <br>
 * Time complexity: O(N) for union and O(N) for find <br>
 * Space complexity: O(N) <br>
 * Drawback:
 * - Find is too expensive (could be N array accesses)
 * - Trees can get tall
 */
@SuppressWarnings({"unused"})
class LazyUnionFind implements UF<Integer> {
    private int[] ids;

    /**
     * @param N : [0, 1, ..., N-1], where N is the number of elements
     */
    public LazyUnionFind(int N) {
        this.ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i; // each element is its own root/parent (initially)
        }
    }

    /**
     * Time Complexity: Could be O(n) in the worst case as we are using find()
     */
    @Override
    public void union(Integer p, Integer q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        ids[pRoot] = qRoot;
    }

    @Override
    public boolean isConnected(Integer p, Integer q) {
        return find(p) == find(q);
    }

    /**
     * Finds the root (ultimate parent) of the element
     */
    @Override
    public int find(Integer e) {
        if (ids[e] == e) return e;
        return find(ids[e]);
    }
}
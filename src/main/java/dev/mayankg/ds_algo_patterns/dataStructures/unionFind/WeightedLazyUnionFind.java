package dev.mayankg.ds_algo_patterns.dataStructures.unionFind;

/**
 * Weighted Lazy approach to Union Find data structure aka WeightedQuickUnionUF <br>
 * ids[i] is the parent of i, & using chain or parents we can reach the root (ultimate prent of i) <br>
 * Time complexity: O(logN) for union and O(logN) for find <br>
 * Space complexity: O(2N) = O(N) <br>
 * Drawback:
 * - Trees are flatter than LazyUnionFind but could be optimized further using path compression
 */
@SuppressWarnings({"unused"})
class WeightedLazyUnionFind implements UF<Integer> {
    private int[] ids;
    private int[] size;

    /**
     * @param N : [0, ..., size-1], N is the number of elements
     */
    public WeightedLazyUnionFind(int N) {
        this.ids = new int[N];
        for (int i = 0; i < N; i++)
            ids[i] = i; // each element is its own root/parent (initially)

        this.size = new int[N];
        for (int i = 0; i < N; i++)
            size[i] = 1; // each element has size 1 (initially)
    }

    /**
     * Time Complexity: Could be O(logN) in the worst case as we are using find()
     */
    @Override
    public void union(Integer p, Integer q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        if (size[pRoot] < size[qRoot]) {
            ids[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            ids[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snippets {

}

class LazySegmentTree {
    long[] tree;
    long[] lazy;
    int N;

    public LazySegmentTree(int n) {
        N = n;
        tree = new long[4 * N + 1];
        lazy = new long[4 * N + 1];
        Arrays.fill(tree, 0);
        Arrays.fill(lazy, 0);
    }

    public long operation(long a, long b) {
        return a + b;
    }

    public long operation2(long a, long b) {
    	long sum = 0;
    	while(a > 0) {
    		sum += a%10;
    		a/=10;
    	}
        return sum;
    }

    public void build(int l, int r, int ind, List<Integer> v) {
        if (l == r) {
            tree[ind] = v.get(l);
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, 2 * ind + 1, v);
        build(mid + 1, r, 2 * ind + 2, v);
        tree[ind] = operation(tree[2 * ind + 1], tree[2 * ind + 2]);
    }

    public long query(int l, int r, int ind, int i, int j) {
        tree[ind] = operation2(tree[ind], lazy[ind]);
        if (l != r) {
            lazy[2 * ind + 1] = operation2(lazy[2 * ind + 1], lazy[ind]);
            lazy[2 * ind + 2] = operation2(lazy[2 * ind + 2], lazy[ind]);
        }
        lazy[ind] = 0;
        if (r < i || j < l)
            return 0;
        if (i <= l && r <= j)
            return tree[ind];
        int mid = (l + r) / 2;
        return operation(query(l, mid, 2 * ind + 1, i, j), query(mid + 1, r, 2 * ind + 2, i, j));
    }

    public void update(int l, int r, int ind, int i, int j, long val) {
        tree[ind] = operation2(tree[ind], lazy[ind]);
        if (l != r) {
            lazy[2 * ind + 1] = operation2(lazy[2 * ind + 1], lazy[ind]);
            lazy[2 * ind + 2] = operation2(lazy[2 * ind + 2], lazy[ind]);
        }
        lazy[ind] = 0;
        if (r < i || j < l)
            return;
        if (i <= l && r <= j) {
            tree[ind] = operation2(tree[ind], val);
            if (l != r) {
                lazy[2 * ind + 1] = operation2(lazy[2 * ind + 1], val);
                lazy[2 * ind + 2] = operation2(lazy[2 * ind + 2], val);
            }
            return;
        }
        int mid = (l + r) / 2;
        update(l, mid, 2 * ind + 1, i, j, val);
        update(mid + 1, r, 2 * ind + 2, i, j, val);
        tree[ind] = operation(tree[2 * ind + 1], tree[2 * ind + 2]);
    }

    public long makeQuery(int l, int r) {
        return query(0, N, 0, l, r);
    }

    public void makeUpdate(int ind1, int ind2, long val) {
        update(0, N, 0, ind1, ind2, val);
    }

    public void tv() {
        for (long it : tree)
            System.out.print(it + " ");
        System.out.println();
    }
    
    int MAXN = 100001;
    int spf[] = new int[MAXN];

    public void sieve() {
        spf[1] = 1;
        for (int i = 2; i < MAXN; i++)
            spf[i] = i;
        for (int i = 4; i < MAXN; i += 2)
            spf[i] = 2;

        for (int i = 3; i * i < MAXN; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j < MAXN; j += i)
                    if (spf[j] == j)
                        spf[j] = i;
            }
        }
    }

    public ArrayList<Long> primefactors(int x) {
        ArrayList<Long> pf = new ArrayList<Long>(x);
        while (x != 1) {
            long add = spf[x];
            pf.add(add);
            x /= spf[x];
        }
        return pf;
    }
   
}


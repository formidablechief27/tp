// By FormidableChief_27
import java.io.*;
import java.util.*;

public class Main {

    long mod = 998244353;
    long inf = (long) (9e18);
    PrintWriter out = new PrintWriter(System.out);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Scanner SC = new Scanner(System.in);

    String ins() {while (st == null || !st.hasMoreElements()) {try {st = new StringTokenizer(br.readLine());} catch (IOException e) {}} return st.nextToken();}
    char[] inc() {return ins().toCharArray();}
    int ini() {return Integer.parseInt(ins());}
    long in() {return Long.parseLong(ins());}
    double ind() {return Double.parseDouble(ins());}

    void p(String s) {out.print(s);}
    void p(int s) {out.print(s);}
    void p(long s) {out.print(s);}
    void p(double s) {out.print(s);}
    void p(char s) {out.print(s);}
    void pl(String s) {out.println(s);}
    void pl(int s) {out.println(s);}
    void pl(long s) {out.println(s);}
    void pl(double s) {out.println(s);}
    void pl(char c) {out.println(c);}
    void pl() {out.println();}
    void ps(int s) {out.print(s + " ");}
    void ps(long s) {out.print(s + " ");}
    void ps(double s) {out.print(s + " ");}
    void ps(char c) {out.print(c + " ");}
    void yes() {pl("YES");}
    void no() {pl("NO");}

    long max(long a, long b) {return a > b ? a : b;}
    long min(long a, long b) {return a > b ? b : a;}
    long ceil(long a, long b) {return ((long) Math.ceil(((double) (a) / b)));}
    long abs(long a) {if (a < 0) return (-1 * a);return a;}
    long log(long a) {return (long) (Math.log(a));}
    long log2(long a) {return (long) (Math.log(a) / Math.log(2));}
    long gcd(long a, long b) {if (b == 0)return a;return gcd(b, a % b);}
    long lcm(long a, long b) {return ((a * b) / gcd(a, b));}
    long add(long a, long b) {return (((a + mod) % mod + (b + mod) % mod) % mod);}
    long sub(long a, long b) {return (((a + mod) % mod + ((-b) + mod) % mod) % mod);}
    long mul(long a, long b) {return ((a % mod * b % mod) % mod);}
    long inv(long x) {return pow(x, mod - 2);}
    long div(long x, long y) {return mul(x, inv(y));}
    long pow(long a, long b) {a %= mod;long res = 1;while (b > 0) {if ((b & 1) != 0)res = mul(res, a);a = mul(a, a);b /= 2;}return res;}
    long sqrt(long x) {long start = 0, end = (long) 3e9, ans = 1; while (start <= end) {long mid = (start + end) / 2; if (mid * mid <= x) {ans = mid;start = mid + 1;} else end = mid - 1;} return ans;}

    ArrayList<Long> lin(int n) {ArrayList<Long> a = new ArrayList<Long>(n);for (int i = 0; i < n; i++) a.add(in()); return a;}
    long sum(ArrayList<Long> a) {long sum = 0; for(long ele : a) sum += ele; return sum;}
    void sort(ArrayList<Long> a) {Collections.sort(a);}
    void rsort(ArrayList<Long> a) {Collections.sort(a, Collections.reverseOrder());}
    void ps(ArrayList<Long> a) {for(long ele : a) ps(ele); pl();}
    
    long[] in(int n) {long a[] = new long[n]; for (int i = 0; i < n; i++) a[i] = in();return a;}
    int[] ini(int n) {int a[] = new int[n]; for (int i = 0; i < n; i++) a[i] = ini();return a;}
    long sum(long a[]) {long sum = 0; for(long ele : a) sum += ele; return sum;}
    void ps(long a[]) {for(long ele : a) ps(ele); pl();}
    int max(long a[]) {int in = 0;long m = a[0];for (int i = 1; i < a.length; i++) {if (a[i] > m) {m = a[i];in = i;}}return in;}
    int min(long a[]) {int in = 0;long m = a[0];for (int i = 1; i < a.length; i++) {if (a[i] < m) {m = a[i];in = i;}}return in;}
    void sort(long a[]) {divide(a, 0, a.length - 1, true);}
    void rsort(long a[]) {divide(a, 0, a.length - 1, false);}
    void divide(long a[], int l, int r, boolean order) {if (l < r) {int m = l + (r - l) / 2;divide(a, l, m, order);divide(a, m + 1, r, order);merge(a, l, m, r, order);}}
    void merge(long a[], int l, int m, int r, boolean order) {int n1 = m - l + 1;int n2 = r - m;long L[] = new long[n1];long R[] = new long[n2];for (int i = 0; i < n1; ++i) L[i] = a[l + i];for (int j = 0; j < n2; ++j) R[j] = a[m + 1 + j];int i = 0, j = 0; int k = l;while (i < n1 && j < n2) {if ((L[i] <= R[j] && order) || (L[i] >= R[j] && !order)) {a[k] = L[i];i++;} else {a[k] = R[j];j++;}k++;}while (i < n1) {a[k] = L[i];i++;k++;}while (j < n2) {a[k] = R[j];j++;k++;}}
    void sort(long a[][]) {divide(a, 0, a[0].length - 1, true);}
    void rsort(long a[][]) {divide(a, 0, a[0].length - 1, false);}
    void divide(long a[][], int l, int r, boolean order) {if (l < r) {int m = l + (r - l) / 2;divide(a, l, m, order);divide(a, m + 1, r,order);merge(a, l, m, r, order);}}
    void merge(long a[][], int l, int m, int r, boolean order) {int n1 = m - l + 1;int n2 = r - m;long L[] = new long[n1]; long R[] = new long[n2];long b1[][] = new long[a.length][n1]; long b2[][] = new long[a.length][n2];for (int i = 0; i < n1; ++i) {L[i] = a[0][l + i];for (int p = 1; p < a.length; p++) b1[p][i] = a[p][l + i];}for (int j = 0; j < n2; ++j) {R[j] = a[0][m + 1 + j];for (int p = 1; p < a.length; p++) b2[p][j] = a[p][m + 1 + j];}int i = 0, j = 0; int k = l;while (i < n1 && j < n2) {if ((L[i] <= R[j] && order) || (L[i] >= R[j] && !order)) {a[0][k] = L[i]; for (int p = 1; p < a.length; p++) a[p][k] = b1[p][i];i++;} else {a[0][k] = R[j];for (int p = 1; p < a.length; p++) a[p][k] = b2[p][j];j++;}k++;}while (i < n1) {a[0][k] = L[i];for (int p = 1; p < a.length; p++) a[p][k] = b1[p][i];i++;k++;}while (j < n2) {a[0][k] = R[j];for (int p = 1; p < a.length; p++) a[p][k] = b2[p][j];j++;k++;}}
    
    void fillmap(Map<Long, Long> map, long a[]) {for (int i = 0; i < a.length; i++) {fill(map, a[i]);}}
    void fill(Map<Long, Long> map, long val) {if (map.containsKey(val))map.put(val, map.get(val) + 1); else map.put(val, (long) 1);}
    void fill(Map<Long, Long> map, long val, long count) {if(map.containsKey(val)) map.put(val, map.get(val) + count); else map.put(val, count);}
    void remove(Map<Long, Long> map, long val) {if (map.get(val) == 1) map.remove(val); else map.replace(val, map.get(val) - 1);}
    void replace(Map<Long, Long> map, long val, long newval) {remove(map, val);fill(map, newval);}
    void fill(Map<Long, ArrayList<Long>> map, long a[]) {for (int i = 0; i < a.length; i++) {fill(map, a[i], i);}}
    void fill(Map<Long, ArrayList<Long>> map, long val, int i) {if (map.containsKey(val)) map.get(val).add((long) i); else {ArrayList<Long> index = new ArrayList<>();index.add((long) i);map.put(val, index);}}
    void lfill(Map<Long, Long> map, ArrayList<Long> a) {for (Map.Entry<Long, Long> entry : map.entrySet()) {long val = entry.getValue(); long key = entry.getKey();for (long j = 0; j < val; j++) a.add(key);}}
    int MAXN = 1000001;int spf[] = new int[MAXN];
    public void sieve() {spf[1] = 1; for (int i = 2; i < MAXN; i++) spf[i] = i;for (int i = 4; i < MAXN; i += 2) spf[i] = 2;for (int i = 3; i * i < MAXN; i++) if (spf[i] == i) for (int j = i * i; j < MAXN; j += i) if (spf[j] == j) spf[j] = i;}
    public void primefactors(HashMap<Long, Long> map, int x) {while (x != 1) {fill(map, spf[x]);x /= spf[x];}}
   
    ArrayList<Integer> search(char text[], char pattern[]) {ArrayList<Integer> indexes = new ArrayList<Integer>(text.length);int m = pattern.length;int n = text.length;long d = 31;long hashp = 0;long hasht = 0;long h = 1;for (int i = 0; i < m - 1; i++) {h = mul(h, d);}for (int i = 0; i < m; i++) {hashp = add(mul(d, hashp), pattern[i]);hasht = add(mul(d, hasht), text[i]);}for (int i = 0; i <= n - m; i++) {if (hashp == hasht) {indexes.add(i);}if (i < n - m) {hasht = add(mul(d, (sub(hasht, mul(text[i], h)))), text[i + m]);if (hasht < 0)hasht = add(hasht, mod);}}return indexes;}
    long[] prehash(char ch[]) {int n = ch.length;long ans[] = new long[n];long a = 0;long pr = 1;for (int i = 0; i < n; i++) {a = add(a, mul(sub(ch[i], 96), pr));pr = mul(pr, 31);ans[i] = a;}return ans;}
    long subhash(long ans[], int start, int end) {return div(sub(ans[end], ans[start - 1]), pow(31, start));}
    char[] substring(char a[], int start, int end) {char ch[] = new char[end - start];int index = 0;for (int i = start; i < end; i++) ch[index++] = a[i];return ch;}
    boolean equals(char a[], char b[]) {for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;return a.length == b.length;}
    char[] append(char a[], char[] b) {char ch[] = new char[a.length + b.length];int i = 0; for (i = 0; i < a.length; i++) ch[i] = a[i]; for (int j = 0; j < b.length; j++) ch[i++] = b[j];return ch;}
    void p(char[] c) {for (char ch : c) p(ch);}
    void ps(char[] c) {for (char ch : c) ps(ch); pl();}
    void pl(char[] c) {for (char ch : c) p(ch); pl();}
    void fillcount(char ch[], long count[]) {for (int i = 0; i < ch.length; i++) count[ch[i] - 97]++;}
    ArrayList<Long>[] fill(char c1[]) {ArrayList<Long> ch[] = new ArrayList[26];for(int i=0;i<26;i++) ch[i] = new ArrayList<>();for(int i=0;i<c1.length;i++) ch[c1[i]-97].add((long)i);return ch;}
    
    int upper_bound(long a[], long val) {int start = 0;int end = a.length - 1;while (start <= end) {int mid = (start + end) / 2;if (a[mid] >= val) {if (mid == 0 || a[mid-1] < val)return mid;end = mid - 1;} else start = mid + 1;}return -1;}
    int upper_bound(ArrayList<Long> a, long val) {if (a.size() == 0)return -1;int start = 0;int end = a.size() - 1;while (start <= end) {int mid = (start + end) / 2;if (a.get(mid) >= val) {if (mid == 0 || a.get(mid-1) < val) return mid;end = mid - 1;} else start = mid + 1;}return -1;}
    int lower_bound(ArrayList<Long> a, long val) {if (a.size() == 0)return -1;int start = 0;int end = a.size() - 1;while (start <= end) {int mid = (start + end) / 2;if (a.get(mid) > val) {end = mid - 1;continue;} else {if (mid == a.size() - 1 || a.get(mid+1) > val) return mid; start = mid + 1;}}return -1;}
    int lower_bound(long a[], long val) {int start = 0;int end = a.length - 1;while (start <= end) {int mid = (start + end) / 2;if (a[mid] > val) {end = mid - 1;continue;} else {if (mid == a.length - 1 || a[mid + 1] > val) return mid; start = mid + 1;}}return -1;}
    
    PriorityQueue<long[]> queue() {PriorityQueue<long[]> queue = new PriorityQueue<long[]>((a, b) -> {if (a[0] > b[0]) return 1; else if (a[0] == b[0] && a[1] > b[1]) return 1; else return -1;});return queue;}
    
    // Here we go
    public static void main(String args[]) {
        Main FC27 = new Main();
        FC27.start();
    }

    // This is where the fun begins
    public void start() {
        int t = 1;
        //t = ini();
        while(t-- > 0) {
            solve();
        }
        out.close();
    }

    // This one's for you ;)
    public void solve() {
    	sieve();
    	int n = ini();
    	long a[] = in(n);
    	int i1 = ini() - 1;
    	int i2 = ini() - 1;
    	if(i1 == i2) {
    		pl(1);
    		pl(i1 + 1);
    		return;
    	}
    	if(a[i1] == a[i2] && a[i1] != 1) {
    		pl(2);
    		ps(i1 + 1);
    		ps(i2 + 1);
    		return;
    	}
    	HashMap<Long, Integer> indx = new HashMap<>();
    	for(int i=0;i<n;i++) indx.put(a[i], i);
    	HashMap<Long, Long> map[] = new HashMap[n];
    	for(int i=0;i<n;i++) map[i] = new HashMap<>();
    	for(int i=0;i<n;i++) primefactors(map[i], (int)a[i]);
    	HashMap<Long, HashSet<Long>> fmap = new HashMap<>();
    	for(int i=0;i<n;i++) {
    		for(Map.Entry<Long, Long> entry : map[i].entrySet()) {
    			if(fmap.containsKey(entry.getKey())) fmap.get(entry.getKey()).add(a[i]);
    			else {
    				HashSet<Long> set = new HashSet<>(); set.add(a[i]);
    				fmap.put(entry.getKey(), set);
    			}
    		}
    	}
    	Queue<long[]> queue = new LinkedList<>();
    	queue.add(new long[] {a[i1], i1});
    	indx.remove(a[i1]);
    	long dis[] = new long[n];
    	dis[i1] = 0;
    	for(int i=0;i<n;i++) if(i != i1) dis[i] = inf;
    	HashSet<Long> set = new HashSet<>();
    	for(int i=0;i<n;i++) if(i != i1) set.add(a[i]);
    	HashMap<Long, Long> pairs = new HashMap<>();
    	HashMap<Long, Integer> fset = new HashMap<>();
    	for(int i=0;i<n;i++) fset.put(a[i] , i);
    	while(!queue.isEmpty()) {
    		long ele[] = queue.poll();
    		int index = (int)ele[1];
    		HashSet<Long> dist = new HashSet<>();
    		HashSet<Long> dist2 = new HashSet<>();
    		for(Map.Entry<Long, Long> entry : map[index].entrySet()) for(long el : fmap.get(entry.getKey())) if(indx.containsKey(el)) dist.add(el); else dist2.add(el);
    		for(long el : dist2) for(Map.Entry<Long, Long> entry : map[index].entrySet()) fmap.get(entry.getKey()).remove(el);
    		for(long el : dist) {
    			int ind = indx.get(el);
    			indx.remove(el);
    			dis[ind] = min(dis[ind], dis[index] + 1L);
    			pairs.put(el, ele[0]);
    			if(el == a[i2]) {
    				pl(dis[ind] + 1);
    				long val = el;
    				ArrayList<Integer> ans = new ArrayList<>();
    				while(true) {
    					ans.add(fset.get(val));
    					if(val == a[i1]) {
    						Collections.reverse(ans);
    						for(int e : ans) ps(e + 1);
    						return;
    					}
    					val = pairs.get(val);
    				}
    			}
    			queue.add(new long[] {el, ind});
    		}
    	}
    	pl(-1);
    }
} 
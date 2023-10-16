// By FormidableChief_27
import java.io.*;
import java.util.*;

class Rextester {

    // Dont ask kaise banaya hai ye ;)
    long mod = (long)1e9 + 7;
    long inf = (long)(1e18);
    PrintWriter out = new PrintWriter(System.out);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Scanner SC = new Scanner(System.in);

    // Here we go
    public static void main(String args[]) {
        Rextester FC27 = new Rextester();
        FC27.start();
    }
    
    String ins() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    char[] inc() {
        return ins().toCharArray();
    }

    int ini() {
        return Integer.parseInt(ins());
    }

    long in() {
        return Long.parseLong(ins());
    }

    double ind() {
        return Double.parseDouble(ins());
    }

    String insn() {
        String str = "";
        try {
            if (st.hasMoreTokens()) {
                str = st.nextToken("\n");
            } else {
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    // Print functions
    // out.println() likh sakta hu but time bach raha hai toh sab sahi ;)
    public void p(String s) {
        out.print(s);
    }

    public void p(int s) {
        out.print(s);
    }

    public void p(long s) {
        out.print(s);
    }

    public void p(double s) {
        out.print(s);
    }

    public void p(char s) {
        out.print(s);
    }

    public void pl(String s) {
        out.println(s);
    }

    public void pl(int s) {
        out.println(s);
    }

    public void pl(long s) {
        out.println(s);
    }

    public void pl(double s) {
        out.println(s);
    }
    
    public void pl(char c) {
    	out.println(c);
    }

    public void pl() {
        out.println();
    }

    public void ps(int s) {
        out.print(s + " ");
    }

    public void ps(long s) {
        out.print(s + " ");
    }

    public void ps(double s) {
        out.print(s + " ");
    }

    // Math functions
    public long max(long a, long b) {
        return a > b ? a : b;
    }

    public long min(long a, long b) {
        return a > b ? b : a;
    }

    public long ceil(long a, long b) {
        return ((long) Math.ceil(((double) (a) / b)));
    }

    public long abs(long a) {
        if (a < 0) {
            return (-1 * a);
        }
        return a;
    }
    
    public long log(long a) {
    	return (long)(Math.log(a));
    }
    
    public long log2(long a) {
    	return (long)(Math.log(a)/Math.log(2));
    }

    // lcm and gcd bhi nikal jao khud se ;)
    public long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return ((a*b) / gcd(a, b));
    }
    
    // modular arithmetic. Wrong answer nahi aayega ab ;)
    public long add(long a, long b) {
        return (((a + mod) % mod + (b + mod) % mod) % mod);
    }

    public long sub(long a, long b) {
        return (((a + mod) % mod + ((-1 * b) + mod) % mod) % mod);
    }

    public long mul(long a, long b) {
        return ((a % mod * b % mod) % mod);
    }
    
    public long inv(long x) {
        return pow(x, mod - 2);
    }
     
    public long div(long x, long y) {
        return mul(x, inv(y));
    }
    
    // Dont know kaise but ha isse power nikalta hai
    public long pow(long a, long b) {
        a %= mod;
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0)
                res = mul(res, a);
            a = mul(a, a);
            b /= 2;
        }
        return res;
    }

    // O(root n)
    public boolean prime(long n) {
        for (long i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public HashMap<Long, Long> primeFactors(long n){
    	HashMap<Long, Long> map = new HashMap<Long, Long>();
    	while (n%2==0) {
    		fill(map, 2);
            n /= 2;
        }
        for (long i = 3; i <= sqrt(n); i+= 2) {
            while (n%i == 0) {
            	fill(map, i);
                n /= i;
            }
        }
        if (n > 2)
        	fill(map, n);
    	return map;
    }

    // Precise Integer square root
    // Math.sqrt doesnt work precisely for big numbers :(
    public long sqrt(long x) {
    	long start = 0, end = (long)3e9, ans = 1;
        while(start<=end){
            long mid = (start+end)/2;
            if(mid*mid<=x){
                ans = mid;
                start = mid+1;
            }
            else
                end = mid-1;
        }
        return ans;
    }

    // Print yes and no
    public void yes() {
        out.println("Yes");
    }

    public void no() {
        out.println("No");
    }

    // Basic list operations
    public ArrayList<Long> lin(int n) {
        ArrayList<Long> a = new ArrayList<Long>(n);
        for (int i = 0; i < n; i++) {
            a.add(in());
        }
        return a;
    }

    public long sum(ArrayList<Long> a) {
        long s = 0;
        for (int i = 0; i < a.size(); i++) {
            s += a.get(i);
        }
        return s;
    }

    public void sort(ArrayList<Long> a) {
        Collections.sort(a);
    }

    public void rsort(ArrayList<Long> a) {
        Collections.sort(a, Collections.reverseOrder());
    }
    
    // Nice
    public void ps(ArrayList<Long> a) {
        a.stream().forEach(i -> {
            out.print(i + " ");
        });
        out.println();
    }
    
    public void ps(ArrayList<Long>[] a) {
    	for(int i=0;i<a.length;i++) {
    		p((i+1) + " --> ");
    		ps(a[i]);
    	}
    }

    // Input lene ka loop bhi likhne ka time nahi hai :\
    public long[] in(int n) {
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in();
        }
        return a;
    }
    
    public int[] ini(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ini();
        }
        return a;
    }

    // Its simple really
    public long sum(long a[]) {
        long s = 0;
        for (int i = 0; i < a.length; i++) {
            s = (s+ a[i]);
        }
        return s;
    }

    // Pak gaya loop laga laga ke toh finally bana diya :(
    public int max(long a[]) {
    	int in = 0;
    	long m = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > m) {
                m = a[i];
                in = i;
            }
        }
        return in;
    }
    
    public int min(long a[]) {
    	int in = 0;
    	long m = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < m) {
                m = a[i];
                in = i;
            }
        }
        return in;
    }

    // Ab isse kehte hai shortcut op ;)
    public void ps(long a[]) {
        for (int i = 0; i < a.length; i++) {
            out.print(a[i] + " ");
        }
        out.println();
    }
    
    public void ps(double a[]) {
        for (int i = 0; i < a.length; i++) {
            out.print(a[i] + " ");
        }
        out.println();
    }
    
    public void ps(int a[]) {
        for (int i = 0; i < a.length; i++) {
            out.print(a[i] + " ");
        }
        out.println();
    }

    // String(char[]) functions. Bas string se bohot TLE dekh liya maine abhi char[]
    // hi use karna padega :(
    public boolean palin(char s[]) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            if (s[i] != s[n - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean palin(char s[], int start, int end) {
        int n = end;
        for (int i = start; i < n / 2; i++) {
            if (s[i] != s[n - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public char[] substring(char a[], int start, int end) {
        char ch[] = new char[end - start];
        int index = 0;
        for (int i = start; i < end; i++) {
            ch[index++] = a[i];
        }
        return ch;
    }

    public char[] convert(String a) {
        return a.toCharArray();
    }

    public char lower(char ch) {
        if (ch <= 90) {
            ch += 32;
        }
        return ch;
    }

    public char upper(char ch) {
        if (ch >= 97) {
            ch -= 32;
        }
        return ch;
    }

    public void lower(char[] ch) {
        for (int i = 0; i < ch.length; i++) {
            ch[i] = lower(ch[i]);
        }
    }

    public void upper(char[] ch) {
        for (int i = 0; i < ch.length; i++) {
            ch[i] = upper(ch[i]);
        }
    }

    public boolean equals(char a[], char b[]) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public int compare(char a[], char b[]) {
        int l = a.length > b.length ? b.length : a.length;
        for (int i = 0; i < l; i++) {
            if (a[i] != b[i]) {
                return a[i] - b[i];
            }
        }
        return (int) abs(a.length - b.length);
    }
    
    public ArrayList<Integer> search(char text[], char pattern[]){
    	ArrayList<Integer> indexes = new ArrayList<Integer>(text.length);
    	int m = pattern.length;
    	int n = text.length;
    	long d = 31;
    	long hashp = 0;
    	long hasht = 0;
    	long h = 1;
    	for (int i = 0; i < m - 1; i++) {
    		h = mul(h,d);
    	}
    	for (int i = 0; i < m; i++) {
    		hashp = add(mul(d,hashp),pattern[i]);
    		hasht = add(mul(d,hasht),text[i]);
        }
    	
    	for (int i = 0; i <= n-m; i++) {
            if (hashp == hasht) {
                indexes.add(i);
            }
            if (i < n - m) {
            	hasht = add(mul(d,(sub(hasht,mul(text[i],h)))),text[i+m]);
                if (hasht < 0)
                	hasht = add(hasht,mod);
            }
        }
    	return indexes;
    }
    
    public long[] prehash(char ch[]) {
    	int n = ch.length;
    	long ans[] = new long[n];
    	long a = 0;
    	long pr = 1;
    	for(int i=0;i<n;i++) {
    		a = add(a,mul(sub(ch[i],96),pr));
    		pr = mul(pr,31);
    		ans[i] = a;
    	}
    	return ans;
    }
    
    public long subhash(long ans[], int start, int end) {
    	return div(sub(ans[end],ans[start-1]),pow(31,start));
    }

    public char[] concat(String a, String b) {
        return a.concat(b).toCharArray();
    }

    public char[] concat(char a[], char b[]) {
        char ch[] = new char[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            ch[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            ch[i + a.length] = b[i];
        }
        return ch;
    }
    
    public char[] append(char a[], char[] b) {
    	char ch[] = new char[a.length+b.length];
    	int i = 0;
    	for(i=0;i<a.length;i++) {
    		ch[i] = a[i];
    	}
    	for(int j=0;j<b.length;j++) {
    		ch[i++] = b[j];
    	}
    	return ch;
    }

    int[] subtract(char ans[], char ch[]) {
		int a[] = new int[ans.length];
		int n = a.length;
		int i = n-1;
		while(true) {
			int v1 = ans[i]-48;
			int v2 = ch[i]-48;
			if(v1 >= v2) {
				a[i] = v1-v2;
			}
			else {
				v1 += 10;
				ans[i-1]--;
				a[i] = v1-v2;
			}
			i--;
			if(i < 0) {
				break;
			}
		}
		return a;
	}
    
    public void p(char[] c) {
        for (int i = 0; i < c.length; i++) {
            out.print(c[i]);
        }
    }

    public void ps(char[] c) {
        for (int i = 0; i < c.length; i++) {
            out.print(c[i] + " ");
        }
        out.println();
    }

    public void pl(char[] c) {
        for (int i = 0; i < c.length; i++) {
            out.print(c[i]);
        }
        out.println();
    }
    
    public void fillcount(char ch[], long count[]) {
    	for(int i=0;i<ch.length;i++) {
    		count[ch[i]-97]++;
    	}
    }
    
    public void filllist(ArrayList<Long> a , Map<Long, Long> map) {
    	for(Map.Entry<Long, Long> entry : map.entrySet()) {
    		long val = entry.getValue();
    		long key = entry.getKey();
    		for(long j=0;j<val;j++) {
    			a.add(key);
    		}
    	}
    }
    
    public void fillmap(long a[], Map<Long,Long> map) {
    	for(int i=0;i<a.length;i++) {
    		fill(map, a[i]);
    	}
    }
    
    public void fill(Map<Long, Long> map, long val) {
    	if(map.containsKey(val)) {
    		map.put(val, map.get(val)+1);
    	}
    	else {
    		map.put(val, (long) 1);
    	}
    }
    
    public void remove(Map<Long, Long> map, long val) {
    	long p = map.get(val);
    	if(p==1) {
    		map.remove(val);
    	}
    	else {
    		map.replace(val, p-1);
    	}
    }
    
    public void fill(Map<Long, ArrayList<Long>> map, long a[]) {
    	int n = a.length;
    	for(int i=0;i<n;i++) {
    		if(map.containsKey(a[i])){
    			map.get(a[i]).add((long)i);
    		}
    		else{
    			ArrayList<Long> index = new ArrayList<>();
    			index.add((long)i);
    			map.put(a[i], index);
    		}
    	}
    }
    
    public void replace(Map<Long, Long> map, long val, long newval) {
    	remove(map, val);
    	fill(map, newval);
    }
    
    public static Set<Long> primes(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        Set<Long> primeList = new HashSet<Long>(n);
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                primeList.add((long)i);
            }
        }
        return primeList;
    }
    
    int MAXN = 100001;
    int spf[] = new int[MAXN];
    public void sieve() {
        spf[1] = 1;
        for (int i=2; i<MAXN; i++)
            spf[i] = i;
        for (int i=4; i<MAXN; i+=2)
            spf[i] = 2;
      
        for (int i=3; i*i<MAXN; i++)
        {
            if (spf[i] == i)
            {
                for (int j=i*i; j<MAXN; j+=i)
                    if (spf[j]==j)
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
    
    // Sort 1-D array
    public void sort(long a[]) {
        divide(a, 0, a.length - 1);
    }

    public void divide(long a[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            divide(a, l, m);
            divide(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public void merge(long a[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        long L[] = new long[n1];
        long R[] = new long[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = a[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = a[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    // Sort 1-D array in descending order
    public void rsort(long a[]) {
        rdivide(a, 0, a.length - 1);
    }

    public void rdivide(long a[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            rdivide(a, l, m);
            rdivide(a, m + 1, r);
            rmerge(a, l, m, r);
        }
    }

    public void rmerge(long a[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        long L[] = new long[n1];
        long R[] = new long[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = a[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = a[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    // Sort 2-D array in ascending order based on first row
    // Dedh shaana ki tarah vector of pairs banake sort nahi kar sakta na :(
    // Priority Queue bhi bohot slow hai :|
    public void sort(long a[][]) {
        divide(a, 0, a[0].length - 1);
    }

    public void divide(long a[][], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            divide(a, l, m);
            divide(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public void merge(long a[][], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        long L[] = new long[n1];
        long R[] = new long[n2];
        long b1[][] = new long[a.length][n1];
        long b2[][] = new long[a.length][n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = a[0][l + i];
            for (int p = 1; p < a.length; p++) {
                b1[p][i] = a[p][l + i];
            }
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = a[0][m + 1 + j];
            for (int p = 1; p < a.length; p++) {
                b2[p][j] = a[p][m + 1 + j];
            }
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[0][k] = L[i];
                for (int p = 1; p < a.length; p++) {
                    a[p][k] = b1[p][i];
                }
                i++;
            } else {
                a[0][k] = R[j];
                for (int p = 1; p < a.length; p++) {
                    a[p][k] = b2[p][j];
                }
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[0][k] = L[i];
            for (int p = 1; p < a.length; p++) {
                a[p][k] = b1[p][i];
            }
            i++;
            k++;
        }
        while (j < n2) {
            a[0][k] = R[j];
            for (int p = 1; p < a.length; p++) {
                a[p][k] = b2[p][j];
            }
            j++;
            k++;
        }
    }

    // Sort 2-D array in descending order based on values of first row
    public void rsort(long a[][]) {
        rdivide(a, 0, a[0].length - 1);
    }

    public void rdivide(long a[][], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            rdivide(a, l, m);
            rdivide(a, m + 1, r);
            rmerge(a, l, m, r);
        }
    }

    public void rmerge(long a[][], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        long L[] = new long[n1];
        long R[] = new long[n2];
        long b1[][] = new long[a.length][n1];
        long b2[][] = new long[a.length][n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = a[0][l + i];
            for (int p = 1; p < a.length; p++) {
                b1[p][i] = a[p][l + i];
            }
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = a[0][m + 1 + j];
            for (int p = 1; p < a.length; p++) {
                b2[p][j] = a[p][m + 1 + j];
            }
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                a[0][k] = L[i];
                for (int p = 1; p < a.length; p++) {
                    a[p][k] = b1[p][i];
                }
                i++;
            } else {
                a[0][k] = R[j];
                for (int p = 1; p < a.length; p++) {
                    a[p][k] = b2[p][j];
                }
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[0][k] = L[i];
            for (int p = 1; p < a.length; p++) {
                a[p][k] = b1[p][i];
            }
            i++;
            k++;
        }
        while (j < n2) {
            a[0][k] = R[j];
            for (int p = 1; p < a.length; p++) {
                a[p][k] = b2[p][j];
            }
            j++;
            k++;
        }
    }

    // Just in case JEE brain starts working again
    public long ncr(int n, int k) {
        long D[][] = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= min(i, k); j++) {
                if (j == 0 || j == i)
                    D[i][j] = 1;
                else
                    D[i][j] = add(D[i - 1][j - 1] , D[i - 1][j]);
            }
        }
        return D[n][k];
    }
    
    // Only way to escape TLE :(
    public long binarysearch(long a[], long val) {
        int index = -1;
        int first = 0;
        int last = a.length - 1;
        int mid = (first + last) / 2;
        while (first <= last) {
            if (a[mid] < val) {
                first = mid + 1;
            } else if (a[mid] == val) {
                return mid;
            } else {
                last = mid - 1;
            }
            if(first==last && a[first]!=val) {
            	return -first;
            }
            mid = (first + last) / 2;
        }
        return index;
    }
    
    public boolean vowel(char ch) {
        if(ch=='a')
            return true;
        if(ch=='e') 
            return true;
        if(ch=='i')
            return true;
        if(ch=='o')
            return true;
        if(ch=='u')
            return true;
        return false;
    }
   
    public static long mex(ArrayList<Long> a) {
    	  int n = a.size();
    	  HashSet <Long> hash = new HashSet <Long> ();
    	  for (int i = 0; i < n; i++) {
    		  hash.add(a.get(i));
    	  }
    	  for (long i = 0; i <= n + 1; i++) {
	    	  if (!hash.contains(i)) {
	    	    return i;
	    	  }
    	  }
    	  return -1;
    }
    
    public long maxsubsum(long a[]) {
    	int n = a.length;
        long ans = -((long)(1e18)); 
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
            if (ans < sum)
                ans = sum;
            if (sum < 0)
                sum = 0;
        }
        return ans;
    }
    
    public int upper_bound(long a[], long val) {
    	int start = 0;
    	int end = a.length-1;
    	while(start <= end) {
    		int mid = (start+end)/2;
    		if(a[mid] >= val) {
    			if(mid == 0) return mid;
    			if(a[mid-1] < val) return mid;
    			end = mid-1;
    		}
    		else {
    			start = mid+1;
    		}
    	}
    	return -1;
    }
    
    public int upper_bound(ArrayList<Long> a, long val) {
    	if(a.size() == 0) return -1;
    	int start = 0;
    	int end = a.size()-1;
    	while(start <= end) {
    		int mid = (start+end)/2;
    		if(a.get(mid) >= val) {
    			if(mid == 0) return mid;
    			if(a.get(mid-1) < val) return mid;
    			end = mid-1;
    		}
    		else {
    			start = mid+1;
    		}
    	}
    	return -1;
    }
    
    public int lower_bound(ArrayList<Long> a, long val) {
    	if(a.size() == 0) return -1;
    	int n = a.size();
    	int start = 0;
    	int end = n-1;
    	while(start <= end) {
    		int mid = (start+end)/2;
    		if(a.get(mid) > val) {
    			end = mid-1;
    			continue;
    		}
    		else {
    			if(mid == n-1) {
    				return mid;
    			}
    			if(a.get(mid+1) > val) {
    				return mid;
    			}
    			start = mid+1;
    		}
    	}
    	return -1;
    }
    
    public int lower_bound(long a[], long val) {
    	int n = a.length;
    	int start = 0;
    	int end = n-1;
    	while(start <= end) {
    		int mid = (start+end)/2;
    		if(a[mid] > val) {
    			end = mid-1;
    			continue;
    		}
    		else {
    			if(mid == n-1) {
    				return mid;
    			}
    			if(a[mid+1] > val) {
    				return mid;
    			}
    			start = mid+1;
    		}
    	}
    	return -1;
    }
    
    public PriorityQueue<long[]> queue(int index, int size, boolean order){
    	if(size == 2) {
    		PriorityQueue<long[]> queue = new PriorityQueue<long[]>((a,b)->{
                if(order) {
                	if (a[index] > b[index]){
                        return 1;
                	}
                	else if (a[index] == b[index] && a[index+1] > b[index+1]) {
                		return 1;
                	}
                    else{
                        return -1;
                    }
                }
                else {
                	if (a[index] < b[index]){
                        return 1;
                    }
                	else if (a[index] == b[index] && a[index+1] < b[index+1]) {
                		return 1;
                	}
                    else{
                        return -1;
                    }
                }
            });
    	}
    	if(size == 3) {
    		PriorityQueue<long[]> queue = new PriorityQueue<long[]>((a,b)->{
                if(order) {
                	if (a[index] > b[index]){
                        return 1;
                	}
                	else if (a[index] == b[index] && a[index+1] > b[index+1]) {
                		return 1;
                	}
                	else {
                		return -1;
                	}
                }
                else {
                	return -1;
                }
    		});
    		return queue;
    	}
    	PriorityQueue<long[]> queue = new PriorityQueue<long[]>();
    	return queue;
    }
    
    class Pair {
        long f, s;
        ArrayList<Long> st = new ArrayList<>();
        Pair(long a, long b) {
            f = a;
            s = b;
        }
        Pair(long a, ArrayList<Long> st){
        	f = a;
        	this.st = st;
        }
        @Override
        public int hashCode() {
            return Objects.hash(f, s);
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Pair pair = (Pair) obj;
            return f == pair.f && s == pair.s;
        }
    }
    
    // This is where the fun begins
    public void start() {
    	long t = 1;
    	//t = in();
        while(t-- > 0) {
            solve();
        }
        out.close();
    }
    
    // This one's for you ;)
    public void solve() {
    	int n = ini();
    	PriorityQueue<long[]> queue = queue(0, 3, true);
    	for(int i=0;i<n;i++) {
    		long l = in();
    		long r = in();
    		long cost = in();
    		queue.add(new long[] {l, r, cost});
    	}
    	ArrayList<long[]> q = new ArrayList<>();
    	while(!queue.isEmpty()) {
    		long range[] = queue.poll();
    		q.add(range);
    	}
    	long dp[] = new long[n];
    	for(int i=0;i<n;i++) {
    		dp[i] = q.get(i)[2];
    		for(int j=0;j<i;j++) {
    			if(q.get(j)[1] < q.get(i)[0]) {
    				dp[i] = max(dp[i], dp[j] + q.get(i)[2]);
    			}
    		}
    	}
    	pl(max(dp));
    }
} 
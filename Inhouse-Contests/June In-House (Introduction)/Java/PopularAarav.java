// Written by Neil Thistlewaite

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
 
public class I {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Node[] g = new Node[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Node(Integer.parseInt(st.nextToken()) == 1);
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a-1].adj.add(g[b-1]);
            g[b-1].adj.add(g[a-1]);
        }
        out.println(dfs(null,g[0],true));
        out.close();
        System.exit(0);
    }
 
    public static int dfs(Node p, Node c, boolean good) {
        int count = 0;
        for (Node a : c.adj) {
            if (a == p) continue;
            if (!good) {
                if (a.f) count+=1;
                else     count+=2;
            }
            if (a.f) {
                count += dfs(c, a, good);
            } else {
                count += dfs(c, a, false);
            }
        }
        return count;
    }
 
    public static long max(long a, long b) {
        return a > b ? a : b;
    }
}
 
class Node {
    public boolean f;
    public ArrayList<Node> adj;
 
    public Node(boolean f) {
        this.f = f;
        this.adj = new ArrayList<>();
    }
}
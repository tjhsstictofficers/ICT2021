// Written by Neil Thistlewaite

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
 
public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int smaller = 0;
        int larger = 0;
        int equal = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a > m) {
                larger++;
            } else if (a < m) {
                smaller++;
            } else {
                equal++;
            }
        }
        if (equal == 0) {
            if (larger > smaller) {
                out.println(1 + (larger - 1 - smaller));
            } else {
                out.println(1 + (smaller - larger));
            }
        } else {
            int mid = (n + 1) / 2;
            if (smaller >= mid) { // must add copies of M
                if (n % 2 == 0) { // 1,1 2,1 3,2 
                    out.println(1 + 2 * (smaller - mid));
                } else {
                    out.println(2 * (smaller - mid + 1));
                }
            } else { // must add smaller than M
                if (mid <= smaller + equal) {
                    out.println(0);
                } else {
                    if (n % 2 == 0) {
                        out.println(2 * (mid - (smaller + equal)));
                    } else {
                        out.println(1 + 2 * (mid - (smaller + equal + 1)));
                    }
                }
            }
        }
 
        out.close();
        System.exit(0);
    }
}
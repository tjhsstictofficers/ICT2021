import java.io.*;
import java.util.*;

public class hh {
	static class state implements Comparable<state>{
		int r, c, d = 0, s = 0;
		public state(int a, int b, int e, int f) {
			r = a;
			c = b;
			d = e;
			s = f;
		}
      public int compareTo(state a){
         return d-a.d;
      }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int sr = 0, sc = 0;
		char[][] room = new char[n][m];
		boolean[][][] done = new boolean[5][n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				room[i][j] = s.charAt(j);
				if (room[i][j] == 'A') {
					sr = i;
					sc = j;
				}
			}
		}
		PriorityQueue<state> q = new PriorityQueue<state>();
		q.add(new state(sr, sc, 0, 0));
		boolean pf = false;
		while (!q.isEmpty()) {
			state curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int d = curr.d;
			int s = curr.s;
			if (done[s][r][c]) {
				continue;
			}
			if (room[r][c] == 'E') {
			    pf = true;
				System.out.println(d);
				break;
			}
			done[s][r][c] = true;
			if (s == 0) {
				if (r > 0 && room[r-1][c] != '#') { //up
					if (room[r-1][c] == 'S') {
						q.add(new state(r-1,c,d+1,1));
					} else {
						q.add(new state(r-1,c,d+1,0));
					}
				}
				if (r < n-1 && room[r+1][c] != '#') { //down
					if (room[r+1][c] == 'S') {
						q.add(new state(r+1,c,d+1,2));
					} else {
						q.add(new state(r+1,c,d+1,0));
					}
				}
				if (c > 0 && room[r][c-1] != '#') { //left
					if (room[r][c-1] == 'S') {
						q.add(new state(r,c-1,d+1,3));
					} else {
						q.add(new state(r,c-1,d+1,0));
					}
				}
				if (c < m-1 && room[r][c+1] != '#') { //right
					if (room[r][c+1] == 'S') {
						q.add(new state(r,c+1,d+1,4));
					} else {
						q.add(new state(r,c+1,d+1,0));
					}
				}
			} else {
				if (s == 1) {
					if (r == 0 || room[r-1][c] == '#') {
						q.add(new state(r, c, d, 0));
					} else {
						q.add(new state(r-1, c, d+1, 1));
					}
				}
				if (s == 2) {
					if (r == n-1 || room[r+1][c] == '#') {
						q.add(new state(r, c, d, 0));
					} else {
						q.add(new state(r+1, c, d+1, 2));
					}
				}
				if (s == 3) {
					if (c == 0 || room[r][c-1] == '#') {
						q.add(new state(r, c, d, 0));
					} else {
						q.add(new state(r, c-1, d+1, 3));
					}
				}
				if (s == 4) {
					if (c == m-1 || room[r][c+1] == '#') {
						q.add(new state(r, c, d, 0));
					} else {
						q.add(new state(r, c+1, d+1, 4));
					}
				}
			}
		}
		if (!pf){
		    System.out.println(-1);
		}
	}
}
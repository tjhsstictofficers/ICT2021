import java.util.*;
import java.io.*;

public class Fans {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
		int[][] prefix = new int[4][N+1];
		for(int i = 1; i <= N; i++) {
			int curr = Integer.parseInt(br.readLine());
			for(int j = 1; j <= 3; j++) {
				prefix[j][i] = prefix[j][i-1];
			}
			prefix[curr][i]++;
		}
		
		for(int i = 0; i < Q; i++) {
		    st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println((prefix[1][b] - prefix[1][a-1]) + " " + (prefix[2][b] - prefix[2][a-1]) + " " + (prefix[3][b] - prefix[3][a-1]));
		}
	}
}
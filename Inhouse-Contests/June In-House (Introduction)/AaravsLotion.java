import java.util.*;
import java.io.*;

public class Lotion {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		br.close();
		
		double radius = Math.max(nums[0] - 0, L - nums[nums.length - 1]);
		for(int i = 0; i < N - 1; i++) {
			radius = Math.max(radius, ((double)nums[i + 1] - (double)nums[i])/2);
		}
		System.out.println((int)Math.ceil(radius));
	}
}
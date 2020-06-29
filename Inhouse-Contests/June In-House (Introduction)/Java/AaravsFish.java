import java.util.*;
import java.io.*;

public class AaravsFish {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int fish = Integer.parseInt(st.nextToken());      
      int[] colorCount = new int[Integer.parseInt(st.nextToken())];
      int c = fish/colorCount.length;
      int numcp = fish - c * colorCount.length;
      Arrays.fill(colorCount, 0); 
      for(int i = 0; i < fish; i++) {
         int x = Integer.parseInt(br.readLine()) - 1;
			colorCount[x]++;
		}
      int count = 0;
      for(int i = 0; i < colorCount.length; i++){
         if(colorCount[i] >= c + 1){
            if(numcp > 0){
               count += colorCount[i] - c - 1;
               numcp--;
            }
            else
               count += colorCount[i] - c;
         }
      }	
		System.out.println(count);
	}
}
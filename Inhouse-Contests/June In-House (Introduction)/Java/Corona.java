import java.util.*;
import java.io.*;

public class Corona {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int W = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      PriorityQueue<Parent> pq = new PriorityQueue<Parent>();
      for(int i = 0; i < n; i++) {
         st = new StringTokenizer(br.readLine());
         int w = Integer.parseInt(st.nextToken());
         int p = Integer.parseInt(st.nextToken());
         pq.add(new Parent(i, w, p));
		}
      int count = 0;
      int tripWeight = 0;
      
      while (!pq.isEmpty()) {
            Parent curr = pq.remove();
            tripWeight += curr.getWeight();
            if(tripWeight > W){
               count++;
               tripWeight = curr.getWeight();
            }  
      }
      if(tripWeight != 0)
         count++;
      System.out.println(count);
	}
}
class Parent implements Comparable<Parent>
{
   private int arrival;
   private int weight;
   private int priority;
   public Parent(int a, int w, int p)
   {
      arrival = a;
      weight = w;
      priority = p;
   }

   public int compareTo(Parent obj)
   {
      if(priority == obj.priority)
         return arrival - obj.arrival;
      return priority - obj.priority;
   }
   public int getWeight()
   {
      return weight;
   }
   public int getArrival()
   {
      return arrival;
   }
   public String toString(){
      return "" + arrival + " " + weight + " " + priority;
   } 
}
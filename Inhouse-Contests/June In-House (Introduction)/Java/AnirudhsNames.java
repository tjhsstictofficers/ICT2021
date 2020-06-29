import java.io.*;
import java.util.*;
 
 
public class Main
{
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int cnt = 0;
        for(int i = 0; i < N; i++)
        {
            if(input.readLine().equals("aarav"))
            {
                cnt++;
            }
        }
        if(cnt == 0)
        {
            System.out.println("SAD ANI");
        }
        else
        {
            System.out.println(cnt);
        }
    }
    
}
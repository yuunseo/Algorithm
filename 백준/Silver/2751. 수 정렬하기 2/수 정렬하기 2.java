import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(reader.readLine());
        int[] numList = new int[N];
        for(int i=0; i<N; i++){
            numList[i] = Integer.parseInt(reader.readLine());
        }
        
        Arrays.sort(numList);
        
        for(int i=0; i<N; i++){
            System.out.println(numList[i]);
        }
    }
}
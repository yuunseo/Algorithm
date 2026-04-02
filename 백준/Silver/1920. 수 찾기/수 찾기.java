/*

*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Set<Integer> A = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
           A.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        for(String s: br.readLine().split(" ")){
            int num = Integer.parseInt(s);
            
            if(A.contains(num)){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        
        System.out.println(sb.toString().trim());
    }
}
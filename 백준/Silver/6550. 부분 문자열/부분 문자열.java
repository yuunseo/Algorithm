/*

*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String line;
        while((line =br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line);
            String s = st.nextToken();
            String t = st.nextToken();
            
            int idx = 0;
            for(int i=0; i < t.length() && idx < s.length(); i++){
                char target = t.charAt(i);
                if(target == s.charAt(idx)){
                    idx++;
                }
            }
            
            if(idx == s.length()) sb.append("Yes\n");
            else sb.append("No\n");
            
        }
        
        System.out.println(sb);
        
        
        
    }
}
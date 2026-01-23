import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String K = br.readLine();
        
        // 숫자 제거
        String filtered = S.replaceAll("[0-9]", "");    
        
        if(filtered.contains(K)){
                System.out.println(1);
        }else{
            System.out.println(0);
        }
        
    }
}
/*
회문 0, 유사회문 1, 일반문 구분하기 2
*/

import java.util.*;
import java.io.*;

class Main{
    
    static boolean isPalindrome(String str, int s, int e){
        while(s < e){
            if(str.charAt(s) != str.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String cur = br.readLine();
            int s = 0;
            int e = cur.length()-1;
            int result = 0;
            
            // 팰린드롬 찾기
            int cnt = 0;
            while(s<e){
                if(cur.charAt(s) == cur.charAt(e)){
                    s++;
                    e--;
                }else{
                    if(isPalindrome(cur,s+1,e) || isPalindrome(cur,s,e-1)){
                        result = 1;
                    }else{
                        result = 2;
                    }
                    break;
                }
            }
            sb.append(result).append("\n");
            
        }
        
        System.out.println(sb);
    }
}
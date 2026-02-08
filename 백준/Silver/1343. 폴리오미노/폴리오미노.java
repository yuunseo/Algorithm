/*
1. X칸에만 덮을 수 있기에 .은 패스
2. X가 연속 2개나오면 BB, 4개 나오면 AAAA, 6개 나오면 AAAABB, 8개 나오면 AAAAAAAA
3. 사전 순으로 앞서는 답이기 때문에 A우선
4. X가 홀수개인 경우에는 실패 -1
5. 한 글자씩 읽으면서, X가 나오면 연속된 개수 구하기 -> 홀수면 실패 짝수면 2번 처리

*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        int len = str.length();
        
        for(int i=0; i<len; i++){
            char cur = str.charAt(i);
            
            if(cur == '.'){
                sb.append(".");
                continue;
            }
            if(cur == 'X'){
                int count = 1;
                while(i+1<len && str.charAt(i+1) == 'X'){
                    count++;
                    i++;
                }
                
                // 홀수개라면 실패
                if(count%2 != 0){
                    System.out.println(-1);
                    return;
                }else{
                    // 짝수라면 A 들어갈 수 있나 보고, 나머지는 B
                    if(count%4 == 0){
                        sb.append("AAAA".repeat(count/4));
                    }else if(count%4 !=0){
                        int a = count / 4;
                        int b =(count%4) /2;
                        sb.append("AAAA".repeat(a)).append("BB".repeat(b));
                    }
                }
            }
        }

        System.out.print(sb.toString());
    }
}

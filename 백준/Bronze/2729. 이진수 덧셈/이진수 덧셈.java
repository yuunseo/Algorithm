/*
1. 우측정렬
2. 짧은 문자열은 0으로 왼쪽 채우기
3. idx 맨 뒤부터 덧셈
4. 결과에서 맨 앞에 0부터 시작하지 못하도록 1이 나올 때까지 삭제

*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sout = new StringBuilder();
        
        // 입력
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            
            // 길이 맞추기
            int diff = a.length() - b.length();
            if(diff > 0){
                b = "0".repeat(diff) + b;
            }else if(diff < 0){
                a = "0".repeat(-diff) + a;
            }
            
            // 두 문자열 덧셈 시작
            StringBuilder result = new StringBuilder();
            int next = 0;
            for(int idx=a.length()-1; idx>=0; idx--){
                int aa = a.charAt(idx) - '0';
                int bb = b.charAt(idx) - '0';
                
                if(aa+bb+next == 0){
                    result.append(0);
                    next = 0;
                }else if(aa+bb+next == 1){
                    result.append(1);
                    next = 0;
                }else if(aa+bb+next == 2){
                    result.append(0);
                    next = 1;
                }else if(aa+bb+next == 3){
                    result.append(1);
                    next = 1;
                }
            }
            
            result.append(next);
            
            String answer = result.reverse().toString();
            int idx = 0;
            while(idx<answer.length() && answer.charAt(idx) == '0'){
                idx++;
            }
            
            if( idx == answer.length()){
                sout.append("0\n");
            }else{
                sout.append(answer.substring(idx)).append("\n");
            }
        }
        
        // 결과 출력
        System.out.println(sout);
        
    }
}
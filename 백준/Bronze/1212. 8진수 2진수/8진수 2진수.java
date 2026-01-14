/*
8진수를 2진수로 변환하는 방법
- 한 자리 씩 분해 > 3비트로 변환 (2^3이므로)
- 각각 3비트 문자열을 더하기
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        
        // 0이면 바로 출력
        if(N.equals("0")){
            System.out.println(0);
            return;
        }
        
        // 각각 자릿수를 3비트로 변환하기
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N.length(); i++){
            char c = N.charAt(i);
            sb.append(toThreeBit(c));
        }
        
        // 반드시 1로 시작해야 하므로 길이가 1 이상일 경우, 맨 앞 0을 제외
        while(sb.length()>1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
      
        System.out.println(sb);
        
    }
     
    private static String toThreeBit(char c){
        String bin = Integer.toBinaryString(c-'0');
        
        // 3비트가 충족되지 않은 경우, 0으로 채우기
        while(bin.length()<3){
            bin = "0" + bin;
        }

        return bin;
    }
}
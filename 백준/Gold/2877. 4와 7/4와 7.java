import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(K != 0){
            if(K%2 == 0){ // K가 짝수라면 7 더하기
                sb.append("7");
                K = K/2 -1;
            }else{ // K가 홀수라면 4 더하기
                sb.append("4");
                K = K/2;
            }
        }
        
        System.out.println(sb.reverse().toString());
    }
}
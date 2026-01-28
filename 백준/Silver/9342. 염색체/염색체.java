/*
정규표현식 문자열을 활용하기
[A-F]* A+F+C+[A-F]*
분기 처리시, 매우 복잡하기 때문에 실패함!
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        String regex = "^[A-F]?A+F+C+[A-F]?$";
        
        for(int i=0; i<T; i++){
            String str = br.readLine().trim();
            
            if(str.matches(regex)){
                sb.append("Infected!\n");
            }else{
                sb.append("Good\n");
            }
            
        }
        
        System.out.println(sb);
    }
}
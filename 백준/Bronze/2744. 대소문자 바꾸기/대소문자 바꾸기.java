/*
대소문자 바꿔 출력하기
1. 한 글자씩 받아 변환하기
2. 
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        for(char c : str.toCharArray()){
            if(Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else sb.append(Character.toUpperCase(c));
        }
        
        System.out.println(sb.toString());
    }
}
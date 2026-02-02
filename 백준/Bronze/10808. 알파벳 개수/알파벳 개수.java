/*
알파벳 개수 세기
1. 하나의 단어에 알바펫 개수 세기
2. 하나의 문자씩 읽기
3. int[] chars 에다가 b-'0'해서 맞는 숫자로 넣기
 -> char - '0'은, 해당 문자의 실제 정수 값이 나옴
 -> 알파벳의 순서 값을 원한다면 -'a'+1하면 됨
4. 뭐가 뭐인지보다는 개수가 중요하니까
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        // 결과배열 초기화
        int[] chars = new int[27];
        for(int i=0; i<27; i++){
            chars[i] = 0;
        }
        
        // 소문자의 개수 카운트
        for(char c : str.toCharArray()){
            int idx = c-'a'+1;
            chars[idx] ++;
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<27; i++){
            sb.append(chars[i]).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}
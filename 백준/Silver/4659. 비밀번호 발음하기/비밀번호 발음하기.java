/*
- a e i o u 최소 1개 이상
- 모음자음 연속 불가능
- ee/oo는 허용
*/

import java.util.*;
import java.io.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    
    static void check(String line){
        String aeiou = "aeiou";
        boolean check_aeiou = false;
        int voewlCnt =0 ;
        int consCnt =0 ;
        boolean result = true;
        char prev = 0;
        
        for(char c: line.toCharArray()){
            // 자음모음 확인하기
            if(aeiou.contains(String.valueOf(c))){
                check_aeiou = true;
                voewlCnt++;
                consCnt=0;
            }else{
                consCnt++;
                voewlCnt=0;
            }
            
            if(voewlCnt==3 || consCnt==3){
                result = false;
                break; // 3번 이상 연속, ee/oo 3개 연속도 여기서 걸러짐
            }
            
            // 연속 글자 확인하기
            if(prev == c){
                if( c != 'e' && c != 'o'){
                    result = false;
                    break;
                }
            }
            
            prev=c;
        }
        
        if(result && check_aeiou){
            sb.append("<").append(line).append("> is acceptable.\n");
            return;
        }else{
            sb.append("<").append(line).append("> is not acceptable.\n");
            return;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String line = br.readLine();
            if(line.equals("end")) break;
            check(line);
        }
        
        System.out.println(sb);
    }
}
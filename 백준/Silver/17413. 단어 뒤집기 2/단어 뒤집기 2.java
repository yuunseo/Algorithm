/*
<와> 태그 내부는 그대로
<> 제외 문자열을 모두 reverse
1. <만나면 > 나올 때까지 sb에 append
2. >나오면 다음 덩어리로 sb에 append

내가 빠트린 부분
1. 공백 기준으로 문자열 구분한 후에 뒤집어야 함
2. <>가 아예 존재하지 않을 수 있으므로 조건문에 <>을 기준으로 삼으면 안됨
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String before = scanner.nextLine();
        StringBuilder answer = new StringBuilder();
        
        int idx = 0;
        while(idx < before.length()){
            
            // <> 내부 작업
            if(before.charAt(idx) == '<'){
                while(idx < before.length()){
                    answer.append(before.charAt(idx));
                    if(before.charAt(idx) == '>'){
                        idx ++;
                        break;
                    }
                    idx++;
                }
            } // <> 외 문자열 작업
            else{
                StringBuilder rev = new StringBuilder();
                while(idx < before.length() && before.charAt(idx) != '<' && before.charAt(idx) != ' '){
                    rev.append(before.charAt(idx));
                    idx++;
                }
                    
                answer.append(rev.reverse());
                    
                // 공백
                if (idx < before.length() && before.charAt(idx) == ' ') {
                    answer.append(' ');
                    idx++;
                }
            }
        } 
        System.out.println(answer);
    }
        
        }
/*
암호화 프로그램을 작성하라
- 암호화키의 알파벳 순서를 평문 문자에서 뺀 순서에 해당하는 문자 출력
- 공백은 그대로
1. 암호화키 돌면서 숫자로 바꾸고, 평문에서 순서 빼기
2. 암호화키가 짧다면 해당 길이 초과 시, 다시 앞 인덱스로 이동
- 순서로 바꾸는 방법 char - 'a' +1
- 순서만큼 알파벳 이동하는 방법 char - diff <0 일 경우 + 26 을 char로 변환

*/

import java.util.*; 
import java.io.*; 
class Main{ 
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        String key = br.readLine();
        
        // 암호화키 암호화 처리
        for(int i=0; i<str.length(); i++){
            // 공백 무시
            if(str.charAt(i) == ' '){
                sb.append(" ");
                continue;
            }
            
            int key_index = i % key.length();
            int key_value = key.charAt(key_index) - 'a' +1;
            int str_value = str.charAt(i) - 'a';
            
            int diff = str_value - key_value;
            if(diff<0) diff+=26;
            
            sb.append((char)(diff+'a'));
        }
        
        // 결과 출력
        System.out.println(sb.toString());
    }
}

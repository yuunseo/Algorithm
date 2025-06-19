/*
<아이디어>
1. s에서 한 글자씩 불러온다
2. 불러온 글자에서 n 만큼 더한다
3. 더해진 정수를 다시 string으로 변환한다.
4. z 다음은 다시 a로 돌아오도록, %26 처리 필수!?
*/
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        // for 문으로 한 글자씩 불러오기
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c==' '){ // 공백은 무의미
                answer += ' ';
                continue;
            }
            
            int c2i = c + n;
            if(((int)c <=90 && c2i > 90) || c2i > 122) // 알파벳 범위 초과 시
                c2i -= 26;   
            answer += (char)c2i;
        }
        
        return answer;
    }
}
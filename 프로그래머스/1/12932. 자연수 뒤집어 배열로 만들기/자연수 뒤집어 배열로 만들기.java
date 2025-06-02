// 문자열 변수(String)를 정수(int)로 바꾸기 위해서는 '0'를 뺴준다
// ex) "9" - '0'라면, 9를 정수로 바꿔준다!
// 원리는, 문자열 변수의 고유한 ASCII 값이 존재하므로 '0'의 고유 값인 48을 빼 줌으로써 정수로 형 변환이 됨!!

class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n);
        int len = s.length();
        
        int[] answer = new int[len];
        for(int i=0; i<len; i++){
            answer[i] = s.charAt(len-i-1) - '0';
        }
        return answer;
    }
}
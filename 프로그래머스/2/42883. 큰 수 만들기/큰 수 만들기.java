class Solution {
    public String solution(String number, int k) {
        int n = number.length(); // 원본 길이
        char[] result = new char[n - k]; // 결과 저장 배열
        int top = 0; // 스택 top

        for (int i = 0; i < n; i++) { // 하나씩 돌면서 확인
            char cur = number.charAt(i);
            
            while (top > 0 && result[top - 1] < cur && k > 0) { // 스택 top처럼 구현
                top--;
                k--;
            }
            if (top < result.length) { // 큰 수일 경우, 스택에 추가
                result[top++] = cur; 
            } else {
                k--; // 자리가 없으면 버림
            }
        }
        return new String(result);
    }
}
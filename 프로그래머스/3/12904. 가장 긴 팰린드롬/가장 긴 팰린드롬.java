class Solution {
    public int solution(String s) {
        int answer = 1; // 최소 1
        
        for(int i = 0; i < s.length(); i++) {
            
            // 1. 홀수 길이
            answer = Math.max(answer, expand(s, i-1, i+1));
            
            // 2. 짝수 길이
            answer = Math.max(answer, expand(s, i, i+1));
        }
        
        return answer;
    }
    
    public int expand(String s, int left, int right) {
        int len = 0;
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            len = right - left + 1;
            left--;
            right++;
        }
        
        return len;
    }
}
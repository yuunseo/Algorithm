import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        int count = 1; // 전체 순서
        int num = 0;
        
        while (t > 0) {
            String numString = Integer.toString(num++, n).toUpperCase();
            
            for (int i = 0; i < numString.length(); i++) {
                if ((count - p) % m == 0) {
                    answer.append(numString.charAt(i));
                    t--;
                    if (t == 0) break;
                }
                count++;
            }
        }
        
        return answer.toString();
    }
}
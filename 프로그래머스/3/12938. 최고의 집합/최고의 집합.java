import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
       // 자료구조 초기화
        int quo = 0;
        int rem = 0;
        
        // 집합 구하기
        quo = s/n;
        rem = s%n;
        
        // 불가능하면, -1 반환
        if(quo <= 0 && rem > 0) return new int[] {-1};
        
        // 나머지만큼 값 더하기
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = quo;
        }
        for(int i=0; i<rem; i++){
            result[n-1-i] += 1;
        }
        
        return result;
    }
}
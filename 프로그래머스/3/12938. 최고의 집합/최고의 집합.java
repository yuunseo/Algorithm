import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        // 불가능한 경우, [-1] 반환
        if(s<n){
            return new int[] {-1};
        }
                
        // 균등하게 나누는 수 구하기
        int a = s/n;
        int b = s%n;
        
        int[] arr = new int[n];
        
        // 기본 배열 모두 a로 채우기
        for(int i=0; i<n; i++){
            arr[i] = a;
        }
        
        // 나머지 b 만큼 넣기
        for(int i=0; i<b; i++){
            arr[n-1-i]++;
        }
        
        return arr;
    }
}
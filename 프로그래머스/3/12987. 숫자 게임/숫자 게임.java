import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
     
        Arrays.sort(A);
        Arrays.sort(B);
        int result = 0;
        
        // 두 배열끼리 비교 - 투 포인터
        int i=0;
        int j=0;
        while(i<A.length && j<B.length){
            // 두 원소를 비교하고,
            // A보다 같거나 작은 B라면 무의미하므로, 무시
            if(A[i] >= B[j]){
                j++;
                continue;
            }
            // A보다 큰 B라면 유의미하므로, 카운트
            else{
                result ++;
                i++; j++;
            }
        }
        
        return result;
    }
}
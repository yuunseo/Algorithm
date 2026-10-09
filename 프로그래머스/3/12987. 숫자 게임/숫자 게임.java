import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
     
        // 자료구조 초기화
        // 두 배열을 서로 정렬한 이유는, 다음 숫자와 비교를 위해서
        // 현재 선택할 때는 가능한 숫자 중 최소를 선택해야 하기 때문에
        // 즉, 정렬함으로써 최소 숫자를 비교 대상으로 삼기 위해.
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
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0; 
        int b = 0;
        while(a<A.length && b<B.length){
            if(A[a] < B[b]){
                b++; a++;
                answer++;
            }else{
                b++;
            }
        }
        
        return answer;
    }
}
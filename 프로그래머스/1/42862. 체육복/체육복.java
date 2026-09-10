/*
[아이디어]
1. 1~n까지 1로 초기화해서 배열 만들기 = initialization -O(N)
2. lost 배열 돌면서 initialization에서 하나씩 제거하기 - O(R)
3. reserve 배열 돌면서 본인, 앞, 뒤 사람 개수 확인하기 -O(1) -----> reserve 정렬을 위해 O(RlogR)
4. 만약 안가져왔으면(0이면) 그 사람+1, 본인이 안가져왔으면 +1 - O(1)
5. initialization을 다시 첨부터 돌면서 1이상인 사람 개수 count - O(N)
*/
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] initialization = new int[n+1]; //공간복잡도 N+1
        Arrays.fill(initialization, 1);
        
        for(int i: lost){
            initialization[i] -= 1;
        }
        
        for(int i: reserve){
            initialization[i] += 1;
        }
        
        
        for(int i=1; i<=n; i++){
            if(initialization[i] <2) continue;
            
            // 앞 사람 확인
            if(i-1 > 0 && initialization[i-1] == 0){
                initialization[i-1] += 1;
                initialization[i] -= 1;
            }
            
            // 뒷 사람 확인
            else if(i+1 <= n && initialization[i+1] == 0){
                initialization[i+1] += 1;
                initialization[i] -= 1;
            }
        }
        
        int result = 0;
        for(int i=1; i<=n; i++){
            if(initialization[i] >= 1) result+=1;
        }
        
        return result;
     
    }
}
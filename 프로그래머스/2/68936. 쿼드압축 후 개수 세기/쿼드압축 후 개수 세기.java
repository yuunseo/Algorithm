import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        
        // 압축 결과 변수
        int zero = 0;
        int one = 0;
        
        // arr 길이 변수 (이후, 쪼개질 때마다 활용을 위해서)
        int n = arr.length; 
        
        // Queue로 검토해야 하는 영역 저장
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,n}); // 초기 시작점 삽입 (i,j,n)
        
        while(!q.isEmpty()){
            int[] S = q.poll();
            
            // 해당 영역에서 모두 같은 숫자인지 검토
            boolean div = false;
            int prev = arr[S[0]][S[1]]; // 다른 값을 가진 원소가 있는지 파악을 위해
            for(int i=S[0]; i<S[0]+S[2]; i++){
                for(int j=S[1]; j<S[1]+S[2]; j++){
                    if(prev != arr[i][j]){ // 다른 원소가 존재하면, 쪼개기
                        div = true;
                        q.add(new int[] {S[0], S[1], S[2]/2});
                        q.add(new int[] {S[0], S[1]+S[2]/2, S[2]/2});
                        q.add(new int[] {S[0]+S[2]/2, S[1], S[2]/2});
                        q.add(new int[] {S[0]+S[2]/2, S[1]+S[2]/2, S[2]/2});
                        break;
                    }
                }
                if(div) break;
            }
            
            // 압축된 개수를 전체 개수에서 제거
            if(!div && S[2] != 1){
                if(prev == 1){
                    one += (-(S[2]*S[2])+1);
                }else{
                    zero += (-(S[2]*S[2])+1);
                }
            }
            
        }
        
        // 총 개수 구하기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1) one++;
                else zero++;
            }
        }
        
        return new int[] {zero, one};
    }
}
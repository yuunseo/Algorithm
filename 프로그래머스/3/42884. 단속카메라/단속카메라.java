import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 자료구조 초기화
        int camera = 1;
        Arrays.sort(routes, (a,b)->{
            return a[0]-b[0];
        });
        int end = routes[0][1];
        
        // 겹치는 구간 탐색
        for(int i=1; i<routes.length; i++){
            if(end < routes[i][0]){
                camera++;
                end = routes[i][1];
            }else if(routes[i][1] <=end){
                end = routes[i][1];
            }
            
        }
        
        // 결과
        return camera;
        
    }
}
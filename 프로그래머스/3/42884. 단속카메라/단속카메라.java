import java.util.*;

class Solution {
    public int solution(int[][] routes) {
     
        // 자료구조 초기화
        int camera = 0;
        int start = 0;
        int end = 0;
        Arrays.sort(routes, (a, b) ->
            Integer.compare(a[0], b[0])
        );
        
        // route에 따라 탐색
        start = routes[0][0];
        end = routes[0][1];
        camera ++;
        
        for(int i=1; i<routes.length; i++){
            int[] current = routes[i];
            
            if (current[0] > end) {
                camera++;
                end = current[1];
            } else {
                end = Math.min(end, current[1]);
            }
        }
        
        return camera;
        
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 1. 끝나는 지점 기준 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        // 2. 카메라 위치 (초기값: 매우 작은 값)
        int camera = Integer.MIN_VALUE;
        
        // 3. 순회하면서 카메라 설치
        for (int[] route : routes) {
            // 현재 카메라로 못 찍는 경우
            if (camera < route[0]) {
                answer++;
                camera = route[1]; // 해당 차량의 끝 지점에 설치
            }
        }
        
        return answer;
    }
}
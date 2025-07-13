class Solution {
    public int trap(int[] height) {

        // 1. 포인터 설정하기 (좌,우 양 끝)
        int left = 0;
        int right = height.length - 1;

        // 2. 최대 높이 설정하기
        int leftMax = 0;
        int rightMax = 0;

        // 3. 결과 값을 담을 변수
        int result = 0;

        while (left < right) { // 중간에서 만나면 종료

            // 오른 쪽 벽이 더 높다면, 왼쪽 벽의 높이 판별
            if (height[left] < height[right]) { 

                // 현재 왼쪽 벽의 높이가 최대 높이보다 높다면, 갱신
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                    // 최대 높이보다 낮다면, 그 차이만큼의 물 쌓기
                } else {
                    result += leftMax - height[left];
                }
                left++; // 왼쪽 포인터 이동
            
            // 왼쪽 벽이 더 높다면, 오른쪽 벽의 높이 판별
            } else {
                // 현재 벽의 높이가 최대 높이보다 높다면, 갱신
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                    // 최대 높이보다 낮으면, 그 차이만큼의 물 쌓기 
                } else {
                    result += rightMax - height[right];
                }
                right--; // 오른 포인터 이동
            }
        }
        return result;
    }
}

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 결과 행렬의 크기는 [arr1의 행 크기][arr2의 열 크기]
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        // i: arr1의 행을 순회
        for (int i = 0; i < arr1.length; i++) {
            // j: arr2의 열을 순회
            for (int j = 0; j < arr2[0].length; j++) {
                int temp_sum = 0;
                // k: arr1의 열(또는 arr2의 행)을 순회하며 곱하고 누적
                for (int k = 0; k < arr1[0].length; k++) {
                    temp_sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = temp_sum;
            }
        }
        
        return answer;
    }
}
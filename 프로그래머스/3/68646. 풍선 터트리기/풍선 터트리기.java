class Solution {
    public int solution(int[] a) {
        // 풍선이 1개나 2개면 무조건 모두 살아남을 수 있음
        if (a.length <= 2) {
            return a.length;
        }

        int n = a.length;
        
        // leftMin[i]: index 0부터 i까지 중 가장 작은 값
        int[] leftMin = new int[n];
        // rightMin[i]: index n-1부터 i까지 중 가장 작은 값
        int[] rightMin = new int[n];

        // 왼쪽에서부터의 최솟값을 기록
        int minL = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] < minL) {
                minL = a[i];
            }
            leftMin[i] = minL;
        }

        // 오른쪽에서부터의 최솟값을 기록
        int minR = a[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] < minR) {
                minR = a[i];
            }
            rightMin[i] = minR;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            /*
             * 핵심 로직:
             * 풍선 a[i]가 살아남으려면 다음 중 하나라도 만족해야 합니다.
             * 1. 내 왼쪽 풍선들 중 최솟값보다 내가 더 작다. (a[i] <= leftMin[i])
             * 2. 내 오른쪽 풍선들 중 최솟값보다 내가 더 작다. (a[i] <= rightMin[i])
             * * 만약 양쪽 최솟값이 모두 나보다 작다면, 
             * 작은 풍선을 터트리는 '1회의 기회'로는 양쪽의 작은 풍선을 다 처리할 수 없으므로 탈락입니다.
             */
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }

        return answer;
    }
}
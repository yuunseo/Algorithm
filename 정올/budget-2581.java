/*
문제 링크: https://jungol.co.kr/problem/2581
풀이: 
1. 이분탐색
2. left를 minNum으로 설정했었으나, minNum보다 더 적은 예산을 나눠줄 수 있으므로 0으로 설정하는 것으로 수정
*/

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] NList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxNum = 0;

        for (int i = 0; i < N; i++) {
            NList[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, NList[i]);
        }

        int M = Integer.parseInt(br.readLine());

        int left = 0;
        int right = maxNum;

        while (left <= right) {
            int mid = (left + right) / 2;

            int total = 0;

            for (int i = 0; i < N; i++) {
                total += Math.min(NList[i], mid);
            }

            if (total > M) {
                // mid가 너무 큼
                right = mid - 1;
            } else {
                // mid로 지급 가능
                // 더 큰 상한액도 가능한지 확인
                left = mid + 1;
            }
        }

        System.out.println(right);
    }
}

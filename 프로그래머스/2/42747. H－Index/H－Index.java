/*
논문 n편 중, h번 이상 인용된 논문이 h편 이상 + 나머지 논문이 h번 이하 인용되었다면 h의 최댓값
- h=n부터 점점 줄여가며 조건에 맞는 h를 찾아보기
*/
import java.util.*;
class Solution {
    public int solution(int[] citations) {

        Arrays.sort(citations);

        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;

            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}
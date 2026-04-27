class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            // 짝수: 바로 다음 수
            if (x % 2 == 0) {
                answer[i] = x + 1;
            } 
            // 홀수: 한 자리 올린 후, 01 바꾸기
            else {
                answer[i] = x + 1 + ((x ^ (x + 1)) >> 2);
            }
        }

        return answer;
    }
}
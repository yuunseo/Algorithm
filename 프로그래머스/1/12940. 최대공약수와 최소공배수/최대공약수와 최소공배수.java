class Solution {

    // 최대공약수 (GCD) 계산 함수
    public int gcd(int a, int b) {
        // 유클리드 알고리즘을 이용하여 최대공약수 계산
        while (b != 0) {
            a = a % b;
            // a와 b를 교환하는 방식
            int temp = a;
            a = b;
            b = temp;
        }
        return a;  // a가 최대공약수
    }

    // 최소공배수 (LCM) 계산 함수
    public int lcm(int a, int b) {
        // 최소공배수는 두 수의 곱을 GCD로 나눈 값
        return (a / gcd(a, b)) * b;  // (a * b) / GCD(a, b) 대신 (a / GCD(a, b)) * b로 변경
    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        // 최대공약수와 최소공배수 계산
        answer[0] = gcd(n, m);  // 최대공약수
        answer[1] = lcm(n, m);  // 최소공배수
        
        return answer;
    }
}

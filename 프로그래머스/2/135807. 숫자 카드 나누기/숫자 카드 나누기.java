class Solution {
    public int solution(int[] arrayA, int[] arrayB) {

        // A 최대 공약수 구하기
        int gcdA = arrayA[0];
        for(int i = 1; i < arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
        }

        // B 최대 공약수 구하기
        int gcdB = arrayB[0];
        for(int i = 1; i < arrayB.length; i++){
            gcdB = gcd(gcdB, arrayB[i]);
        }

        int answer = 0; // 못 찾으면 0 반환

        // gcdA가 B를 나누는지 검사
        if(!hasDivisor(gcdA, arrayB)){ 
            answer = Math.max(answer, gcdA);
        }

        // gcdB가 A를 나누는지 검사
        if(!hasDivisor(gcdB, arrayA)){
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    /* check: 상대편이 나눠지는지 확인하는 함수 */
    static boolean hasDivisor(int divisor, int[] target){
        for(int num : target){
            if(num % divisor == 0){
                return true;
            }
        }
        return false; // 상대편 약수가 배열의 어떤 원소도 나누지 않으면 통과
    }

    /* gcd: 최대공약수 구하기 */
    static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
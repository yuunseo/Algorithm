class Solution {
    public int solution(int n, int k) {
        int count = 0;
        
        // 1. k 진수 변환
        String str = Integer.toString(n,k);
        
        // 2. 0 단위로 분리
        String[] str_list = str.split("0");
        
        // 3. 각 원소들의 소수 판별
        for(String s : str_list){
            if (s.isEmpty()) continue;
            
            long num = Long.parseLong(s);
            if(isPrime(num)){
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
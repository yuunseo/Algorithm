import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        ArrayList<Integer> collatzResult = new ArrayList<>(); 
        collatzResult.add(k);
        while(k > 1){
            k = collatz(k);
            collatzResult.add(k);
        }
        
        int collatzCount = collatzResult.size() - 1;
        ArrayList<Double> integralResult = new ArrayList<>(); 
        for(int[] range: ranges){
            int a = range[0];
            int b = range[1];
            
             b = collatzCount + b;
            
            if(a > b){ 
                integralResult.add(-1.0);
                continue;
            }
            
            // todo: a~b 범위 안에서 내부 면적 구하기
            double sum = 0.0;
            for(int i = a; i < b; i++) {
                // 너비가 1인 사다리꼴 넓이 = (윗변 + 밑변) / 2.0
                sum += (collatzResult.get(i) + collatzResult.get(i + 1)) / 2.0;
            }
            
            //System.out.println(sum);
            integralResult.add(sum);
            
            
        }
        
        // 결과 출력 배열
        double[] answer = new double[integralResult.size()];
        for(int i=0; i<integralResult.size(); i++){
            answer[i] =integralResult.get(i);
        }
        
        return answer;
    }
    
    private int collatz(int k){
        if(k % 2 == 0){ // 짝수라면, 2로 나누기
            k /= 2;
        }else{ // 홀수라면, *3+1 하기
            k = k*3 + 1;
        }
        
        return k;
    }
}
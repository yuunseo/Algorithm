class Solution {
    public int solution(int num) {
        int cnt = 0;
        int answer = -1;
        long number = num;
        if (num==1) answer = 0;
        
        while(cnt<500){
            
            System.out.println(number);
            
            if(number==1) {
                answer = cnt; 
                break;
            }
            
            if(number%2==0){
                number /= 2;
            }else{
                number = number*3+1;
            }
            
            
            cnt++;
        }
        
        return answer;
    }
}
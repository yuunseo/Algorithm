import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        String[] nums = new String[numbers.length];
        for(int i=0; i<nums.length; i++){
            nums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(nums, (a,b) -> (b+a).compareTo(a+b));
        
        if(nums[0].equals("0")) return "0";
        
        for(String str: nums){
            answer.append(str);
        }
            
            
        
        return answer.toString();
    }
}
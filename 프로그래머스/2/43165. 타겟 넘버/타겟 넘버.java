import java.util.*;

class Solution {
    static int total = 0;
    static int len;
    static int[] temp;
    
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        temp = numbers;
        recur(0, numbers[0], target);
        recur(0, -numbers[0], target);
        
        return total;
    }
    
    private void recur(int idx, int cur, int target){
        if(idx == len-1 && cur == target){
            total += 1;
            return;
        }
        
        if(idx+1 >= len) return;
        
        recur(idx+1, cur+temp[idx+1], target);
        recur(idx+1, cur-temp[idx+1], target);
        
    }
}
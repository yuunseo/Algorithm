import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        // arr 정렬하기
        Arrays.sort(arr);
        
        // divisor로 나누기
        ArrayList <Integer> answer = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0)
                answer.add(arr[i]);
        }
        
        if (answer.size()==0) answer.add(-1); 
        
        // int[]로 변환하기
        int[] intarray = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            intarray[i] = answer.get(i);
        }
        
        return intarray;
    }
}
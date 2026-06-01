import java.util.*;
class Solution {
    public String solution(String s) {
        
        String[] sList = s.split(" ");
        int[] numSList = new int[sList.length];
        for(int i=0; i<sList.length; i++){
            numSList[i] = Integer.parseInt(sList[i]);
        }
        Arrays.sort(numSList);
        
        return numSList[0]+" "+numSList[sList.length-1];
        
    }
        
}
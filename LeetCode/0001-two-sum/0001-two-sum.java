/*
<아이디어>
두 수의 덧셈으로 target이 나오는 지 계산해야 함
idx=0부터 n-2까지 -> j는 idx+1씩하기
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        int sum = 0 ; 
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;

        
    }
}

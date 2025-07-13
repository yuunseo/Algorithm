import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // 중복 처리를 위한 집합 사용
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // 현재 요소와 다음 요소를 서로 합한 값(-버전)이, 집합 안에 존재하면 sum==0 가능!
            int target = nums[i];
            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int complement = -(target + nums[j]);
                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], complement, nums[j]);
                    Collections.sort(triplet); 
                    result.add(triplet);
                }
                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}

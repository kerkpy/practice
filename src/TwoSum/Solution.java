package TwoSum;
// Time Complexity: O(n)
// Link: https://leetcode.com/problems/two-sum/


import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return new int[] {i, map.get(nums[i])};
            } else {
                map.put(target - nums[i], i);
            }
        }

        return nums;

    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ans = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int res = target - nums[i];
            if (ans.containsKey(res)) {
                return new int[]{ans.get(res), i};
            }
            ans.put(nums[i], i);
        }

        return new int[]{}; 
    }
}

// optimize manner 

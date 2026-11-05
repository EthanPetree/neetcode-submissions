class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            boolean result = set.add(nums[i]);
            if(!result) return nums[i];
        }

        return -1;
    }
}

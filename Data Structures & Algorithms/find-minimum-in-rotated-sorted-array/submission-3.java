class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            min = Math.min(min, nums[m]);
            if (nums[l] <= nums[m]) {
                min = Math.min(min, nums[l]);
                l = m + 1;
            } else if (nums[m] >= nums[r]) {
                min = Math.min(min, nums[r]);
                r = m - 1;
            } else {
                l++;
            }
        }

        return min;
    }
}

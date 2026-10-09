class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])) return new int[]{map.get(nums[i]), i};
            
            int compliment = target - nums[i];

            // needed number and index
                map.put(compliment, i);
                continue;
        }

        return new int[1];
    }
}

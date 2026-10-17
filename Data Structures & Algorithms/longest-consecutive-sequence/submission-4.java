class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int maxLength = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        List<Integer> sequenceLengths = new ArrayList<>();
        for (Integer num : set){
            if (set.contains(num + 1) && !(set.contains(num - 1))){
                int tempNum = num;
                int counter = 1;
                while(set.contains(tempNum + 1)){
                    tempNum++;
                    counter++;
                }
                if (counter > maxLength) maxLength = counter;
            }
        }

        return maxLength;
    }
}

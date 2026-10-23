class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++){
            maxHeap.add(nums[i]);
        }
        list.add(maxHeap.peek());
        int left = 0;
        for(int right = k; right < nums.length; right++){
            maxHeap.add(nums[right]);
            maxHeap.remove(nums[left]);
            left++;
            list.add(maxHeap.peek());
        }

        int[] result = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }
}

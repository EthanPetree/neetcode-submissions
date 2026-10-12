class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Comparator idea provided by gemini
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair1[1], pair2[1]));

        for(int num : nums){
            Integer result = map.computeIfPresent(num, (key, oldValue) -> oldValue + 1);
            if(result == null) map.put(num, 1);
        }

        for(Integer key : map.keySet()){
            Integer[] keyValue = new Integer[]{key, map.get(key)};
            minHeap.add(keyValue);
        }

        for(int i = 0; i < map.size() - k; i++){
            minHeap.poll();
        }

        int[] result = new int[k];
        int counter = minHeap.size();
        for(int i = 0; i < counter; i++){
            result[i] = minHeap.poll()[0];
        }

        return result;
    }
}

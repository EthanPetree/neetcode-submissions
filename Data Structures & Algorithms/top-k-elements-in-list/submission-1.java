//second solution optimized with the suggestions of gemini
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Comparator idea provided by gemini
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(map.get(a), map.get(b)));

        for(int num : nums){
            Integer result = map.computeIfPresent(num, (key, oldValue) -> oldValue + 1);
            if(result == null) map.put(num, 1);
        }

        for(Integer key : map.keySet()){
            minHeap.add(key);
            if(minHeap.size() > k) minHeap.poll();
        }

        int[] result = new int[k];
        int counter = minHeap.size();
        for(int i = 0; i < counter; i++){
            result[i] = minHeap.poll();
        }

        return result;
    }
}

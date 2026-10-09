// import java.util.HashMap;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(Integer num : nums){
            if(map.containsKey(num)){
                // map.get(num)++;
                return true;
            } else {
                map.put(num, 1);
            }
        }

        return false;
    }
}
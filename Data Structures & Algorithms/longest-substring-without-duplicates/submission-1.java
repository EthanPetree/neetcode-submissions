class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        for(int right = 0; right < s.length(); right++){
            boolean result = set.add(s.charAt(right));

            if(!result){
                while(!set.add(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }  
            }

            if (maxLength < right - left  + 1) maxLength = right - left + 1;
        }

        return maxLength;
    }
}

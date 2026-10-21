class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];
        int maxReplacedString = 0;
        int left = 0;
        for(int right = 0;  right < s.length(); right++){
            frequency[s.charAt(right) - 'A']++;
            int mostFrequent = 0;
            for(int i = 0; i < frequency.length; i++){
                if(frequency[i] > mostFrequent) mostFrequent = frequency[i];
            }
            while((right - left + 1) - mostFrequent > k){
                frequency[s.charAt(left) - 'A']--;
                left++;
            }
            if(right - left + 1 > maxReplacedString) maxReplacedString = right - left + 1;
        }

        return maxReplacedString;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] targetFrequency = new int[26];
        for(int i = 0; i < s1.length(); i++){
            targetFrequency[s1.charAt(i) - 'a']++;
        }

        int[] frequency = new int[26];
        for(int i = 0; i < s1.length() - 1; i++){
            frequency[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        for(int right = s1.length() - 1; right < s2.length(); right++){
            frequency[s2.charAt(right) - 'a']++;
            if(Arrays.equals(frequency, targetFrequency)){
                return true;
            }
            frequency[s2.charAt(left) - 'a']--;
            left++;
        }

        return false;
    }
}

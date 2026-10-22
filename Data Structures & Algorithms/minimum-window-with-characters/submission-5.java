class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        String shortestSubstring = s;

        int[] target = new int[128];
        int uniqueCharacters = 0;
        for (int i = 0; i < t.length(); i++) {
            if(target[t.charAt(i)] == 0) uniqueCharacters++;
            target[t.charAt(i)]++;
        }

        int matched = 0;

        int[] frequencyTracker = new int[128];
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (target[s.charAt(right)] > 0) {
                frequencyTracker[s.charAt(right)]++;
                if (frequencyTracker[s.charAt(right)] == target[s.charAt(right)]) {
                    matched++;
                }
            }

            while (matched == uniqueCharacters) {
                if (shortestSubstring.length() > s.substring(left, right + 1).length())
                    shortestSubstring = s.substring(left, right + 1);
                if (target[s.charAt(left)] > 0) {
                    frequencyTracker[s.charAt(left)]--;
                    if (frequencyTracker[s.charAt(left)] < target[s.charAt(left)]) {
                        matched--;
                    }
                }
                left++;
            }
        }

        return (left == 0) ? "" : shortestSubstring;
    }
}

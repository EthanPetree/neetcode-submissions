class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> sAnagram = anagramToMap(s);
        HashMap<Character, Integer> tAnagram = anagramToMap(t);

            for(Character key : tAnagram.keySet()){
            // if (!sAnagram.containsKey(key)) return false;
            if (!tAnagram.get(key).equals(sAnagram.get(key)))
            return false;
        }

        return true;
    }


// O(n)
    public HashMap<Character, Integer> anagramToMap(String anagram){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < anagram.length(); i++){
            Integer result = map.computeIfPresent(anagram.charAt(i), (key, oldValue) -> oldValue + 1);
            if(result == null) map.put(anagram.charAt(i), 1);   
        }

        return map;
    }
}

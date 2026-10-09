class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<String, Integer> sAnagram = anagramToMap(s);
        HashMap<String, Integer> tAnagram = anagramToMap(t);

            for(String key : tAnagram.keySet()){
            // if (!sAnagram.containsKey(key)) return false;
            if (!tAnagram.get(key).equals(sAnagram.get(key)))
            return false;
        }

        return true;
    }


// O(n)
    public HashMap<String, Integer> anagramToMap(String anagram){
        HashMap<String, Integer> map = new HashMap<>();

        String[] letters = anagram.split("");

        for(String letter : letters){
            Integer result = map.computeIfPresent(letter, (key, oldValue) -> oldValue + 1);
            if(result == null) map.put(letter, 1);   
        }

        return map;
    }
}

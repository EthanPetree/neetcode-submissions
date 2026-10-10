class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList<String>> map = new HashMap<>();

            for(String s : strs){
                String sKey = this.mapAnagram(s);
                
                if(map.containsKey(sKey)){
                    map.get(sKey).add(s);
                } else {
                    ArrayList<String> temp = new ArrayList<String>();
                    temp.add(s);
                    map.put(sKey, temp);
                }
            }

            List<List<String>> result = new ArrayList<>();
            for(List<String> list : map.values()){
                result.add(list);
            }

            return result;
        }


        public String mapAnagram(String anagram){
        int[] charSet = new int[26];
        for(int i = 0; i < anagram.length(); i++){
            charSet[anagram.charAt(i) - 97]++;
        }

        return Arrays.toString(charSet);
    }
}

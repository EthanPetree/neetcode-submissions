class Solution {
    StringBuilder sb = new StringBuilder();

    public String encode(List<String> strs) {
        if(strs.size() < 1) return null;
        for(int i = 0; i < strs.size(); i++){
            sb.append(strs.get(i));
            if(i + 1 != strs.size()){
                sb.append("_SPLIT_HERE_");
            }
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str == null) return new ArrayList<>();
        String[] strs = str.split("_SPLIT_HERE_", -1);

        List<String> list = List.of(strs);

        return list;
    }
}

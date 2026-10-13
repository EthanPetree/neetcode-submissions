class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '#'){
                int substringLength = Integer.parseInt(sb.toString());
                sb.setLength(0);
                result.add(str.substring(i + 1, i + substringLength + 1));
                i += substringLength;
            } else {
                sb.append(str.charAt(i));
            }
        }

        return result;
    }
}

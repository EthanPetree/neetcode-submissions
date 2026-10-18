class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        
        String lower = s.toLowerCase();

        for(int i = 0; i < lower.length(); i++){
            if(Character.isLetterOrDigit(lower.charAt(i))){
                sb.append(lower.charAt(i));
            }
        }

        String trimmed = sb.toString();
        sb.setLength(0);

        for(int i = trimmed.length() - 1; i >= 0; i--){
            sb.append(trimmed.charAt(i));
        }

        String reverse = sb.toString();

        return (trimmed.equals(reverse));
    }
}

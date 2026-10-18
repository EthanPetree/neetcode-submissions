class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right){
            char leftChar = s.charAt(left);
            while(!Character.isLetterOrDigit(leftChar)){
                left++;
                if(left >= right) break;
                leftChar = s.charAt(left);
            }
            char rightChar = s.charAt(right);
            while(!Character.isLetterOrDigit(rightChar)){
                right--;
                if(right <= left) break;
                rightChar = s.charAt(right);
            }

            if(left < right && Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) return false;   
            left++;
            right--;
        }

        return true;
    }
}

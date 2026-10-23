class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Deque<Character> q = new ArrayDeque();
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case '(', '[', '{' -> {
                    q.addLast(s.charAt(i));
                }
                case ')' -> {
                    if(q.isEmpty() || q.pollLast() != '(') return false;
                }
                case ']' -> {
                    if(q.isEmpty() || q.pollLast() != '[') return false;
                }
                case '}' -> {
                    if(q.isEmpty() || q.pollLast() != '{') return false;
                }
            }
        }

        return q.isEmpty();
    }
}

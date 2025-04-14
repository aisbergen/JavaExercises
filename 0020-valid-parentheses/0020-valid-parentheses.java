class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);  // Get each character
            if (s.length() % 2 != 0) return false; // Optional: All valid parentheses have even length
            if(map.containsKey(c)){
                if (!stack.isEmpty() && stack.peek() == map.get(c)){
                stack.pop();
            } else{ return false;}
            }
            else{
                stack.push(c);
            }
            
        }
        return stack.isEmpty();

    } 
}
// LC 316
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> increStack = new Stack<>();
        HashSet<Character> seen = new HashSet<>();
        HashMap<Character, Integer> lastOccurrence = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) lastOccurrence.put(s.charAt(i), i);
        
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            
            if (!seen.contains(curChar)) {
                while (!increStack.isEmpty() && curChar < increStack.peek() && lastOccurrence.get(increStack.peek()) > i) {
                    seen.remove(increStack.pop());
                }
                seen.add(curChar);
                increStack.push(curChar);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : increStack) sb.append(c);
        
        return sb.toString();
    }
}

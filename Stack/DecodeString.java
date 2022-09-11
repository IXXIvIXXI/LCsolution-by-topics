class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> words = new Stack<>();
        String res = "";
        int index = 0;
        
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                // in case the number has multiple digits
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            } else if (s.charAt(index) == '[') {
                // we push string before [ to stack
                // so that we can use it again after
                words.push(res);
                res = "";
                index++;
            } else if (s.charAt(index) == ']') {
                // we append word that needs to be repeated to the word in front
                // a2[c], we appen cc to a
                StringBuilder word = new StringBuilder(words.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    word.append(res);
                }
                // update res
                res = word.toString();
                index++;
            } else {
                res += s.charAt(index);
                index++;
            }
        }
        
        return res;
    }
}

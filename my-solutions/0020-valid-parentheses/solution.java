import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                st.push(')');
            }

            else if (ch == '[') {
                st.push(']');
            }

            else if (ch == '{') {
                st.push('}');
            }

            else if (ch == ')') {

                if (!st.isEmpty()) {

                    if (st.peek() != ch) {
                        return false;
                    } else {
                        st.pop();
                    }

                } else {
                    return false;
                }
            }

            else if (ch == ']') {

                if (!st.isEmpty()) {

                    if (st.peek() != ch) {
                        return false;
                    } else {
                        st.pop();
                    }

                } else {
                    return false;
                }
            }

            else if (ch == '}') {

                if (!st.isEmpty()) {

                    if (st.peek() != ch) {
                        return false;
                    } else {
                        st.pop();
                    }

                } else {
                    return false;
                }
            }
        }

        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

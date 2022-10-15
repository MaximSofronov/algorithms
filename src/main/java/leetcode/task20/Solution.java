package leetcode.task20;

import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public boolean isValid(String s) {

        Deque<Character> stack = new LinkedList<>();

        for (char aChar : s.toCharArray()) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                switch (aChar) {
                    case ')':
                        if (pop != '(') return false;
                        break;
                    case ']':
                        if (pop != '[') return false;
                        break;
                    case '}':
                        if (pop != '{') return false;
                        break;
                    default:
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

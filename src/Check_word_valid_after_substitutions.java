import java.util.Stack;

/*
Problem Statement : 1003. Check If Word Is Valid After Substitutions

Given a string s, determine if it is valid.

A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:

Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
Return true if s is a valid string, otherwise, return false.

 */

/*
Approach 1: Stack based approach. Keep pushing chars onto stack until you see a `c`. At this point, you stack should
contain b & a from top. If this is not true, then return false. Else continue until you reach end of input.
Time: O(N) Space: O(N) where N is the number of characters in input string
 */
public class Check_word_valid_after_substitutions {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()) {
            if (c == 'a' || c == 'b') stack.push(c);
            else {
                if (stack.size() < 2) return false; // Stack top must be b, followed by a. Size < 2 will make it impossible
                char first = stack.pop();
                char second = stack.pop();
                if (first != 'b' || second != 'a') return false; // Stack stores in LIFO
            }
        }
        if (stack.isEmpty()) return true; // Processed all chars successfully
        return false;
    }
    public static void main(String args[]) {
        Check_word_valid_after_substitutions o = new Check_word_valid_after_substitutions();
        System.out.println(o.isValid("aabcbc"));
        System.out.println(o.isValid("abcabcababcc"));
        System.out.println(o.isValid("abccba"));
        System.out.println(o.isValid("cababc"));
    }
}

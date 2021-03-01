/* Problem Statement

We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
*/
public class Rotate_string {
    // Approach 1. Rotate string B one by one and compare with A. If rotated string matches with B, return true else false.
    // Time: O(n) where n is number of chars in A

    // Approach 2. Check if B is a substring of A + A. // Better O(1)
    public static boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        int strLen = A.length();
        if (strLen == 0) return true;
        String bShifted = B;
        for(int i = 0;i<strLen;i++) {
            bShifted = B.substring(i, strLen) + B.substring(0, i);
            if (A.equals(bShifted)) return true;
        }
        return false;
    }
    public static void main(String ... orange) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "abced"));
        System.out.println(rotateString("", ""));
    }
}

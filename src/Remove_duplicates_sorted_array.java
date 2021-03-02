/*
Problem Statement: Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.


 */
public class Remove_duplicates_sorted_array {
    // Approach 1: Two pointer approach. One variable runs through all element (here, i) and other keeps track of index where next unique element needs to be written (here, left).
    // Idea is to identify the first unique element in the block and store it. This works well for all corner cases.
    // Time: O(N), Space: O(1)
    public int removeDuplicates(int[] nums) {
        int n = nums.length, size = 0;
        if (n <= 1) return n;
        // left store index where next unique element will be written
        // First element is always unique. So, start with 1
        int left = 1;
        for(int i=1;i<n;i++) {
            // This means we found a new number. So, we need to store it in left index & increment it
            if (nums[i-1] != nums[i]) {
                nums[left++] = nums[i];
            }
        }
        return left;
    }
    public static void main(String ... orange) {
        Remove_duplicates_sorted_array obj = new Remove_duplicates_sorted_array();
        System.out.println(obj.removeDuplicates(new int[]{1,1,2}));
        System.out.println(obj.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(obj.removeDuplicates(new int[]{1,1,1}));
        System.out.println(obj.removeDuplicates(new int[]{1,2,3}));
        System.out.println(obj.removeDuplicates(new int[]{1}));
    }
}

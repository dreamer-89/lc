public class Partition_array_into_three_parts_with_equal_sum {
    // 1013. Partition Array Into Three Parts With Equal Sum
    // Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.
    //
    //Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])


    // Can input array be divided into 3 equal parts.
    // Step 1. Identify sum of all elements
    // Step 2. Check if array sum is divisible by 3 (because we want to 3 equal parts)
    // Step 3. Calculate average sum
    // Step 4. Count number of sub-parts having same average sum.
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;
        int count = 0, sum = 0, partSum;
        // Step 1
        for(int num: arr) {
            sum+= num;
        }
        // Step 2
        if (sum%3 != 0) return false;

        // Step 3
        partSum = sum/3;
        sum = 0;

        // Step 4
        for(int i=0;i<n;i++) {
            sum+= arr[i];
            if (sum == partSum) {
                sum = 0;
                count++;
            }
        }
        return count >= 3;
    }
    public static void main(String ... oranges) {
        Partition_array_into_three_parts_with_equal_sum obj = new Partition_array_into_three_parts_with_equal_sum();
        System.out.println(obj.canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}));
        System.out.println(obj.canThreePartsEqualSum((new int[]{0,2,1,-6,6,7,9,-1,2,0,1})));
        System.out.println(obj.canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
    }
}

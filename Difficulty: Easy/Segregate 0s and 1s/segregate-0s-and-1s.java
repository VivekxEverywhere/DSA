class Solution {
    void segregate0and1(int[] arr) {
        int zeroCount = 0;
        
        // 1. Zeros ki ginti karo
        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
            }
        }
        
        // 2. Array ko firse fill karo
        for (int i = 0; i < arr.length; i++) {
            if (i < zeroCount) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
    }
}
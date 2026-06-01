class Solution {
    int missingNum(int arr[]) {
        int n = arr.length + 1;  // original size including the missing element
        
        // Use long to avoid integer overflow
        long totalSum = (long) n * (n + 1) / 2;
        
        // Compute sum of elements in the array
        long arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }
        
        // The missing number is the difference
        return (int) (totalSum - arrSum);
    }
}

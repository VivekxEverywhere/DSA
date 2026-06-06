class Solution {
    // Standard Kadane's Algorithm for maximum subarray sum
    private int kadane(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public int maxCircularSum(int[] arr) {
        int n = arr.length;
        
        // Case 1: Maximum subarray sum without wrapping (standard Kadane)
        int maxNormal = kadane(arr);
        
        // If all elements are negative, maxNormal is the answer
        // (since subarray must be non-empty, we can't wrap around)
        
        // Case 2: Maximum subarray sum with wrapping
        // Wrapping max = total sum - minimum subarray sum
        // To find min subarray sum, we invert signs and run Kadane, then negate
        
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // Invert array to find minimum subarray sum using Kadane
        int[] inverted = new int[n];
        for (int i = 0; i < n; i++) {
            inverted[i] = -arr[i];
        }
        
        // Max of inverted array = -(min subarray sum of original)
        int maxInverted = kadane(inverted);
        int minSubarraySum = -maxInverted;
        
        // Wrapping sum = total - min subarray sum
        int maxWrap = totalSum - minSubarraySum;
        
        // If all numbers are negative, maxWrap (which equals total - total = 0) would be wrong
        // because we need a non-empty subarray. In that case, maxNormal is correct.
        if (totalSum == minSubarraySum) {
            return maxNormal;
        }
        
        return Math.max(maxNormal, maxWrap);
    }
}

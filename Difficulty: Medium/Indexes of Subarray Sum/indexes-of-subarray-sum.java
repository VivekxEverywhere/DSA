
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        
        int left = 0;
        int currentSum = 0;
        
        for (int right = 0; right < n; right++) {
            // Add the current element to the window
            currentSum += arr[right];
            
            // Shrink the window from the left while sum exceeds target
            while (currentSum > target && left < right) {
                currentSum -= arr[left];
                left++;
            }
            
            // Check if we've found the target sum
            if (currentSum == target) {
                result.add(left + 1);   // 1-based index
                result.add(right + 1);  // 1-based index
                return result;
            }
        }
        
        // No subarray found
        result.add(-1);
        return result;
    }
}

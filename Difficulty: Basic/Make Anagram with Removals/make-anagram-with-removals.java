class Solution {
    public int remAnagram(String s1, String s2) {
        int[] freq = new int[26];
        
        // Count characters in s1 (positive)
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Count characters in s2 (negative)
        for (char c : s2.toCharArray()) {
            freq[c - 'a']--;
        }
        
        // Sum of absolute differences = total deletions needed
        int deletions = 0;
        for (int count : freq) {
            deletions += Math.abs(count);
        }
        
        return deletions;
    }
}

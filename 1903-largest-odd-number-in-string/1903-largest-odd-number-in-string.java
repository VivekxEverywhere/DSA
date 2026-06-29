class Solution {
    public String largestOddNumber(String num) {
        int ind = -1;
        int i;
        
        // Fix 1: i >= 0 kiya taaki loop peeche se zero tak chale
        for (i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) {
                ind = i;
                break;
            }
        }
        
        if (ind == -1) {
            return "";
        }
        
        int k = 0;
        // Fix 2: "0" ki jagah '0' kiya taaki char se char compare ho
        while (k <= ind && num.charAt(k) == '0') {
            k++;
        }
        
        return num.substring(k, ind + 1);
    }
}

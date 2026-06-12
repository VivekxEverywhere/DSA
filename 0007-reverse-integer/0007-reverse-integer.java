class Solution {

    public int reverse(int x) {

        int sign = (x < 0) ? -1 : 1;
        x = Math.abs(x);

        int revNum = 0;

        while (x > 0) {

            int digit = x % 10;

            // 🔥 Overflow check BEFORE updating
            if (revNum > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }

            revNum = revNum * 10 + digit;
            x = x / 10;
        }

        return revNum * sign;
    }
}
package team.six.youth.yudungang.problem8;

/**
 * @author yudungang
 */
public class Solution {

    public int myAtoi(String str) {
        int sign = 1, base = 0, i = 0;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i) == '-' ? -1 : sign;
            i++;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int num = str.charAt(i) - '0';
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && num > 7)) {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            base = base * 10 + num;
            i++;
        }
        return base * sign;
    }

}

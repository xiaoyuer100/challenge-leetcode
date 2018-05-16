package team.six.youth.yudungang.Problem12;

/**
 * 数字转罗马数字
 * 1) 思路一: 分区间
 * 2) 思路二: 将单个字符扩展个组合(更优)
 *
 */
public class Solution {

    public static String intToRoman(int num) {
        if (num <= 0)
            return "";
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int count = num / nums[i];
            while (count > 0) {
                sb.append(roman[i]);
                count--;
            }
            num %= nums[i];
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = intToRoman(1994);
        System.out.println(s);
    }
}

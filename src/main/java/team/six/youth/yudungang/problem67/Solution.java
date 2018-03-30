package team.six.youth.yudungang.problem67;

/**
 * @author yudungang
 */
public class Solution {

    /**
     * a.数组检索的效率高于substring
     * b.将各个字符放在字符数组中，然后放在String的构造函数构造 效率高于 单个字符进行相互拼接
     */
    public static String addBinary(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        int sum = 0;
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int indexA = a.length();
        int indexB = b.length();
        int max = Math.max(indexA,indexB);
        char[] result = new char[max];
        while (indexA > 0 || indexB > 0) {
            if(indexA > 0) sum += charA[--indexA] - '0';
            if(indexB > 0) sum += charB[--indexB]- '0';
            result[--max] = (char)((sum > 1 ? sum -2: sum) + '0');
            sum = sum >> 1;
        }
        String res = new String(result);
        if (sum != 0) {
            res = sum + res;
        }
        return res;
    }
}

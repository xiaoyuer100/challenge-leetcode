package team.six.youth.yudungang.problem13;

import java.util.HashMap;
import java.util.Map;


/**
 * 罗马数字转 阿拉伯数字
 */
public class Solution13 {

    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);
        int r = 0;
        int length = s.length();
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int curr = map.get(s.charAt(i) + "");
            r += curr;
            if (pre < curr) {
                r -= pre * 2;
            }
            pre = curr;
        }
        return r;
    }
}

package team.six.youth.yudungang.Problem0;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yudungang
 */
public class Solution {

    public Set<Integer> StampCombinationCount(Integer ii, Integer iv, Integer jj, Integer jv){
        Set<Integer> result = new HashSet<Integer>();
        if(ii <= 0 || jv <= 0)
            return result;
        for (int i = 0; i <= ii; i++) {
            for (int j = 0; j <= jj; j++) {
                int r = i * iv + j * jv;
                if(r != 0){
                    result.add(r);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Set<Integer> set = solution.StampCombinationCount(1, 3, 2, 2);
        System.out.println(set);
    }
}

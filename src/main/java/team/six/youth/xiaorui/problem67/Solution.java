package team.six.youth.problem67.xiaorui;

import java.util.Stack;

public class Solution {
    public static void main (String args[]){
        System.out.print(new Solution().addBinary("1","0"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        int int_a;
        int int_b;
        int carry = 0;
        Stack<Integer> stack = new Stack<>();
        while(a_index>=0||b_index>=0){
            int_a = a_index >= 0?a.charAt(a_index--)-'0':0;
            int_b = b_index >= 0?b.charAt(b_index--)-'0':0;
            sb.insert(0,(int_a^int_b)&(~carry) | (~(int_a^int_b))&carry);       //r = !ab!c + a!b!c + !a!bc + abc
            carry = int_a&int_b | (int_a^int_b)&carry;                                  //c = c = !abc + a!bc + abc + ab!c
        }
        sb.insert(0,carry==0?"":carry);
        return sb.toString();
    }
}


/**
  *
  *         ab
  *  c
  *
  *      00	01	10	11
  *  0	0	0	0	1
  *  1	0	1	1	1           c = !abc + a!bc + abc + ab!c
  *
  *      00	01	10	11
  *  0	0	1	1	0
  *  1	1	0	0	1           r = !ab!c + a!b!c + !a!bc + abc
  *
  *
  */
package team.six.youth.problem67.xiaorui;

public class Solution {
    public static void main (String args[]){
        System.out.print(new Solution().addBinary("1","0"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        Boolean bool_a = false;
        Boolean bool_b = false;
        boolean carry = false;
        while(a_index>=0||b_index>=0){
            bool_a = (a_index >= 0?a.charAt(a_index--)-'0':0)==1;
            bool_b = (b_index >= 0?b.charAt(b_index--)-'0':0)==1;
            sb.insert(0,((bool_a!=bool_b)&&(!carry) || (!(bool_a!=bool_b))&&carry)?1:0);       //r = !ab!c + a!b!c + !a!bc + abc
            carry = bool_a&&bool_b || (bool_a!=bool_b)&&carry;                                  //c = c = !abc + a!bc + abc + ab!c
        }
        sb.insert(0,carry?1:"");
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
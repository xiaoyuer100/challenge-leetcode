package team.six.youth.xiaorui.problem67;

public class Solution {
    public static void main (String args[]){
        System.out.print(new Solution().addBinary("1","0"));
    }

    public String addBinary(String a, String b) {
        char[] result = new char[Math.max(a.length(),b.length())+1];
        int res_length = result.length -1;
        result[0]='0';
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        boolean bool_a = false;
        boolean bool_b = false;
        boolean carry = false;
        while(a_index>=0||b_index>=0){
            bool_a = (a_index == -1?false:a.charAt(a_index--)=='1');
            bool_b = (b_index == -1?false:b.charAt(b_index--)=='1');
            result[res_length--] = ((bool_a!=bool_b)&&(!carry) || (!(bool_a!=bool_b))&&carry)?'1':'0';       //r = !ab!c + a!b!c + !a!bc + abc
            carry = bool_a&&bool_b || (bool_a!=bool_b)&&carry;                                                  //c = c = !abc + a!bc + abc + ab!c
        }
        if(carry){
            result[0]='1';
        }
        return String.copyValueOf(result,carry?0:1,carry?result.length:result.length-1);
    }

    // or easier
    public String addBinary2(String a, String b) {
        char[] result = new char[Math.max(a.length(),b.length())+1];
        int res_length = result.length -1;
        result[0]='0';
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        int int_a = 0;
        int int_b = 0;
        int carry = 0;
        while(a_index!=0||b_index>=0){
            int_a = (a_index == -1?0:a.charAt(a_index--)-'0');
            int_b = (b_index == -1?0:b.charAt(b_index--)-'0');
            result[res_length--] = (char)((int_a+int_b+carry)%2 + '0');       //r = !ab!c + a!b!c + !a!bc + abc
            carry = (int_a+int_b+carry)/2;                                          //c = c = !abc + a!bc + abc + ab!c
        }
        result[0] = (char)(carry+'0');
        return String.copyValueOf(result,carry==0?1:0,result.length-(carry==0?1:0));
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
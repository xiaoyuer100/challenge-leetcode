package team.six.youth.yudungang.problem10;

class Solution {

    /**
     *思路梳理:
     *  正则第二个字符不是*    a=a  a!=b
     *      比较这两个字符是否相等，相等继续向后移动，不相等返回false
     *  正则第二个字符是*  [a a*]  [a b*]
     *      如果两者不相等，字符串后移一位，正则表达式后移两位
     *      如果两者相等
     *          （1）字符串后移一位，正则不动
     *          （2）字符串后移一位，正则后移两位
     *          （3）字符串不动，正则后移两位
     *
     * @param s 字符串
     * @param p 正则
     * @return
     */
    public boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;
        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();
        return  isMatch(sa,0,pa,0);
    }

    private boolean isMatch(char[] sa, int si, char[] pa, int pi) {
        if(si == sa.length && pi == pa.length)
            return true;
        if(pi+1 < pa.length && pa[pi+1] == '*'){
            if(si < sa.length && (sa[si] == pa[pi] || pa[pi] == '.')){
                return isMatch(sa,si+1,pa,pi) || isMatch(sa,si+1,pa,pi+2) || isMatch(sa,si,pa,pi+2);
            }else{
                return isMatch(sa,si,pa,pi+2);
            }
        }
        if((pi <pa.length && si < sa.length) && (sa[si] == pa[pi] || pa[pi] == '.') ){
            return isMatch(sa,si+1,pa,pi+1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean match = solution.isMatch("123", "1*23");
        System.out.println(match);
    }
}
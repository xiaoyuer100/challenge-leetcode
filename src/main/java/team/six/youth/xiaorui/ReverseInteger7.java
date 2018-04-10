package team.six.youth.xiaorui;

public class ReverseInteger7 {
    public static void main(String args[]){
        System.out.print(new ReverseInteger7().new Solution().reverse( 111121215));
    }
    class Solution{
        public int reverse(int i){
            int result = 1;
            while(i!=0){
                result = result * 10 + i % 10;
                i = i / 10;
            }

            return result;
        }
    }
}

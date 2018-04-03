class Solution {
    public int reverse(int x) {
        int flag = 1;//1表示正数，0表示负数
        if(x<0) {
            x = -x;
            flag = 0;
        }

        long reverseX = 0;
        while(x != 0){
            reverseX = reverseX*10 + x%10;
            x /= 10;
        }

        if(reverseX<Integer.MIN_VALUE || reverseX>Integer.MAX_VALUE)
            return 0;

        return flag==1?((int)reverseX):((int)reverseX*(-1));
    }
}

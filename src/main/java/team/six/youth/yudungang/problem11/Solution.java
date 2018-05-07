package team.six.youth.yudungang.problem11;

public class Solution {

    /**
     * 切入点: 前后端思维,两边向中间逼近
     */
    public int maxArea(int[] height) {
        if(height == null || height.length < 2)
            return 0;
        int max = 0;
        int i = 0;
        int j = height.length-1;
        while(i < j){
            int r = (j-i)*Math.min(height[i],height[j]);
            if(r > max){
                max =r;
            }
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}

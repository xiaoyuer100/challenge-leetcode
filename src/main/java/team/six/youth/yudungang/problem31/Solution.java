package team.six.youth.yudungang.problem31;

import java.util.Arrays;

/**
 * @author  yudungang
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return ;
        int length = nums.length;
        for(int i = length -1; i > 0; i--){
            if(nums[i-1] < nums[i]){
                int iv = nums[i-1];
                int min = nums[i];
                int index = i;
                for(int j= i+1; j <= length -1; j++){
                    if(nums[j] > iv && nums[j] < min){
                        min = nums[j];
                        index = j;
                    }
                }
                swap(nums,i-1,index);
                Arrays.sort(nums,i,length);
                return ;
            }
        }
        //反转数组
        for(int j = 0; j <= length/2; j++){
            swap(nums,j,length-1-j);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

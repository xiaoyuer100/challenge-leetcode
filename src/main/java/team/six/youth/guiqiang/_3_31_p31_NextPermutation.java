package team.six.youth.guiqiang;

import java.util.Arrays;

public class _3_31_p31_NextPermutation {
	public void nextPermutation(int[] nums) {
		boolean flag = false;
		for (int i = nums.length - 1; i > 0; i--) {
			if(nums[i-1] < nums[i]){
				for (int j = nums.length - 1; j > i-1; j--) {
					if(nums[j] > nums[i-1]){
						int tmp = nums[i-1];
						nums[i-1] = nums[j];
						nums[j] = tmp;
						Arrays.sort(nums, i, nums.length);
						flag = true;
						break;
					}
				}
			}
			if(flag){
				break;
			}
		}
		if(!flag){
			Arrays.sort(nums);
		}
	}
	
	public void printIntArr(int[] nums){
		StringBuilder sb = new StringBuilder();
		for (int i : nums) {
			sb.append(i + ",");
		}
		System.out.println(sb.substring(0, sb.length()-1));
	}
	
//	public static void main(String[] args) {
//		int[] nums = {5,4,7,5,3,2};
//		_3_31_p31_NextPermutation solution = new _3_31_p31_NextPermutation();
//		solution.printIntArr(nums);
//		solution.nextPermutation(nums);
//		solution.printIntArr(nums);
//	}
}

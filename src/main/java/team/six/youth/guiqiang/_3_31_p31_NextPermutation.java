package team.six.youth.guiqiang;

import java.util.Arrays;
/**
 * 
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 *
 */
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

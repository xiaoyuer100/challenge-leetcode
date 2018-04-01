package team.six.youth.guiqiang;

/**
 * 
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 *
 */
public class _4_1_p4_MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1= nums1.length;
		int len2 = nums2.length;
		if(len1 == 0 || len2 == 0 ){
			int[] nums = len1 == 0 ? nums2 : nums1;
			int len = nums.length;
			if(len%2 == 0){
				return (nums[len/2] + nums[len/2 - 1])/2.0;
			}else{
				return nums[len/2];
			}
		}
		int lenSum = len1 + len2;
		double middle = 0;
		int p = 0;
		int q = 0;
		int max = 0;
		if((lenSum)%2 == 0){
			int index1 = lenSum / 2 - 1;
			int index2 = index1 + 1;
			for (int i = 0; i < lenSum; i++) {
				if(p == len1){
					max =nums2[q];
					q++;
				}else if(q == len2){
					max =nums1[p];
					p++;
				}else if(nums1[p] == nums2[q]){
					if(p < len1){
						max = nums1[p];
						p++;
					}else{
						max = nums2[q];
						q++;
					}
				}else if(nums1[p] < nums2[q]){
					max = nums1[p];
					p++;
				}else{
					max = nums2[q];
					q++;
				}
				if(i==index1){
					middle += max;
				}
				if(i==index2){
					middle +=max;
					middle = middle/2;
					break;
				}
			}
		}else{
			int index1 = lenSum / 2;
			for (int i = 0; i < lenSum; i++) {
				if(p == len1){
					max =nums2[q];
					q++;
				}else if(q == len2){
					max =nums1[p];
					p++;
				}else if(nums1[p] == nums2[q]){
					if(p < len1){
						max = nums1[p];
						p++;
					}else{
						max = nums2[q];
						q++;
					}
				}else if(nums1[p] < nums2[q]){
					max = nums1[p];
					p++;
				}else{
					max = nums2[q];
					q++;
				}
				if(i==index1){
					middle += max;
					break;
				}
			}
		}
		return middle;
	}
	
//	public static void main(String[] args) {
//		_4_1_p4_MedianOfTwoSortedArrays solution = new _4_1_p4_MedianOfTwoSortedArrays();
//		//double result = solution.findMedianSortedArrays(new int[]{1}, new int[]{2});
//		//double result = solution.findMedianSortedArrays(new int[]{2,2,2,2}, new int[]{2,2,2,2});
//		double result = solution.findMedianSortedArrays(new int[]{}, new int[]{2,3});
//		System.out.println(result);
//	}
}

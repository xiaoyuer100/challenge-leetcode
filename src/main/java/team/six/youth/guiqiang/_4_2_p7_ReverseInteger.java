package team.six.youth.guiqiang;

/**
 * 
7. Reverse Integer
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 */
public class _4_2_p7_ReverseInteger {
	public int reverse(int x) {
		boolean negative = false;
		long lx = x;
		if(lx<0){
			negative = true;
			lx = Math.abs(lx);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(lx);
		sb.reverse();
		long ret = Long.valueOf(sb.toString());
		if(negative){
			ret = -ret;
		}
		if(ret < -Math.pow(2, 31) || ret > Math.pow(2, 31) - 1){
			return 0;
		}
		return (int) ret;
	}
	
//	public static void main(String[] args) {
//		_4_2_p7_ReverseInteger solution =  new _4_2_p7_ReverseInteger();
//		System.out.println(solution.reverse(-2147483648));
//	}
}

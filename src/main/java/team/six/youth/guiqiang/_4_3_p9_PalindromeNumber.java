package team.six.youth.guiqiang;

/**
 * 
9. 回文数

判断一个整数是否是回文数。不能使用辅助空间。

点击查看提示

一些提示:

负整数可以是回文数吗？（例如 -1）

如果你打算把整数转为字符串，请注意不允许使用辅助空间的限制。

你也可以考虑将数字颠倒。但是如果你已经解决了 “颠倒整数” 问题的话，就会注意到颠倒整数时可能会发生溢出。你怎么来解决这个问题呢？

本题有一种比较通用的解决方式。
 *
 */
public class _4_3_p9_PalindromeNumber {
	
	public boolean isPalindrome(int x) {
		if (x<0) {
			return false;
		}
		final char[] chars = String.valueOf(x).toCharArray();
		int len = chars.length - 1;
		for (int i = 0; i <= len/2; i++) {
			if(chars[i] != chars[len - i]){
				return false;
			}
		}
		return true;
	}
	
	public boolean isPalindrome2(int x) {
		if (x<0) {
			return false;
		}
		StringBuilder sb = new StringBuilder(String.valueOf(x));
		String str = sb.toString();
        return str.equals(sb.reverse().toString());
    }
	
	
//	public static void main(String[] args) {
//		_4_3_p9_PalindromeNumber solution = new _4_3_p9_PalindromeNumber();
//		System.out.println(solution.isPalindrome(1000021));
//	}
}

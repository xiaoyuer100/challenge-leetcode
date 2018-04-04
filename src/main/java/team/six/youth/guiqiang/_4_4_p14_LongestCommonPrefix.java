package team.six.youth.guiqiang;

/**
 * 
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strin
 *
 */
public class _4_4_p14_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length < 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int minLen = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			if(strs[i].length() < minLen){
				minLen = strs[i].length();
			}
		}
		for (int i = 0; i < minLen; i++) {
			char commonChar = strs[0].charAt(i);
			boolean isBreak = false;
			for (int j = 1; j < strs.length; j++) {
				char compareChar = strs[j].charAt(i);
				if (commonChar != compareChar){
					isBreak = true;
					break;
				}
			}
			if (isBreak){
				break;
			}
			sb.append(commonChar);
		}
		return sb.toString();
	}
	
//	public static void main(String[] args) {
//		_4_4_p14_LongestCommonPrefix solution  = new _4_4_p14_LongestCommonPrefix();
//		String ret =solution.longestCommonPrefix(new String[]{"ss", "sss"});
//		System.out.println(ret);
//	}
}

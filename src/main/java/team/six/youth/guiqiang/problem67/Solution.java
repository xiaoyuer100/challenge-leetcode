package team.six.youth.guiqiang.problem67;

public class Solution {
	public String addBinary(String a, String b) {
		char[] ba = a.toCharArray();
		char[] bb = b.toCharArray();
		int aLen = a.length() - 1;
		int bLen = b.length() - 1;
		int len = aLen > bLen ? aLen : bLen;
		StringBuilder sb = new StringBuilder();
		int app = 0;
		for (int i = 0; i <= len; i++) {
			int x = aLen - i >= 0 ? Integer.valueOf(String.valueOf(ba[aLen - i])) : 0;
			int y = bLen - i >= 0 ? Integer.valueOf(String.valueOf(bb[bLen - i])) : 0;
			int sum = x + y + app;
			if (sum >= 2){
				sb.append(sum - 2);
				app = 1;
			}else{
				sb.append(sum);
				app = 0;
			}
		}
		if(app == 1){
			sb.append(app);
		}
		return sb.reverse().toString();
	}
}

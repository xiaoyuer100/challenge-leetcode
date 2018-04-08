package team.six.youth.guiqiang;

import java.util.HashMap;
import java.util.Map;
/**
 * 
   某人有四张3分的邮票和三张5分的邮票，用这些邮票中的一张或若干张可以得到多少种不同的邮资？
 *
 */
public class _4_5_TouTiao_Stamp {
	public int CountPostage(int num3, int num5){
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		for (int i = 0; i <= num3; i++) {
			for (int j = 0; j <= num5; j++) {
				int total = i * 3 + j * 5;
				countMap.put(total, total);
			}
		}
		return countMap.size() - 1 ;
	}
	
	public static void main(String[] args) {
		_4_5_TouTiao_Stamp solution = new _4_5_TouTiao_Stamp();
		int result = solution.CountPostage(4, 3);
		System.out.println(result);
	}
}

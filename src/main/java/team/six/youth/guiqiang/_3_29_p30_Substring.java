package team.six.youth.guiqiang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3_29_p30_Substring {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> retList = new ArrayList<Integer>();
		if (s == null || s.equals("") || words.length == 0 || words == null) {
			return retList;
		}
		final Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		for (final String word : words) {
			wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
		}
		int wordlegth = words[0].length();
		int wordlegthSum = wordlegth * words.length;
		for (int i = 0; i < s.length() - wordlegthSum + 1; i++) {
			Map<String, Integer> submMap = new HashMap<String, Integer>();
			boolean flag = true;
			for (int j = 0; j < wordlegthSum; j += wordlegth) {
				String subSubStr = s.substring(i + j, i + j + wordlegth);
				if (!wordsMap.containsKey(subSubStr)) {
					flag = false;
					break;
				}
				submMap.put(subSubStr, submMap.getOrDefault(subSubStr, 0) + 1);
				if (submMap.get(subSubStr) > wordsMap.get(subSubStr)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				retList.add(i);
			}
		}
		return retList;
	}
}

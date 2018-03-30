package team.six.youth.guiqiang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 *
 */

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

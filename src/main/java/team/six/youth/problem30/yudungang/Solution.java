package team.six.youth.problem30.yudungang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> seccess = new ArrayList<>();
        if (words == null || s == null || words.length == 0 || words.length * words[0].length() > s.length())
            return seccess;

        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        ArrayList<String> attr = new ArrayList<>();
        for (String word : words) {
            attr.add(word);
            if (set.size() > 1 && s.replace(word, "").length() == 0) {
                return seccess;
            }
        }
        int length = words[0].length();

        int limit = (words.length - 1) * words[0].length();
        ArrayList<String> succAttr = new ArrayList<>();
        for (int i = words[0].length() - 1; i < s.length(); i++) {
            String c = s.charAt(i) + "";
            boolean isContain = false;
            String pre = s.substring(i - words[0].length() + 1, i + 1);
            for (String str : words) {
                if (str.equals(pre)) {
                    if (succAttr.size() >= limit) {
                        ArrayList<String> tempArr = new ArrayList<>(attr);
                        removeOne(tempArr, pre);
                        int preIndex = succAttr.size();
                        boolean succ = true;
                        for (int j = 1; j < words.length; j++) {
                            preIndex = preIndex - length;
                            if (preIndex < 0) {
                                break;
                            }
                            String preResult = succAttr.get(preIndex);
                            if (preResult == "") {
                                succ = false;
                                break;
                            } else {
                                removeOne(tempArr, preResult);
                            }

                        }
                        if (succ && tempArr.size() == 0) {
                            int index = i + 1 - words.length * words[0].length();
                            if (index >= 0) {
                                seccess.add(index);
                            }
                        }
                    }
                    isContain = true;
                    succAttr.add(str);
                    break;
                }
            }
            if (!isContain) {
                succAttr.add("");
            }
            if (succAttr.size() > limit) {
                succAttr.remove(0);
            }
        }
        return seccess;
    }

    public void removeOne(ArrayList<String> array, String remove) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(remove)) {
                array.remove(i);
                break;
            }
        }
    }
}

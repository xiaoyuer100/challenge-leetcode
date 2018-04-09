package team.six.youth.xiaorui;

import java.util.ArrayList;
import java.util.List;

public class substringWithConcatenationOfAllWords30{

    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            ArrayList<Integer> results = new ArrayList<Integer>();
            int index[] = new int[words.length];
            int max[] = new int[words.length];
            int matched = 0;
            int result = 0;
            int gap = words[0].length();
            int s_size = s.length();

            for (int i=0;i<words.length;i++){
                max[contains(words,words[i],0)]++;
            }

            for (int i=0;i+gap<=s_size;){
                int test = contains(words,s,i);
                if(test==-1){
                    for (int j=0;j<index.length;j++) {
                        index[j] = 0;
                    }
                    if(matched==0) {
                        result ++;
                        i=result;
                    }
                    matched = 0;
                } else {
                    if(index[test]==max[test]){
                        for (int j=0;j<index.length;j++) {
                            index[j] = 0;
                        }
                        matched = 0;
                        result ++;
                        i = result;
                    } else {
                        index[test] ++;
                        matched ++;
                        i += gap;
                        if(matched==words.length){
                            results.add(result);
                            result += 1;
                            for (int j=0;j<index.length;j++) {
                                index[j] = 0;
                            }
                            matched = 0;
                            i = result;
                        }
                    }
                }

            }
            return results;
        }

        private final int contains(String[]words,String s,int start){
            for (int i=0;i<words.length;i++){
                if(equals(words[i],s,start)){
                    return i;
                }
            }
            return -1;
        }

        private final boolean equals(String word,String s,int start){
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)!=s.charAt(i+start)){
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }
    }

}

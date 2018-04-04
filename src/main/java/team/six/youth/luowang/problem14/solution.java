class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0) return "";

        if(strs.length == 1) return strs[0];

        String maxComPrefix = strs[0];
        for(int i=1;i<strs.length;i++){
            StringBuilder sb = new StringBuilder();

            for(int j=0;j< maxComPrefix.length()&&j<strs[i].length();j++){
                if(maxComPrefix.charAt(j) == strs[i].charAt(j))
                    sb.append(maxComPrefix.charAt(j));
                else{
                    maxComPrefix = sb.toString();
                    continue;

                }

            }

            maxComPrefix = sb.toString();

        }

        return maxComPrefix;

    }

}

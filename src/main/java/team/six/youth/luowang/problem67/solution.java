class Solution {
    public String addBinary(String a, String b) {
        if(a==null || b==null) return null;

        int iA = a.length()-1;
        int iB = b.length()-1;
        int sum = 0;

        StringBuilder sb = new StringBuilder();
        while(iA >= 0 || iB >= 0 || sum == 1){
            sum += iA >=0 ? (a.charAt(iA--)-'0') : 0;
            sum += iB >=0 ? (b.charAt(iB--)-'0') : 0;
            sb.insert(0,(char)(sum%2+'0'));
            sum /= 2;

        }

        return sb.toString();

    }

}

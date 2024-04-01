package leecode100;

public class L005最长回文子串 {
    /**
     * 动态规划
     * 给你一个字符串 s，找到 s 中最长的回文子串
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] ans = new int[2];
        int max = 1;
        boolean[][] huiwen =  new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n-len+1 ; i++) {
                if( len == 1 || (len==2 && s.charAt(i) == s.charAt(i+len-1) ) ||(s.charAt(i) == s.charAt(i+len-1) && huiwen[i+1][i+len-2] == true)){
                    huiwen[i][i+len-1] = true;
                    if(len >max){
                        max = len;
                        ans[0] = i;
                        ans[1] = i + len -1;
                    }
                }else{
                    huiwen[i][i+len-1] = false;
                }
            }
        }
        return s.substring(ans[0] , ans[1]+1);
    }

    public static void main(String[] args) {
        L005最长回文子串 l = new L005最长回文子串();
        String babad = l.longestPalindrome("bb");
        System.out.println(babad);
    }
}

package leecode100;

import java.util.HashMap;

public class L003无重复字符的最长字串 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<=1){
            return n;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int i = 0; i <n ; i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(map.get(s.charAt(i))+1 , left);
            }
            map.put(s.charAt(i),i);
            ans = Math.max(ans,i-left +1);
        }
        return ans;
    }
}

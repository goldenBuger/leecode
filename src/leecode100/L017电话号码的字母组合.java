package leecode100;

import 数据结构.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L017电话号码的字母组合 {
    HashMap<Character,String> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if(len<1)   return res;
        initMap();
        char q = digits.charAt(0);
        String s = map.get(digits.charAt(0));
        for (Character c: s.toCharArray()) {
            String tmp = c.toString();
            traceBack(digits,tmp,len);
        }
        return res;
    }
    public void traceBack(String digits,String tmp, int len){
        if(tmp.length() == len){
            res.add(tmp);
            return;
        }else{
            String s = map.get(digits.charAt(tmp.length()));
            for(Character c : s.toCharArray()){
                tmp +=c;
                traceBack(digits,tmp,len);
                tmp = tmp.substring(0,tmp.length()-1);
            }
        }
    }
    public void initMap(){
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
}

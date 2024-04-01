package leecode100;

import java.util.ArrayList;
import java.util.List;

public class L022括号生成 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        traceBack(0,0,0,n,new String());
        return res;
    }
    public void traceBack(int left , int right,int len,int n,String s){
        if(len == n*2){
            res.add(s);
            return;
        }
        if(left < n){
            s +='(';
            traceBack(left+1,right,len+1,n,s);
            s = s.substring(0,s.length()-1);
        }
        if(right < left){
            s +=')';
            traceBack(left,right+1,len+1,n,s);
            s = s.substring(0,s.length()-1);
        }
    }

}

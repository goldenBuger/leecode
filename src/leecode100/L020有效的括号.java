package leecode100;

import java.util.HashMap;
import java.util.Stack;

public class L020有效的括号 {
    HashMap<Character,Character> map = new HashMap<>();
    public boolean isValid(String s) {
        if(s.length() %2 !=0)   return false;
        Stack<Character> stack = new Stack<>();
        initMap();
        for (int i = 0; i <s.length() ; i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty() || stack.peek()!=map.get(c)){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
    public void initMap(){
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
    }
}

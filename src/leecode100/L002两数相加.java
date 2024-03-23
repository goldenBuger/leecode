package leecode100;

import 数据结构.ListNode;

public class L002两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode tmp = node;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int flag = 0;
        while(p1!=null || p2!=null ||flag!=0){
            int v1 = p1==null?0:p1.val;
            int v2 = p2==null?0:p2.val;
            int val = (v1 + v2 + flag) % 10;
            flag = (v1 + v2 + flag) / 10;
            tmp.next = new ListNode(val);
            tmp = tmp.next;
            if(p1!=null){
                p1 =p1.next;
            }
            if(p2!=null){
                p2=p2.next;
            }
        }
        return node.next;
    }
}

package leecode100;

import 数据结构.ListNode;

public class L021合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null ||list2==null){
            return list1==null?list2:list1;
        }
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while(list1!=null &&list2!=null){
            int val1 = list1.val;
            int val2 = list2.val;
            if(val1 < val2){
                tmp.next = list1;
                list1 = list1.next;
            }else{
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        if(list1!=null){
            tmp.next=list1;
        }
        if(list2!=null){
            tmp.next=list2;
        }
        return head.next;
    }
}

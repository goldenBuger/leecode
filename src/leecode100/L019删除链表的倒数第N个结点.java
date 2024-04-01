package leecode100;

import 数据结构.ListNode;

public class L019删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)  return head;
        int len = 0;
        ListNode tmp = new ListNode(0);
        tmp.next=head;
        ListNode fast = tmp;
        ListNode slow = tmp;
        while(n>0){
            fast = fast.next;
            n--;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tmp.next;
    }
}

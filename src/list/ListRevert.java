package list;

/**
 * 区间内链表反转
 *
 * 解法：串针引线法 + 伪头指针法
 */
public class ListRevert {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode result = reverseBetween(listNode1, 2, 4);

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode preNode = newHead;
        for (int i=1; i<left; i++) {
            preNode = preNode.next;
        }

        ListNode cur = preNode.next;
        for (int i=left; i<right; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = preNode.next;
            preNode.next = next;
        }
        return newHead.next;
    }
}


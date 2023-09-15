package list;

/**
 * 链表是否带环
 * 注意：判断链表是否带环条件的写法
 *
 */
public class ListRecal {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        ListRecal listRecal = new ListRecal();
        ListNode ret = listRecal.detectCycle(listNode1);
    }


    /**
     * 链表是否带环 - 快慢指针
     * @param head
     * @return
     */
    public HasCycle hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return new HasCycle(false, null);
        }

        ListNode cur = head, next = head;

        while (next != null && next.next != null) { // 注意：条件的写法
            cur = cur.next;
            next = next.next.next;

            if (cur == next) {
                break;
            }
        }

        return new HasCycle(cur==next, cur);
    }

    /**
     * 判读环的入口结点 无环也返回null
     *
     * 环长：c  开始结点到入口结点：a  入口结点到相遇结点：b
     * (a+b)*2 = a+b+nc  => a+b = nc => a=c-b
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        HasCycle hasCycle = hasCycle(head);

        if (!hasCycle.hasCycle) {
            return null;
        }

        ListNode inNode = hasCycle.getInNode(), cur = head;

        while (cur != inNode) {
            cur = cur.next;
            inNode = inNode.next;
        }
        return cur;
    }

    public ListNode hasCycle1(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //相遇点
        ListNode meetNode = hasCycle1(head);
        if (meetNode == null) {
            return null;
        }
        ListNode cur = head;
        while(meetNode!= null && meetNode != cur) {
            meetNode = meetNode.next;
            cur = cur.next;
        }
        return cur;
    }

    class HasCycle {
        boolean hasCycle;
        ListNode inNode;

        HasCycle(boolean hasCycle, ListNode inNode) {
            this.hasCycle = hasCycle;
            this.inNode = inNode;
        }

        public boolean isHasCycle() {
            return hasCycle;
        }

        public void setHasCycle(boolean hasCycle) {
            this.hasCycle = hasCycle;
        }

        public ListNode getInNode() {
            return inNode;
        }

        public void setInNode(ListNode inNode) {
            this.inNode = inNode;
        }
    }
}

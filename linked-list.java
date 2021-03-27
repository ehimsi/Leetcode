import java.util.List;

class Scratch {
    public static void main(String[] args) {

        //assuming there is a LL populated in place.
        //1->2->3->4->5
        //1-2
        //LL without cycle.
        /*ListNode head = new ListNode(1);
        head.next = null;
        ListNode n1 = new ListNode(2);
        head.next = n1;
        ListNode n2 = new ListNode(3);
        n1.next = n2;
        ListNode n3 = new ListNode(4);
        n2.next = n3;
        ListNode n4 = new ListNode(5);
        n3.next = n4;
        n4.next = null;*/
        //reverse(head);
        //head = reverseRange(head, 1, 5);
        //print(head);

        //LL with cycle
        ListNode head = new ListNode(1);
        head.next = null;
        ListNode n1 = new ListNode(2);
        head.next = n1;
        ListNode n2 = new ListNode(3);
        n1.next = n2;
        ListNode n3 = new ListNode(4);
        n2.next = n3;
        ListNode n4 = new ListNode(5);
        n3.next = n4;
        n4.next = n2;

        cycleDetection(head);
    }

    private static void reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    private static void cycleDetection(ListNode head){
        if(head.next==null){
            System.out.println("single element cannot have a cycle");
        }
        if(head.next.next==null && head.next!=head){
            System.out.println("No cycle detected!");
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if(slow != fast){
                fast = fast.next;
            } else {
                System.out.println("cycle detected!");
                break;
            }
        }
    }

    //1,2,3,4,5 - LL
    //0<=m<n<=LL.length
    //m=2,n=4
    //op- 1,4,3,2,5
    private static ListNode reverseRange(ListNode head, int m, int n) {
        ListNode mCurr = null, mPrev = null, mNext = null;
        ListNode nCurr = null, nPrev = null, nNext = null;
        ListNode curr = head;
        int ctr = 1;//bcz idx  start from 1.
        while (curr != null) {
            if (ctr == m - 1) {
                mPrev = curr;
            }
            if (ctr == m) {
                mCurr = curr;
            }
            if (ctr == m + 1) {
                mNext = curr;
            }
            //
            if (ctr == n - 1) {
                nPrev = curr;
            }
            if (ctr == n) {
                nCurr = curr;
            }
            if (ctr == n + 1) {
                nNext = curr;
            }
            ctr++;
            curr = curr.next;
        }
        if(nPrev!=null)
            nPrev.next = mCurr;
        if(mCurr!=null)
            mCurr.next = nNext;

        if(mPrev!=null)
            mPrev.next = nCurr;
        if(nCurr!=null)
            nCurr.next = mNext;
        if(m == 1 || n == 1){
            head = nCurr;
        }
        return head;
    }

    private static void print(ListNode head) {
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
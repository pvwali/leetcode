import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class AddTwoNumbers {
    ListNode l = null;
    ListNode h = null;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cy = 0;
        while (l1 != null || l2 != null) {
            cy = add(l1, l2, cy);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (cy != 0) {
            l.next = new ListNode(cy);
        }
        return h;
    }

    int add(ListNode l1, ListNode l2, int cy) {
        int sum =
                (l1 == null ? 0 : l1.val)
                        + (l2 == null ? 0 : l2.val)
                        + cy;
        cy = sum / 10;
        int ans = sum % 10;
        insert(ans);
        return cy;
    }

    void insert(int val) {
        if (l == null) {
            l = new ListNode(val);
            h = l;
        } else {
            l.next = new ListNode(val);
            l = l.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
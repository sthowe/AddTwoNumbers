/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode l4 = l3;
        int[] sum = new int[101];
        int count = 0;
        boolean carry = false;

        while (l1 != null || l2 != null || carry) {
            if (l1 == null && l2 == null) {
                sum[count++] = 1;
                break;
            } else if (l1 == null) {
                sum[count] += l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                sum[count] += l1.val;
                l1 = l1.next;
            } else {
                sum[count] += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }

            if (carry) {
                sum[count]++;
                carry = false;
            }
            if (sum [count] > 9) {
                carry = true;
                sum[count] -= 10;
            }

            count++;
        }

        for (int i = 0; i < count; i++) {
            l3.val = sum[i];
            if (i < (count - 1)) {
                l3.next = new ListNode();
                l3 = l3.next;
            }
        }

        return l4;
    }
}
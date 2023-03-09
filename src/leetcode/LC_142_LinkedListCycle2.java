package LeetCode;

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * Do not modify the linked list.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 * Constraints:
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class LC_142_LinkedListCycle2 {
    /**
     * - Linked List
     * - Two Pointer
     * - Fast and slow pointer
     *
     * Explanation:
     * 0. If they didn't meet there isn't any cycle
     * 1. When they meet,
     *     L1 = Dist b/w head and cycle start
     *     L2 = Dist b/w cycle start and meeting point
     *     C = Length of the circle
     *
     *      Slow travelled = L1 + L2
     *      Fast travelled  = L1 + L2 + n*C
     *
     *      We know that dist travlled by fast is twice as slow
     *       => 2(L1 +L2) = L1 + L2 + n*C
     *       => L1 + L2 = n*C
     *       => L1 = (n-1)*C + (C- L2)*
     *       => L1 = (C-L2)*     [ Removed (n-1)*C as it is not our focus]
     *       From above, we got know that when the single step hop from start 
     *       and another single step hop from meeting point, when they meet, 
     *       that is the cycle point
     */

    // Definition for singly-linked list.
      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode oneStep = head;
            ListNode twoStep = head;

            do{
                if(twoStep == null || twoStep.next == null)
                    return null;
                oneStep = oneStep.next;
                twoStep = twoStep.next.next;
            }while(oneStep != twoStep);

            oneStep = head;
            while(oneStep != twoStep){
                oneStep = oneStep.next;
                twoStep = twoStep.next;
            }
            return oneStep;
        }
    }
}

package LinkedList;

/**
 * 203. 移除链表元素/力扣203题
 *
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 *
 *
 * 提示：
 *     列表中的节点数目在范围 [0, 104] 内
 *     1 <= Node.val <= 50
 *     0 <= val <= 50
 */

/**
 * @author zxx
 * @date 2022/01/26 10:07
 **/
public class RemoveElements {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead  = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead ;
        while (temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }

        return dummyHead.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements2(head.next, val);

        // 如果 head的节点值等于 val，则 head需要被删除，因此删除操作后的头节点为 head.next
        //如果 head 的节点值不等于 val，则 head 保留，因此删除操作后的头节点还是 head
        return head.val == val ? head.next : head;
    }


    public static void main(String[] args) {
        ListNode dummyHead1  = new ListNode(1);
        ListNode dummyHead2 = new ListNode(2);
        ListNode dummyHead3  = new ListNode(6);
        ListNode dummyHead4  = new ListNode(3);
        ListNode dummyHead5  = new ListNode(4);
        ListNode dummyHead6  = new ListNode(5);
        ListNode dummyHead7  = new ListNode(6);
        dummyHead1.next = dummyHead2;
        dummyHead2.next = dummyHead3;
        dummyHead3.next = dummyHead4;
        dummyHead4.next = dummyHead5;
        dummyHead5.next = dummyHead6;
        dummyHead6.next = dummyHead7;

        System.out.println(removeElements2(dummyHead1,6));



    }
}

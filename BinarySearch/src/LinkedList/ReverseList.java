package LinkedList;
/**
 * 206. 反转链表/力扣206
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 */

import pratice.ReverseListNode;

/**
 * @author zxx
 * @date 2022/01/26 14:01
 **/
public class ReverseList {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode node) {
        // 1->2->3->4

        //1.准备两个空结点 pre用来保存先前结点、next用来做临时变量
        ListNode pre = null;
        ListNode next;

        while (node != null){
            //2.1 node默认为1
            //2.2 node.next则为节点2
            //2.3 node.next 赋值给next 临时变量
            next = node.next;

            //3.pre 默认为空 赋值给 node.next
            node.next = pre;

            //4.node为 1，赋值给pre = next = 1
            pre = node;

            //5. next为2，赋值给node = next = 2
            node = next;

            //第二次遍历情况
            //6.1node.next为3
            //6.2next = node.next = 3
            //next = node.next;

            //7.1上一轮循环 pre为1
            //7.2 node.next = pre 则代表2->1
            //node.next = pre;

            //8. 此时node为 2，赋值给pre =2
            //pre = node;

            //9.此时next=3，赋值给node=3
            //node = next;
            //循环直到node为空退出循环
        }
        //输出翻转后的list
        return pre;
    }

    public static ListNode reverseList2(ListNode head) {
        // 1->2->3->4
        //head->head.next

        //1.准备两个空结点 pre用来保存先前结点、next用来做临时变量
        ListNode dummyHead  = new ListNode();
        dummyHead.next = head;

        while (head != null){
            //dnext = 1->2->3->4
            ListNode dnext = dummyHead.next ;
            //hnext = 2->3->4
            ListNode hnext =head.next;

            //    head.next  = 1->3->4
            head.next = head.next.next;

            // dummyHead.next  = dummyHead->2->3->4
            dummyHead.next = hnext;

            //dnext = 1->3->4
            //hnext.next = dummyHead->2->1->3->4
            hnext.next = dnext;

            System.out.println(1);




        }
        //输出翻转后的list
        return dummyHead.next;
    }



    public static void main(String[] args) {
        ListNode dummyHead1  = new ListNode(1);
        ListNode dummyHead2 = new ListNode(2);
        ListNode dummyHead3  = new ListNode(3);
        ListNode dummyHead4  = new ListNode(4);
        dummyHead1.next = dummyHead2;
        dummyHead2.next = dummyHead3;
        dummyHead3.next = dummyHead4;
        System.out.println(reverseList2(dummyHead1));
    }

}

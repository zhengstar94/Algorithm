package pratice;

/**
 * 翻转链表
 *
 * @author zxx
 * @date 2022/01/12 13:49
 **/
public class ReverseListNode {

    public static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 方法一：遍历法
     * @param node
     * @return
     */
    public static ListNode  reverseList(ListNode  node) {
        // 1->2->3->4

        //1.准备两个空结点 pre用来保存先前结点、next用来做临时变量
        ListNode  pre = null;
        ListNode  next;
        //节点不为空的情况
        while (node != null) {
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
        return pre;
    }

    /**
     * 方法二：迭代法
     *
     * 递归实质上就是系统帮你压栈的过程，系统在压栈的时候会保留现场。
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        // 1->2->3->4

        //如果头结点 或者 头节点下的next为空，直接弹出头结点
        if (head == null || head.next == null)
        {
            return head;
        }

        //1. 假设现在递归到了3节点，head.next就为4，并赋值给temp = 4
        ListNode temp = head.next;

        //2. reverse(4) 进入迭代后，返回的就是4，说明 newHead = 4
        ListNode newHead = reverse(head.next);

        //3.head = 3  且 temp.next = head 说明此时 4->3,temp的下个节点为3
        temp.next = head;

        //把head.next = null 说明 3结点指向4结点的指针断掉
        head.next = null;

        //当retuen后，系统会恢复2结点压栈时的现场，此时的head=2结点；temp=head.next(3结点)，
        // 之后temp.next = head，3->2
        // head.next = null，再断开2节点指向3节点的指针
        return newHead;
    }



}



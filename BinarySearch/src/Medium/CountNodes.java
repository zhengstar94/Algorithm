package Medium;
/**
 * 222. 完全二叉树的节点个数/ 力扣222
 *
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 *
 * 示例 2：
 * 输入：root = []
 * 输出：0
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 *
 * 提示：
 *
 *     树中节点的数目范围是[0, 5 * 104]
 *     0 <= Node.val <= 5 * 104
 *     题目数据保证输入的树是 完全二叉树
 */

/**
 * @author zxx
 * @date 2022/02/11 09:40
 **/
public class CountNodes {

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        //low = 2^level,high = 2^level+1 - 1
        //代表最底层节点的数的范围[2^level,2^level+1 - 1]
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * 此处位运算的解释
     *     1            h = 0
     *    / \
     *   2   3          h = 1
     *  / \  /
     * 4  5 6           h = 2
     * 现在这个树中的值都是节点的编号，最底下的一层的编号是[2^h ，2^h+1 - 1]，现在h = 2，也就是4, 5, 6, 7。
     *
     * 4, 5, 6, 7对应二进制分别为 100 101 110 111 不看最左边的1，从第二位开始，0表示向左，1表示向右，
     * 正好可以表示这个节点相对于根节点的位置。
     *
     * 比如4的 00 就表示从根节点 向左 再向左。6的 10 就表示从根节点 向右 再向左
     *
     * 那么想访问最后一层的节点就可以从节点的编号的二进制入手。从第二位开始的二进制位表示了最后一层的节点相对于根节点的位置。
     * 那么就需要一个bits = 2^(h - 1) 上面例子中的bits就是2，对应二进制为010。这样就可以从第二位开始判断。
     * （树三层高，需要向左或向右走两次才能到叶子）
     *
     * 比如看5这个节点存不存在，先通过位运算找到编号为5的节点相对于根节点的位置。010 & 101 发现第二位是0，说明从根节点开始，第一步向左走。
     * 之后将bit右移一位，变成001。001 & 101 发现第三位是1，那么第二步向右走。
     * 最后bit为0，说明已经找到编号为5的这个节点相对于根节点的位置，看这个节点是不是空，不是说明存在，exist返回真
     * 编号为5的节点存在，说明总节点数量一定大于等于5。所以二分那里low = mid
     *
     * 再比如看7存不存在，010 & 111 第二位为1，第一部从根节点向右；001 & 111 第三位也为1，第二步继续向右。
     * 然后判断当前节点是不是null，发现是null，exist返回假。
     * 编号为7的节点不存在，说明总节点数量一定小于7。所以high = mid - 1
     *
     * 注意：
     * bits = 2^(h - 1)的推导：
     *
     * 首先得想到最后一层第一个节点的编号是 2^h，也就是1左移h位，变成100...0000 ,
     * 然后题解中也说了除去最左边的1，第二位到最后一位表示了这个节点相对于根节点的位置，
     * 那么就需要一个可以从100....0000的第二位开始提取信息（二进制位）的东西，
     * 那么不就是1左移h - 1位（2^(h-1)）嘛，这样使bits的最开头的1正好对着最后一层节点编号二进制的第二位，
     * 然后&一下就可以判断是1还是0了
     *
     *
     * @param root
     * @param level
     * @param k
     * @return
     */
    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }



    public static void main(String[] args) {

    }
}

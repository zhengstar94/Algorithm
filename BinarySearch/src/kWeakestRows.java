/**
 *
 * 力扣1337
 *
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 *
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 * 示例 1：
 *
 * 输入：mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 *
 * 示例 2：
 *
 * 输入：mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 *
 *
 *
 * 提示：
 *
 *     m == mat.length
 *     n == mat[i].length
 *     2 <= n, m <= 100
 *     1 <= k <= m
 *     matrix[i][j] 不是 0 就是 1
 *
 **/

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zxx
 * @date 2021/12/14 16:40
 **/
public class kWeakestRows {
    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        List<int[]> power = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            int pos = -1;

            //利用二分法去统计每一行1的个数
            while (left <= right) {
                //找出中间的数
                int mid = left + (right - left) / 2;

                //如果i行中间的数刚好为0，则需要右边往左移
                if (mat[i][mid] == 0) {
                    right = mid - 1;
                } else {
                    //如果i行中间的数不为0，说明mid位置是1，说明有mid个1，需要左边往右移动继续查找
                    //注意，mid是下标值
                    pos = mid;
                    left = mid + 1;
                }
            }

            //pos+1的原因是因为mid是数组的下标值
            power.add(new int[]{pos+1,i});
        }

        //优先队列内部排序
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //先判断数组第一个元素是否相等，如果不等，则通过大小进行排序，比如[1,0],[0,1]
                //第一个是战斗力，第二个是所在行数
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    //如果战斗力相同的情况下，需要判断他们所在行数，默认小的在最前面
                    return o1[1] - o2[1];
                }
            }
        });


        for (int[] ints : power) {
            //把值从队尾进行插入
            priorityQueue.offer(ints);
        }

        int[] res = new int[k];
        int start = 0;
        for (int i = 0; i < k; i++) {
            //priorityQueue.poll() 默认取出第一个int对象比如[0,1],第二个元素则为所在行数
            res[i] = priorityQueue.poll()[1];
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] mat = {{1,0},{0,0},{1,0}};
        int target = 2;

        System.out.println(Arrays.toString(kWeakestRows(mat,target)));
    }
}

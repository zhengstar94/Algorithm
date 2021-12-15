/**
 *
 * 力扣 1351
 *
 *
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 *
 * 请你统计并返回 grid 中 负数 的数目。
 *
 * 示例 1：
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 *
 * 示例 2：
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 *
 * 示例 3：
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 *
 * 示例 4：
 * 输入：grid = [[-1]]
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     m == grid.length
 *     n == grid[i].length
 *     1 <= m, n <= 100
 *     -100 <= grid[i][j] <= 100
 **/

import java.util.Arrays;

/**
 * @author zxx
 * @date 2021/12/15 15:55
 **/
public class CountNegatives {
    public static int countNegatives(int[][] grid) {
            //行
            int m = grid.length;
            //列
            int n = grid[0].length;
            int sum = 0;

        for (int i = 0; i < m ; i++) {
            int left = 0;
            int right = n-1;
            int count = 0;

            while (left <= right)
            {
                //找出中间的数
                int mid = left + (right - left) / 2;

                if(grid[i][mid] < 0)
                {
                    //n代表列，
                    // 比如[2,1,-1],-1的下标是2，n为3，所以个数是n-2=1;
                    // 比如[2,-1,-2],-1的下标是2，n为3，所以个数是n-1=2;
                    count = n - mid;

                    //如果mid对应位置是负数，那么需要右边往左移动
                    right = mid -1;
                }else
                {
                    //如果mid对应位置不是负数，那么需要左边往右移动，
                    left = mid + 1;
                }
            }

            sum += count;

        }

            return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(mat));
    }
}

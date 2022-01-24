package Medium;

/**
 * 74. 搜索二维矩阵 力扣74题
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *     每行中的整数从左到右按升序排列。
 *     每行的第一个整数大于前一行的最后一个整数。
 *
 * 示例 1：
 * 1    3   5   7
 * 10  11  16  20
 * 23  30  34  60
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 示例 2：
 * 1    3   5   7
 * 10  11  16  20
 * 23  30  34  60
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * 提示：
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 100
 *     -104 <= matrix[i][j], target <= 104
 */

import sun.security.util.Length;

/**
 * @author zxx
 * @date 2022/01/24 14:14
 **/
public class SearchMatrix {
    public static  boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //使用二分法把每一行全部拼成一行，相当于一行有序的数组
        int left = 0;
        int right = m*n -1;

        while (left <= right){
            int mid = (left + right) / 2;

            //二维数组中间的值
            int x = matrix[mid/n][mid%n];

            if (x < target) {
                left = mid + 1;
            } else if (x > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{ 1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(nums,target));
    }

}

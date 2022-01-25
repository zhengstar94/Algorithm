package Medium;
/**
 * 240. 搜索二维矩阵 II/力扣240
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 *     每行的元素从左到右升序排列。
 *     每列的元素从上到下升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 1   4   7   11   15
 * 2   5   8   12   19
 * 3   6   9   16   22
 * 10  13  14  17   24
 * 18  21  23  26   30
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 示例 2：
 *
 * 1   4   7   11   15
 * 2   5   8   12   19
 * 3   6   9   16   22
 * 10  13  14  17   24
 * 18  21  23  26   30
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 *
 *
 * 提示：
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= n, m <= 300
 *     -109 <= matrix[i][j] <= 109
 *     每行的所有元素从左到右升序排列
 *     每列的所有元素从上到下升序排列
 *     -109 <= target <= 109
 *
 */

/**
 * @author zxx
 * @date 2022/01/25 11:21
 **/
public class SearchMatrix2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index  = search(row,target);
            if(index>=0){
                return true;
            }
        }
        return false;
    }

    public static int search(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            int num = row[mid];

            if(num == target){
                return mid;
            }else if(num < target){
                left = mid + 1;
            }else if(num > target){
                right = mid - 1;
            }
        }
        return -1;

    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;

        //Z型搜索
        while (x<m && y>=0){
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] > target){
                y--;
            }else if(matrix[x][y] < target){
                x++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(searchMatrix2(nums,target));
    }
}

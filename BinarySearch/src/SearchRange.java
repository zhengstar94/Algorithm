/**
 *
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 *     你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 *
 * 提示：
 *     0 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 *     nums 是一个非递减数组
 *     -109 <= target <= 109
 */

import java.util.Arrays;

/**
 * @author zxx
 * @date 2022/01/18 14:46
 **/
public class SearchRange {

    /**
     * 二分查找
     */
    public static int[] searchRange(int[] nums, int target) {
        //寻找左边界(这里寻找第一个 >= target的索引)
        int leftIndex = search(nums, target);
        if (leftIndex >= nums.length || nums[leftIndex] != target){
            return new int[]{-1, -1};
        }
        //寻找右边界(这里寻找第一个 >= target+1的索引)
        int rightIndex = search(nums, target + 1);
        return new int[]{leftIndex, rightIndex - 1};
    }

    /**
     * 寻找第一个>=目标值的索引, 找不到则返回数组长度
     */
    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = {5,7,7,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

}

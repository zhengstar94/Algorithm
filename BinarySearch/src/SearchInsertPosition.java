/**
 * leetcode704 / 力扣35
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 *
 * 示例 5:
 * 输入: nums = [1], target = 0
 * 输出: 0
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 */





/**
 * @author zhengstars
 * @date 2021/12/12
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target)
    {
        //先判断target是否大于最大值，大于则输出最大的len
        int len = nums.length;
        if(nums[len-1] < target)
        {
            return len;
        }

        int left = 0;
        int right = len - 1;
        while(left < right)
        {
            //二分法，先取中间那个数
            int mid = left + (right - left ) / 2;
            //如果中间的数小于输入的值，则说明目标值是在右边的那组，则把最左边的值left设置为mid+1，否则，右边的值为mid
            if(nums[mid] < target)
            {
                left = mid + 1;
            }else
            {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int result = searchInsert(nums,0);
        System.out.println(result);
    }
}

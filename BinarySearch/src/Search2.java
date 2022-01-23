/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I /力扣34
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 *
 *
 * 提示：
 *     0 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 *     nums 是一个非递减数组
 *     -109 <= target <= 109
 *
 */

/**
 * @author zxx
 * @date 2022/01/23 14:17
 **/
public class Search2 {
    public static int search(int[] nums, int target) {

        int right = searchPosition(nums,target);
        int left = searchPosition(nums,target-1);


        return right-left;

    }

    public static int searchPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                left = mid + 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left ;
    }


    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,8,10};
        int target = 10;
        System.out.println(search(nums,target));
    }
}

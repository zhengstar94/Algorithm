package Medium;
/**
 * 81.搜索旋转排序数组 II 力扣81题
 *
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。

 * 示例 1：
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 *
 *
 *
 * 提示：
 *     1 <= nums.length <= 5000
 *     -104 <= nums[i] <= 104
 *     题目数据保证 nums 在预先未知的某个下标上进行了旋转
 *     -104 <= target <= 104
 *
 *
 */

/**
 * @author zxx
 * @date 2022/01/24 14:44
 **/
public class Search2 {

    public static boolean search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return false;
        }

        if(length == 1){
            return nums[0] == target ? true : false;
        }

        int left = 0;
        int right = length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }

            //如果左边右边都等于mid，则直接去掉前后2个的数据
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                ++left;
                --right;
            } else if(nums[left] <= nums[mid]){
                //说明为升序，或者left与mid全是相同的数据

                //说明该值在[0，mid]之间
                if(nums[left] <= target && target < nums[mid] ){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //说明里面包含升降数组

                //说明该值在[mid，length - 1]之间
                if(nums[mid] < target && target <= nums[length - 1] ){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

        }


        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int target = 2;
        System.out.println(search(nums,target));
    }

}

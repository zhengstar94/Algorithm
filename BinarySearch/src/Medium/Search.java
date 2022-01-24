package Medium;

/**
 *
 * 33. 搜索旋转排序数组
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 *
 *
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 *
 *
 * 提示：
 *     1 <= nums.length <= 5000
 *     -10^4 <= nums[i] <= 10^4
 *     nums 中的每个值都 独一无二
 *     题目数据保证 nums 在预先未知的某个下标上进行了旋转
 *     -10^4 <= target <= 10^4
 *
 */

/**
 * @author zxx
 * @date 2022/01/24 10:27
 **/
public class Search {
    public static int search(int[] nums, int target) {
        int length = nums.length;
        //如果数组为空
        if(length==0){
            return -1;
        }

        //如果数组长度为1，直接判断是不是需要的值
        if(length == 1 ){
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //如果nums[0] <= nums[mid]，说明[left,mid]是升序
            if (nums[0] <= nums[mid]) {
                //如果nums[0]小于等于target且target小于nums[mid]，说明target在[left,mid)之间
                if (nums[0] <= target && target < nums[mid]) {
                    //则把范围缩小到[left,mid-1]
                    right = mid - 1;
                } else {
                    //如果nums[0] > target 或者 target >= nums[mid]
                    //说明目标值target在右边区域，范围缩小到[mid+1,right]
                    left = mid + 1;
                }
            } else {
                //如果nums[0] > nums[mid]，说明[left,mid]不是升序，里面是升降数组

                //如果nums[mid] < target && target <= nums[length - 1]，说明target在 [mid,right]内
                if (nums[mid] < target && target <= nums[length - 1]) {
                    //则把范围缩小到[mid+1,right]
                    left = mid + 1;
                } else {
                    //如果nums[0] >= target 或者 target > nums[length - 1]
                    //说明目标值target在右边区域，范围缩小到[left,mid-1]
                    right = mid - 1;
                }
            }
        }


        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 3;
        System.out.println(search(nums,target));
    }
}

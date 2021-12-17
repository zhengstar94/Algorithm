/**
 *
 * 力扣2089
 *
 *
 * 给你一个下标从 0 开始的整数数组 nums 以及一个目标元素 target 。
 *
 * 目标下标 是一个满足 nums[i] == target 的下标 i 。
 *
 * 将 nums 按 非递减 顺序排序后，返回由 nums 中目标下标组成的列表。如果不存在目标下标，
 * 返回一个 空 列表。返回的列表必须按 递增 顺序排列。
 *
 *
 * 示例 1：
 * 输入：nums = [1,2,5,2,3], target = 2
 * 输出：[1,2]
 * 解释：排序后，nums 变为 [1,2,2,3,5] 。
 * 满足 nums[i] == 2 的下标是 1 和 2 。
 *
 * 示例 2：
 * 输入：nums = [1,2,5,2,3], target = 3
 * 输出：[3]
 * 解释：排序后，nums 变为 [1,2,2,3,5] 。
 * 满足 nums[i] == 3 的下标是 3 。
 *
 * 示例 3：
 * 输入：nums = [1,2,5,2,3], target = 5
 * 输出：[4]
 * 解释：排序后，nums 变为 [1,2,2,3,5] 。
 * 满足 nums[i] == 5 的下标是 4 。
 *
 * 示例 4：
 * 输入：nums = [1,2,5,2,3], target = 4
 * 输出：[]
 * 解释：nums 中不含值为 4 的元素。
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 100
 *     1 <= nums[i], target <= 100

 *
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zxx
 * @date 2021/12/17 10:40
 **/
public class TargetIndices {

    public static  List<Integer> targetIndices(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int l = 0, r = len - 1;

        //用于过滤比target小的第一个坐标
        //比如[1,2,2,3,5] target=3
        //则需要找到比3小的最近的下标，第三个2，坐标是2
        while (l <= r){
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        //l 是比target小且最靠近target的那个数
        int left = l;
        l = 0;
        r = len - 1;

        //找到比target大的数，全部过滤掉
        //比如[1,2,2,3,5] target=3
        //则需要找到大于等于3大的最近的下标，所以r = 3
        //注意此处需要输出r进行比较，因为我们是需要找到大于等于target那个数值，如果输出l则会让包含右边闭区间
        while (l <= r){
            int mid = (r - l) / 2 + l;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        //i <= r,原因就是不能大于右边的值
        for (int i = left; i <= r; i++) {
            res.add(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,2,3};
        int target = 4;

        System.out.println(targetIndices(nums,target));

    }
}

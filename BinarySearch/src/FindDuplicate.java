/**
 * 287. 寻找重复数/力扣287
 *
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 *
 *
 *
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 *
 * 示例 3：
 * 输入：nums = [1,1]
 * 输出：1
 *
 * 示例 4：
 * 输入：nums = [1,1,2]
 * 输出：1
 *
 *
 *
 * 提示：
 *     1 <= n <= 105
 *     nums.length == n + 1
 *     1 <= nums[i] <= n
 *     nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *
 *
 *
 * 进阶：
 *     如何证明 nums 中至少存在一个重复的数字?
 *     你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
 *
 *
 */

/**
 * @author zxx
 * @date 2022/01/31 13:00
 **/
public class FindDuplicate {

    /**
     * 二分查找的思路是先猜一个数（有效范围 [left..right] 里位于中间的数 mid），
     * 然后统计原始数组中 小于等于 mid 的元素的个数 cnt：
     *
     * 如果 cnt 严格大于 mid。根据抽屉原理，重复元素就在区间 [left..mid] 里；
     * 否则，重复元素就在区间 [mid + 1..right] 里。
     *
     * 与绝大多数使用二分查找问题不同的是，这道题正着思考是容易的，即：思考哪边区间存在重复数是容易的，因为有抽屉原理做保证。
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            int cnt = 0;
            //统计数字之和
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个，此时重复元素一定出现在 [1..4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left..mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面区间 [mid + 1..right]
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }

}

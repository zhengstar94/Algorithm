package Medium;

/**
 * 209. 长度最小的子数组/力扣209
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 *
 * 提示：
 *     1 <= target <= 109
 *     1 <= nums.length <= 105
 *     1 <= nums[i] <= 105
 *
 *
 *
 * 进阶：
 *     如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 *
 */

import java.util.Arrays;

/**
 * @author zxx
 * @date 2022/01/24 17:06
 **/
public class MinSubArrayLen {
    public static int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;

        //申请一个临时数组 sums，其中 sums[i] 表示的是原数组 nums 前 i 个元素的和
        //如[2，5，7，10，15，18，20]
        //sum[] 数据则为：[0, 2, 7, 14, 24, 39, 57, 77]
        int[] sums = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        //循环遍历
        for (int i = 0; i <= length; i++) {
            //sums[k]-sums[j]>=s 那么 k-j 就是满足的连续子数组，但不一定是最小的
            //所以改成sums[k]  >= sums[j]+s
            //我们只需要求出 sum[j]+s 的值，然后使用二分法查找即可找到这个 k
            //index即为k
            int target = s + sums[i];
            int index = Arrays.binarySearch(sums, target);
            if (index < 0) {
                //按位取反
                index = ~index;
            }
            //如果插入的位置小于长度，说明符合要求
            if (index <= length) {
                min = Math.min(min, index - i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,7,10,15,18,20};
        int target = 9;
        System.out.println(minSubArrayLen(target,nums));
    }

}

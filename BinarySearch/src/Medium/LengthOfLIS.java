package Medium;
/**
 * 300. 最长递增子序列/力扣300
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 *
 *
 * 提示：
 *     1 <= nums.length <= 2500
 *     -104 <= nums[i] <= 104
 *
 *
 *
 * 进阶：
 *     你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 *
 */

/**
 * @author zxx
 * @date 2022/02/11 14:12
 **/
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0 || n == 1) {
            return n;
        }

        //[0,0,0,0,0,0]
        int[] d = new int[n + 1];
        //d[1] = nums[0];
        d[len] = nums[0];

        //遍历数组
        for (int i = 1; i < n; ++i) {
            //如果 d[len] = nums[0] < nums[i]，说明是单调递增的
            if (d[len] < nums[i] ) {
                //d[2] = nums[1]
                d[++len] = nums[i];
            } else {
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0

                //如果是d[len] > nums[i] ,说明num[i]可以放在d[len]中
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                //将nums[i] 放到d[len]中合适的位置，
                d[pos + 1] = nums[i];
            }
        }
        return len;

    }

    public static void main(String[] args) {
        int[] nums = {10,9,8,7};
        System.out.println(lengthOfLIS(nums));
    }
}

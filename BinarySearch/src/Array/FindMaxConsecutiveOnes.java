package Array;

/**
 * 485. 最大连续 1 的个数/力扣485
 *
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 * 示例：
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 *
 *
 * 提示：
 *     输入的数组只包含 0 和 1 。
 *     输入数组的长度是正整数，且不超过 10,000。
 *
 *
 */

/**
 * @author zxx
 * @date 2022/01/25 15:03
 **/
public class FindMaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        if(nums.length == 1 && nums[0] == 1){
            return 1;
        }

        int index = 0;
        int sum = 0;
        for (int num :nums){
            if(num == 1){
                sum++;

            }else{
                index = Math.max(index, sum);
                sum = 0;
            }
        }


        return Math.max(index, sum);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}

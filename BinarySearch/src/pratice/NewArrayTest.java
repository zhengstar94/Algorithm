package pratice;

/**
 * @author zxx
 * @date 2022/01/22 10:04
 **/
public class NewArrayTest {

    /**
     * 前缀和数组
     */
    private static int[] preSum;

    /**
     * 输⼊⼀个数组，构造前缀和
     * @param nums
     */
    public static void NumArray(int[] nums) {
        // preSum[0] = 0，便于计算累加和
        preSum = new int[nums.length + 1];
        // 计算 nums 的累加和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    /**
     * 查询闭区间 [left, right] 的累加和
     * @param left
     * @param right
     * @return
     */
    public static int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

    public static void main(String[] args) {
        int[] nums = {3,5,2,-2,4,1};
        NumArray(nums);
        System.out.println(sumRange(0,1));

    }
}

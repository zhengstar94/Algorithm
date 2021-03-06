/**
 *
 * 力扣167题
 *
* 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 *
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 *
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *
 *
 *
 * 提示：
 *
 *     2 <= numbers.length <= 3 * 104
 *     -1000 <= numbers[i] <= 1000
 *     numbers 按 非递减顺序 排列
 *     -1000 <= target <= 1000
 *     仅存在一个有效答案
* */


import java.util.Arrays;

/**
 * @author zxx
 * @date 2021/12/13 11:33
 **/
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i+1;
            int right = numbers.length-1;

            while (left<=right)
            {
                //先取中间值,长度的中间值，比如数组是[2,7,11,15,18,22],则中间值是
                //不使用int mid = (left+right)/2 防止溢出计算mid错误
                int mid = left + (right-left) /2;
                //如果中间值为目标值target-第一个值，则直接输出位置
                if(numbers[mid] == target - numbers[i])
                {
                    //因为题目是把数组第一个元素下标作为1，所以需要i+1，mid同理
                    return new int[]{i+1,mid+1};
                }else if(numbers[mid] > target - numbers[i])
                {
                    //如果中间值大于目标值target-第一个值，说明该值应该要在mid的左边，即right为mid-1
                    right = mid - 1;
                }else
                {
                    //如果中间值小于目标值target-第一个值，说明该值应该要在mid的右边，即right为mid+1
                    left = mid + 1;
                }
            }
        }
        //如果都不符合，输出错误值
        return new int[]{-1,-1};
    }


    public static void main(String[] args) {
        int[] sum = new int[]{2,7,11,15,18,22};
        System.out.println(Arrays.toString(twoSum(sum,13)));

    }
}

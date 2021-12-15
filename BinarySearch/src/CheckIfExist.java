/**
 *
 * 力扣1346
 *
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 *
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 *
 *     i != j
 *     0 <= i, j < arr.length
 *     arr[i] == 2 * arr[j]
 *
 *
 *
 * 示例 1：
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 *
 * 示例 2：
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 *
 * 示例 3：
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 *
 *
 *
 * 提示：
 *
 *     2 <= arr.length <= 500
 *     -10^3 <= arr[i] <= 10^3
 *
 *
 **/

import java.util.*;

/**
 * @author zxx
 * @date 2021/12/15 15:02
 **/
public class CheckIfExist {

    public static boolean checkIfExist(int[] arr) {

        //用于去重
        Set<Integer> set = new HashSet<Integer>();

        int left = 0;
        int right = arr.length-1;

        for (int item:arr)
        {
            //如果存在相同的直接输出
            if(set.contains(item))
            {
                return true;
            }

            //先放入2倍的值
            set.add(2*item);

            //如果这个数能整除2，也放进set中，防止把比它小且在它后面的数过滤掉，比如[2，1]这种情况
            if(item%2==0)
            {
                set.add(item/2);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{3,1,7,11}));
    }

}

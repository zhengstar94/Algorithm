/**
 *
 * 力扣367
 *
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 *
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 *
 *
 *
 * 提示：
 *
 *     1 <= num <= 2^31 - 1
 *
 *
* */

/**
 * @author zxx
 * @date 2021/12/13 16:53
 **/
public class PerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1)
        {
            return true;
        }

        //使用long类型防止计算的时候精度丢失
        long left = 0;
        long right = num;


        while(left <= right)
        {
            //先找出中间的数
            long mid = left + (right-left)/2;
            if(num == mid*mid)
            {
                return true;
            }else if(num/mid < mid)
            {
                right = mid - 1;
            }else
            {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
}

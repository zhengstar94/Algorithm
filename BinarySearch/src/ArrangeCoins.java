/**
 *
 * 力扣441
 *
 *你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 *
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 * n = 5
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * 因为第三行不完整，所以返回2.
 *
 * 示例 2:
 * 输入: n = 8
 * 输出: 3
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 因为第四行不完整，所以返回3.
 *
 **/

/**
 * @author zxx
 * @date 2021/12/14 13:37
 **/
public class ArrangeCoins {

    public static int arrangeCoins(int n) {
        //1.依照题目可知，至少能放下一枚硬币且有一行，left为1，而且最多不会超过n行
        //2.依旧等差数列，
        // 第一行1个、共1个
        // 第二行2个、共3个
        // 第三行3个、共6个
        //(N+1)*N/2为等差基本公式

        if(n <= 0)
        {
            return 0;
        }

        long left = 1;
        long right = n;

        while(left <= right)
        {
            //先取中间数作为行
            long mid = left + (right - left) / 2;

            //计算中间行的总数
            long count = (mid+1)*mid/2;

            //如果mid行总数与总硬币数相等，说明刚好放完
            if(n == count)
            {
                return (int)mid;
            }else if(n > count)
            {
                //排mid行用的硬币数没超过n枚，可能还能多排几行
                left = mid + 1;
            }else
            {
                //排mid行用的硬币数已经超过n枚，应该减少行数
                right = mid - 1;
            }
        }

        //注意此处为right的原因，因为进行最后一次比较的时候，如果不是刚好相等，那么就是没放满，所以行数应该是选择right
        return (int)right;
    }


    public static void main(String[] args) {
        System.out.println(arrangeCoins(9));
    }
}

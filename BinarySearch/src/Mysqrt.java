/**
 * 剑指 Offer II 072. 求平方根，与力扣69相同
 *
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 *
 * 正数的平方根有两个，只输出其中的正数平方根。
 *
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: x = 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: x = 8
 * 输出: 2
 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 *
 *
 *
 * 提示:
 * 0 <= x <= 231 - 1
 */

/**
 * @author zxx
 * @date 2022/01/22 10:17
 **/
public class Mysqrt {

    public static int mySqrt(int x) {

        if(x==0 || x==1){
            return x;
        }

        int left = 1;
        int right = x;

        int ans = -1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if(mid == x/mid){
                return mid;
            }else if(mid < x/mid){
                ans = mid;
                left = mid + 1;
            }else if(mid > x/mid){
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
    }
}

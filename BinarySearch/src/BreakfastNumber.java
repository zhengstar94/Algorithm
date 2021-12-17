/**
 *
 * LCP18,早餐组合
 *
 * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，
 * 一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。
 * 请返回小扣共有多少种购买方案。
 *
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 *
 * 示例 1：
 *     输入：staple = [10,20,5], drinks = [5,5,2], x = 15
 *     输出：6
 *
 *     解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 *     第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
 *     第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
 *     第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
 *     第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
 *     第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
 *     第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
 *
 * 示例 2：
 *     输入：staple = [2,1,1], drinks = [8,9,5,1], x = 9
 *     输出：8
 *
 *     解释：小扣有 8 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 *     第 1 种方案：staple[0] + drinks[2] = 2 + 5 = 7；
 *     第 2 种方案：staple[0] + drinks[3] = 2 + 1 = 3；
 *     第 3 种方案：staple[1] + drinks[0] = 1 + 8 = 9；
 *     第 4 种方案：staple[1] + drinks[2] = 1 + 5 = 6；
 *     第 5 种方案：staple[1] + drinks[3] = 1 + 1 = 2；
 *     第 6 种方案：staple[2] + drinks[0] = 1 + 8 = 9；
 *     第 7 种方案：staple[2] + drinks[2] = 1 + 5 = 6；
 *     第 8 种方案：staple[2] + drinks[3] = 1 + 1 = 2；
 *
 * 提示：
 *
 *     1 <= staple.length <= 10^5
 *     1 <= drinks.length <= 10^5
 *     1 <= staple[i],drinks[i] <= 10^5
 *     1 <= x <= 2*10^5
 *
 **/

import java.util.Arrays;

/**
 * @author zxx
 * @date 2021/12/17 11:38
 **/
public class BreakfastNumber {

    public static int breakfastNumber(int[] staple, int[] drinks, int x) {

        int result = 0;
        //排序
        Arrays.sort(staple);
        Arrays.sort(drinks);


        int j = drinks.length - 1;

        //循环逼近，跳出循环的条件是，j小于0(从后往前) 并且i小于staple长度(从前往后)
        for (int i = 0 ; i < staple.length && j >= 0; ) {
            //staple的首+drinks的尾是否小于等于x
            if (staple[i] + drinks[j] <= x) {
                //如果是的话，说明staple第一个数 与 drinks最大的数相加都不会超过x
                //因为j是下标，所以j+1就为第一次遍历的个数集合
                //日后i的位置移动第二位
                result += j + 1;
                i++;
            } else {
                //如果不是的话，说明drinks最大的数与staple第一个数超过x
                //所以drinks往左边移动一个位置
                j--;
            }

            //由于
            //1 <= staple.length <= 10^5
            //1 <= drinks.length <= 10^5
            //所以可能会导致结果溢出，所以需要对1000000007进行求模
            result %= 1000000007;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] staple = {5,5,2};
        int[] drinks = {10,20,5};
        System.out.println(breakfastNumber(staple,drinks,15));
    }

}

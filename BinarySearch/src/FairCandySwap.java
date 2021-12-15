/**
 *
 * 力扣888
 *
 *
 * 爱丽丝和鲍勃拥有不同总数量的糖果。给你两个数组 aliceSizes 和 bobSizes ，
 * aliceSizes[i] 是爱丽丝拥有的第 i 盒糖果中的糖果数量，bobSizes[j] 是鲍勃拥有的第 j 盒糖果中的糖果数量。
 *
 * 两人想要互相交换一盒糖果，这样在交换之后，他们就可以拥有相同总数量的糖果。一个人拥有的糖果总数量是他们每盒糖果数量的总和。
 *
 * 返回一个整数数组 answer，其中 answer[0] 是爱丽丝必须交换的糖果盒中的糖果的数目，answer[1] 是鲍勃必须交换的糖果盒中的糖果的数目。
 * 如果存在多个答案，你可以返回其中 任何一个 。题目测试用例保证存在与输入对应的答案。
 *
 *
 *
 * 示例 1：
 * 输入：aliceSizes = [1,1], bobSizes = [2,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：aliceSizes = [1,2], bobSizes = [2,3]
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：aliceSizes = [2], bobSizes = [1,3]
 * 输出：[2,3]
 *
 * 示例 4：
 * 输入：aliceSizes = [1,2,5], bobSizes = [2,4]
 * 输出：[5,4]
 *
 * 提示：
 *
 *     1 <= aliceSizes.length, bobSizes.length <= 104
 *     1 <= aliceSizes[i], bobSizes[j] <= 105
 *     爱丽丝和鲍勃的糖果总数量不同。
 *     题目数据保证对于给定的输入至少存在一个有效答案。
 *
 *
 **/


import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zxx
 * @date 2021/12/15 10:49
 **/
public class FairCandySwap {

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        //先进行排序
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        int aliceSum = 0;
        int bobSum = 0;

        for (int item: aliceSizes) {
            aliceSum += item;
        }

        for (int item: bobSizes) {
            bobSum += item;
            map.put(item,null);
        }



        //可以这样理解此条公式
        //1.设爱丽丝和鲍勃的糖果总数分别为sumA和sumB，交换的糖果数分别为xA和xB，由此我们有等式：
        // sumA−xA+xB=sumB+xA−xB
        // xA = (sumA-sumB)/2 + xB
        // xB = xA - (sumA-sumB)/2
        // xA - xB = (sumA-sumB)/2;

        //(aliceSum + bobSum) / 2 代表平分的数量
        //mid 代表aliceSum与平分的数量之差,即alice的糖果中，减去差值就为对应bob需要交换的糖果
        //可以这样理解，因为必定有2个值交换使得双方糖果相等
        // xA - xB = temp
        // xA - xB = (sumA-sumB)/2;

        int temp = (aliceSum - bobSum) / 2;

        int left =0;
        int right=0;

        while(left<aliceSizes.length && right< bobSizes.length)
        {
            //如果相等直接输出
            if(aliceSizes[left]-bobSizes[right] == temp)
            {
                return new int[]{aliceSizes[left],bobSizes[right]};
            }

            //如果alice-bob 小于差值，说明alice太少，alice需要往右边移动变大
            if(aliceSizes[left]-bobSizes[right] < temp)
            {
                left ++;
            }else
            {
                //如果alice-bob 大于差值，说明alice太多，bob需要往右边移动变大
                right++;
            }

        }

        return null;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,1};
        int[] num2 = new int[]{2,2};
        System.out.println(Arrays.toString(fairCandySwap(num1,num2)));
    }
}

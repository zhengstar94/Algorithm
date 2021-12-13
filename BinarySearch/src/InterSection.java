/**
 * 力扣349
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 *
 * 说明：
 *
 *     输出结果中的每个元素一定是唯一的。
 *     我们可以不考虑输出结果的顺序。
**/

import java.util.*;

/**
 * @author zxx
 * @date 2021/12/13 14:44
 **/
public class InterSection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(null == nums1 || null == nums2)
        {
            return null;
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int item: nums1)
        {
            set1.add(item);
        }

        for (int item: nums2) {
            if(set1.contains(item))
            {
                set2.add(item);
            }
        }

        int[] result = new int[set2.size()];
        int start = 0;
        for (int item: set2) {
            result[start] = item;
            start++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{4,9,5};
        int[] num2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(num1,num2)));
    }
}

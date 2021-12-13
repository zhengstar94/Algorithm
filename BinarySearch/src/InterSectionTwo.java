/**
 * 力扣350
 *
 *
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 *
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 *
 *
 * 提示：
 *     1 <= nums1.length, nums2.length <= 1000
 *     0 <= nums1[i], nums2[i] <= 1000
 *
 * 进阶：
 *     如果给定的数组已经排好序呢？你将如何优化你的算法？
 *     如果 nums1 的大小比 nums2 小，哪种方法更优？
 *     如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 *
 *     此题注意点，与349不同的是，349交集去重，350是不去重
 *
* */

import java.util.*;

/**
 * @author zxx
 * @date 2021/12/13 15:50
 **/
public class InterSectionTwo {

    public static int[] intersect(int[] nums1, int[] nums2) {
        //先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> section = new ArrayList<Integer>();
        int left = 0;
        int top = 0;


        while (true)
        {
            //用于退出循环，当nums1或者nums2全部遍历完需要退出循环，或者为空的时候
            if(left >= nums1.length || top >= nums2.length)
            {
               break;
            }

            //如果两个相等，需要加入到列表中
            if(nums1[left] == nums2[top])
            {
                section.add(nums1[left]);
                left++;
                top++;
            }else if(nums1[left] < nums2[top])
            {
                //如果num1的值小于num2的值，num1需要开始右移一个位置找下个数，继续与nums2进行比较
                left++;
            }else
            {
                //如果num1的值大于num2的值，num2需要开始右移一个位置找下个数，继续与nums1进行比较
                top++;
            }
        }

        int[] result = new int[section.size()];
        int start = 0;
        for (int item: section) {
            result[start] = item;
            start++;
        }
        return result;

    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        //目的为了设置数组的size，交集使用最小的集合就可以了，节约空间
        if(nums1.length > nums2.length)
        {
            return intersect2(nums2,nums1);
        }

        //1.先把nums1的数据放到map中
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int item : nums1)
        {
            int count = map.getOrDefault(item,0) + 1;
            map.put(item,count);
        }

        int[] result = new int[nums1.length];
        int index = 0;
        for (int item : nums2)
        {
            //2.从map中取值，判断nums2的值是否在map中
            int count = map.getOrDefault(item,0);
            //3.如果count大于0说明存在
            if(count>0)
            {
                //4.放到数组中，并将计数-1
                result[index++] = item;
                count--;

                //5.如果依旧大于0，说明map里面有相同的值，需要重新把值与计数放到map中
                if(count>0)
                {
                    map.put(item,count);
                }else
                {
                    //6.如果小于0，则删除该值
                    map.remove(item);
                }

            }
        }

        return Arrays.copyOfRange(result,0,index);
    }





    public static void main(String[] args) {
        int[] num1 = new int[]{4,9,5,4};
        int[] num2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersect2(num1,num2)));
    }

}

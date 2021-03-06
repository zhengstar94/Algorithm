/**
 * 面试题 08.03. 魔术索引
 *
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，
 * 若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 * 示例1:
 *  输入：nums = [0, 2, 3, 4, 5]
 *  输出：0
 *  说明: 0下标的元素为0
 *
 * 示例2:
 *  输入：nums = [1, 1, 1]
 *  输出：1
 *
 * 说明:
 *     nums长度在[1, 1000000]之间
 *     此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 *
 */

/**
 * @author zxx
 * @date 2022/01/23 19:24
 **/

public class FindMagicIndex {
    public static int findMagicIndex(int[] nums) {
        return getAnswer(nums,0,nums.length-1);
    }

    public static int getAnswer(int[] nums,int left,int right) {
        if(left > right){
            return -1;
        }

        int mid = left + (right - left)/2;
        //先查询左半部分
        int leftAnswer = getAnswer(nums,left,mid-1);
        //如果左半部分查到，则输出
        if(leftAnswer !=-1){
            return leftAnswer;
        }else if(nums[mid] == mid) {
            return mid;
        }

        //如果左半部分没有找到合适的数据，则从右半部分查询
        return getAnswer(nums, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(findMagicIndex(nums));
    }

}

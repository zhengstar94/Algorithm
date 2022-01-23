/**
 * 剑指 Offer 11. 旋转数组的最小数字 /力扣154
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，
 * 并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，
 * 该数组的最小值为1。
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 */

/**
 * @author zxx
 * @date 2022/01/23 18:17
 **/
public class MinArray {
    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right){
            int mid = left + (right - left)/2;
            if(numbers[mid] == numbers[right]){
                //缩小右边边界，指针往右移动
                right --;
            }else if(numbers[mid] < numbers[right]){
                //如果右边比mid的值大，说明[mid,right)是正常数组，mid前面的数有最小值，
                //mid赋值给right，不能用mid-1的原因是怕把mid去掉，mid可能是最小值
                right = mid;
            }else if(numbers[mid] > numbers[right]){
                //如果右边比mid的值小，说明[mid,right)是反正常数组，mid后面的数有最小值
                left = mid + 1;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3};
        System.out.println(minArray(nums));
    }

}
